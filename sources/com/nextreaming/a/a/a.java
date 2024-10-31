package com.nextreaming.a.a;

import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.keyczar.Keyczar;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f4446a = Charset.forName(Keyczar.DEFAULT_ENCODING);
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private final long f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap<String, b> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new com.nextreaming.a.a.b(this);

    private static <T> T[] a(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, i, tArr2, 0, min);
        return tArr2;
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read != 10) {
                sb.append((char) read);
            } else {
                int length = sb.length();
                if (length > 0 && sb.charAt(length - 1) == '\r') {
                    sb.setLength(length - 1);
                }
                return sb.toString();
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            Log.e("DiskLruCache", "not a directory: " + file);
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private a(File file, int i, int i2, long j) {
        this.b = file;
        this.e = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.g = i2;
        this.f = j;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.c.exists()) {
            try {
                aVar.d();
                aVar.e();
                aVar.i = new BufferedWriter(new FileWriter(aVar.c, true), Utility.DEFAULT_STREAM_BUFFER_SIZE);
                return aVar;
            } catch (IOException e) {
                Log.w("DiskLruCache", "DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.c();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.f();
        return aVar2;
    }

    private void d() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.c), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        try {
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            String a6 = a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(a2) || !AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a3) || !Integer.toString(this.e).equals(a4) || !Integer.toString(this.g).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            while (true) {
                try {
                    d(a((InputStream) bufferedInputStream));
                } catch (EOFException e) {
                    return;
                }
            }
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    private void d(String str) throws IOException {
        b bVar;
        com.nextreaming.a.a.b bVar2 = null;
        String[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = split[1];
        if (split[0].equals("REMOVE") && split.length == 2) {
            this.j.remove(str2);
            return;
        }
        b bVar3 = this.j.get(str2);
        if (bVar3 == null) {
            b bVar4 = new b(this, str2, bVar2);
            this.j.put(str2, bVar4);
            bVar = bVar4;
        } else {
            bVar = bVar3;
        }
        if (!split[0].equals("CLEAN") || split.length != this.g + 2) {
            if (!split[0].equals("DIRTY") || split.length != 2) {
                if (!split[0].equals("READ") || split.length != 2) {
                    throw new IOException("unexpected journal line: " + str);
                }
                return;
            }
            bVar.e = new C0080a(this, bVar, bVar2);
            return;
        }
        bVar.d = true;
        bVar.e = null;
        bVar.a((String[]) a(split, 2, split.length));
    }

    private void e() throws IOException {
        b(this.d);
        Iterator<b> it = this.j.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.e == null) {
                for (int i = 0; i < this.g; i++) {
                    this.h += next.c[i];
                }
            } else {
                next.e = null;
                for (int i2 = 0; i2 < this.g; i2++) {
                    b(next.a(i2));
                    b(next.b(i2));
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() throws IOException {
        if (this.i != null) {
            this.i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.d), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.j.values()) {
            if (bVar.e != null) {
                bufferedWriter.write("DIRTY " + bVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.b + bVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.d.renameTo(this.c);
        this.i = new BufferedWriter(new FileWriter(this.c, true), Utility.DEFAULT_STREAM_BUFFER_SIZE);
    }

    private static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized c a(String str) throws IOException {
        c cVar = null;
        synchronized (this) {
            h();
            e(str);
            b bVar = this.j.get(str);
            if (bVar != null && bVar.d) {
                InputStream[] inputStreamArr = new InputStream[this.g];
                for (int i = 0; i < this.g; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(bVar.a(i));
                    } catch (FileNotFoundException e) {
                    }
                }
                this.k++;
                this.i.append((CharSequence) ("READ " + str + '\n'));
                if (g()) {
                    this.m.submit(this.n);
                }
                cVar = new c(this, str, bVar.f, inputStreamArr, null);
            }
        }
        return cVar;
    }

    public C0080a b(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized C0080a a(String str, long j) throws IOException {
        b bVar;
        C0080a c0080a;
        h();
        e(str);
        b bVar2 = this.j.get(str);
        if (j == -1 || (bVar2 != null && bVar2.f == j)) {
            if (bVar2 == null) {
                b bVar3 = new b(this, str, null);
                this.j.put(str, bVar3);
                bVar = bVar3;
            } else if (bVar2.e != null) {
                c0080a = null;
            } else {
                bVar = bVar2;
            }
            c0080a = new C0080a(this, bVar, null);
            bVar.e = c0080a;
            this.i.write("DIRTY " + str + '\n');
            this.i.flush();
        } else {
            c0080a = null;
        }
        return c0080a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0080a c0080a, boolean z) throws IOException {
        synchronized (this) {
            b bVar = c0080a.b;
            if (bVar.e != c0080a) {
                throw new IllegalStateException();
            }
            if (z && !bVar.d) {
                for (int i = 0; i < this.g; i++) {
                    if (!bVar.b(i).exists()) {
                        c0080a.b();
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                File b2 = bVar.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = bVar.a(i2);
                        b2.renameTo(a2);
                        long j = bVar.c[i2];
                        long length = a2.length();
                        bVar.c[i2] = length;
                        this.h = (this.h - j) + length;
                    }
                } else {
                    b(b2);
                }
            }
            this.k++;
            bVar.e = null;
            if (bVar.d | z) {
                bVar.d = true;
                this.i.write("CLEAN " + bVar.b + bVar.a() + '\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    bVar.f = j2;
                }
            } else {
                this.j.remove(bVar.b);
                this.i.write("REMOVE " + bVar.b + '\n');
            }
            if (this.h > this.f || g()) {
                this.m.submit(this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.k >= 2000 && this.k >= this.j.size();
    }

    public synchronized boolean c(String str) throws IOException {
        boolean z;
        synchronized (this) {
            h();
            e(str);
            b bVar = this.j.get(str);
            if (bVar == null || bVar.e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.g; i++) {
                    File a2 = bVar.a(i);
                    if (!a2.delete()) {
                        throw new IOException("failed to delete " + a2);
                    }
                    this.h -= bVar.c[i];
                    bVar.c[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.j.remove(str);
                if (g()) {
                    this.m.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    public boolean a() {
        return this.i == null;
    }

    private void h() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void b() throws IOException {
        h();
        i();
        this.i.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.e != null) {
                    bVar.e.b();
                }
            }
            i();
            this.i.close();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws IOException {
        while (this.h > this.f) {
            c(this.j.entrySet().iterator().next().getKey());
        }
    }

    public void c() throws IOException {
        close();
        a(this.b);
    }

    private void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;

        /* synthetic */ c(a aVar, String str, long j, InputStream[] inputStreamArr, com.nextreaming.a.a.b bVar) {
            this(str, j, inputStreamArr);
        }

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
        }

        public InputStream a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.d) {
                a.a((Closeable) inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.nextreaming.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0080a {
        private final b b;
        private boolean c;

        /* synthetic */ C0080a(a aVar, b bVar, com.nextreaming.a.a.b bVar2) {
            this(bVar);
        }

        private C0080a(b bVar) {
            this.b = bVar;
        }

        public OutputStream a(int i) throws IOException {
            C0081a c0081a;
            synchronized (a.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                c0081a = new C0081a(this, new FileOutputStream(this.b.b(i)), null);
            }
            return c0081a;
        }

        public void a() throws IOException {
            if (this.c) {
                a.this.a(this, false);
                a.this.c(this.b.b);
            } else {
                a.this.a(this, true);
            }
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.nextreaming.a.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0081a extends FilterOutputStream {
            /* synthetic */ C0081a(C0080a c0080a, OutputStream outputStream, com.nextreaming.a.a.b bVar) {
                this(outputStream);
            }

            private C0081a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C0080a.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C0080a.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C0080a.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C0080a.this.c = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {
        private final String b;
        private final long[] c;
        private boolean d;
        private C0080a e;
        private long f;

        /* synthetic */ b(a aVar, String str, com.nextreaming.a.a.b bVar) {
            this(str);
        }

        private b(String str) {
            this.b = str;
            this.c = new long[a.this.g];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.c) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.g) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(a.this.b, this.b + "." + i);
        }

        public File b(int i) {
            return new File(a.this.b, this.b + "." + i + ".tmp");
        }
    }
}
