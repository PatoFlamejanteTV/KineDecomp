package c.e.a.a;

import android.util.Log;
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

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class b implements Closeable {

    /* renamed from: a */
    private static final Charset f3862a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final File f3863b;

    /* renamed from: c */
    private final File f3864c;

    /* renamed from: d */
    private final File f3865d;

    /* renamed from: e */
    private final int f3866e;

    /* renamed from: f */
    private final long f3867f;

    /* renamed from: g */
    private final int f3868g;
    private Writer i;
    private int k;

    /* renamed from: h */
    private long f3869h = 0;
    private final LinkedHashMap<String, C0020b> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new c.e.a.a.a(this);

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a */
        private final C0020b f3870a;

        /* renamed from: b */
        private boolean f3871b;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DiskLruCache.java */
        /* renamed from: c.e.a.a.b$a$a */
        /* loaded from: classes.dex */
        public class C0019a extends FilterOutputStream {
            /* synthetic */ C0019a(a aVar, OutputStream outputStream, c.e.a.a.a aVar2) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    a.this.f3871b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    a.this.f3871b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    a.this.f3871b = true;
                }
            }

            private C0019a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.f3871b = true;
                }
            }
        }

        /* synthetic */ a(b bVar, C0020b c0020b, c.e.a.a.a aVar) {
            this(c0020b);
        }

        public void b() throws IOException {
            if (this.f3871b) {
                b.this.a(this, false);
                b.this.g(this.f3870a.f3874a);
            } else {
                b.this.a(this, true);
            }
        }

        private a(C0020b c0020b) {
            this.f3870a = c0020b;
        }

        public OutputStream a(int i) throws IOException {
            C0019a c0019a;
            synchronized (b.this) {
                if (this.f3870a.f3877d == this) {
                    c0019a = new C0019a(this, new FileOutputStream(this.f3870a.b(i)), null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0019a;
        }

        public void a() throws IOException {
            b.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: c.e.a.a.b$b */
    /* loaded from: classes.dex */
    public final class C0020b {

        /* renamed from: a */
        private final String f3874a;

        /* renamed from: b */
        private final long[] f3875b;

        /* renamed from: c */
        private boolean f3876c;

        /* renamed from: d */
        private a f3877d;

        /* renamed from: e */
        private long f3878e;

        /* synthetic */ C0020b(b bVar, String str, c.e.a.a.a aVar) {
            this(str);
        }

        private C0020b(String str) {
            this.f3874a = str;
            this.f3875b = new long[b.this.f3868g];
        }

        public void b(String[] strArr) throws IOException {
            if (strArr.length == b.this.f3868g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f3875b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f3875b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return new File(b.this.f3863b, this.f3874a + "." + i + ".tmp");
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(b.this.f3863b, this.f3874a + "." + i);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c implements Closeable {

        /* renamed from: a */
        private final String f3880a;

        /* renamed from: b */
        private final long f3881b;

        /* renamed from: c */
        private final InputStream[] f3882c;

        /* synthetic */ c(b bVar, String str, long j, InputStream[] inputStreamArr, c.e.a.a.a aVar) {
            this(str, j, inputStreamArr);
        }

        public InputStream a(int i) {
            return this.f3882c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f3882c) {
                b.a((Closeable) inputStream);
            }
        }

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.f3880a = str;
            this.f3881b = j;
            this.f3882c = inputStreamArr;
        }
    }

    private b(File file, int i, int i2, long j) {
        this.f3863b = file;
        this.f3866e = i;
        this.f3864c = new File(file, "journal");
        this.f3865d = new File(file, "journal.tmp");
        this.f3868g = i2;
        this.f3867f = j;
    }

    private void h(String str) throws IOException {
        String[] split = str.split(" ");
        if (split.length >= 2) {
            String str2 = split[1];
            if (split[0].equals("REMOVE") && split.length == 2) {
                this.j.remove(str2);
                return;
            }
            C0020b c0020b = this.j.get(str2);
            if (c0020b == null) {
                c0020b = new C0020b(this, str2, null);
                this.j.put(str2, c0020b);
            }
            if (split[0].equals("CLEAN") && split.length == this.f3868g + 2) {
                c0020b.f3876c = true;
                c0020b.f3877d = null;
                c0020b.b((String[]) a(split, 2, split.length));
                return;
            } else if (split[0].equals("DIRTY") && split.length == 2) {
                c0020b.f3877d = new a(this, c0020b, null);
                return;
            } else {
                if (split[0].equals("READ") && split.length == 2) {
                    return;
                }
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void i(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private void r() throws IOException {
        b(this.f3865d);
        Iterator<C0020b> it = this.j.values().iterator();
        while (it.hasNext()) {
            C0020b next = it.next();
            int i = 0;
            if (next.f3877d != null) {
                next.f3877d = null;
                while (i < this.f3868g) {
                    b(next.a(i));
                    b(next.b(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.f3868g) {
                    this.f3869h += next.f3875b[i];
                    i++;
                }
            }
        }
    }

    private void s() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f3864c), 8192);
        try {
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            String a6 = a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f3866e).equals(a4) || !Integer.toString(this.f3868g).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            while (true) {
                try {
                    h(a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    public synchronized void u() throws IOException {
        if (this.i != null) {
            this.i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.f3865d), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f3866e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f3868g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0020b c0020b : this.j.values()) {
            if (c0020b.f3877d != null) {
                bufferedWriter.write("DIRTY " + c0020b.f3874a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c0020b.f3874a + c0020b.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.f3865d.renameTo(this.f3864c);
        this.i = new BufferedWriter(new FileWriter(this.f3864c, true), 8192);
    }

    public void v() throws IOException {
        while (this.f3869h > this.f3867f) {
            g(this.j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            C0020b c0020b = (C0020b) it.next();
            if (c0020b.f3877d != null) {
                c0020b.f3877d.a();
            }
        }
        v();
        this.i.close();
        this.i = null;
    }

    public synchronized void flush() throws IOException {
        b();
        v();
        this.i.flush();
    }

    public synchronized boolean g(String str) throws IOException {
        b();
        i(str);
        C0020b c0020b = this.j.get(str);
        if (c0020b != null && c0020b.f3877d == null) {
            for (int i = 0; i < this.f3868g; i++) {
                File a2 = c0020b.a(i);
                if (a2.delete()) {
                    this.f3869h -= c0020b.f3875b[i];
                    c0020b.f3875b[i] = 0;
                } else {
                    throw new IOException("failed to delete " + a2);
                }
            }
            this.k++;
            this.i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.j.remove(str);
            if (c()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public boolean isClosed() {
        return this.i == null;
    }

    private static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public boolean c() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public a e(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized c f(String str) throws IOException {
        b();
        i(str);
        C0020b c0020b = this.j.get(str);
        if (c0020b == null) {
            return null;
        }
        if (!c0020b.f3876c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f3868g];
        for (int i = 0; i < this.f3868g; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(c0020b.a(i));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) ("READ " + str + '\n'));
        if (c()) {
            this.m.submit(this.n);
        }
        return new c(this, str, c0020b.f3878e, inputStreamArr, null);
    }

    private static <T> T[] a(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i >= 0 && i <= length) {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
            System.arraycopy(tArr, i, tArr2, 0, min);
            return tArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private void b() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i = length - 1;
                    if (sb.charAt(i) == '\r') {
                        sb.setLength(i);
                    }
                }
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
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

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            b bVar = new b(file, i, i2, j);
            if (bVar.f3864c.exists()) {
                try {
                    bVar.s();
                    bVar.r();
                    bVar.i = new BufferedWriter(new FileWriter(bVar.f3864c, true), 8192);
                    return bVar;
                } catch (IOException e2) {
                    Log.w("DiskLruCache", "DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    bVar.a();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i, i2, j);
            bVar2.u();
            return bVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private synchronized a a(String str, long j) throws IOException {
        b();
        i(str);
        C0020b c0020b = this.j.get(str);
        if (j != -1 && (c0020b == null || c0020b.f3878e != j)) {
            return null;
        }
        if (c0020b != null) {
            if (c0020b.f3877d != null) {
                return null;
            }
        } else {
            c0020b = new C0020b(this, str, null);
            this.j.put(str, c0020b);
        }
        a aVar = new a(this, c0020b, null);
        c0020b.f3877d = aVar;
        this.i.write("DIRTY " + str + '\n');
        this.i.flush();
        return aVar;
    }

    public synchronized void a(a aVar, boolean z) throws IOException {
        C0020b c0020b = aVar.f3870a;
        if (c0020b.f3877d == aVar) {
            if (z && !c0020b.f3876c) {
                for (int i = 0; i < this.f3868g; i++) {
                    if (!c0020b.b(i).exists()) {
                        aVar.a();
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f3868g; i2++) {
                File b2 = c0020b.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = c0020b.a(i2);
                        b2.renameTo(a2);
                        long j = c0020b.f3875b[i2];
                        long length = a2.length();
                        c0020b.f3875b[i2] = length;
                        this.f3869h = (this.f3869h - j) + length;
                    }
                } else {
                    b(b2);
                }
            }
            this.k++;
            c0020b.f3877d = null;
            if (!(c0020b.f3876c | z)) {
                this.j.remove(c0020b.f3874a);
                this.i.write("REMOVE " + c0020b.f3874a + '\n');
            } else {
                c0020b.f3876c = true;
                this.i.write("CLEAN " + c0020b.f3874a + c0020b.a() + '\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    c0020b.f3878e = j2;
                }
            }
            if (this.f3869h > this.f3867f || c()) {
                this.m.submit(this.n);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() throws IOException {
        close();
        a(this.f3863b);
    }
}
