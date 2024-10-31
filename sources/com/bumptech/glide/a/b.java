package com.bumptech.glide.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class b implements Closeable {

    /* renamed from: a */
    private final File f8347a;

    /* renamed from: b */
    private final File f8348b;

    /* renamed from: c */
    private final File f8349c;

    /* renamed from: d */
    private final File f8350d;

    /* renamed from: e */
    private final int f8351e;

    /* renamed from: f */
    private long f8352f;

    /* renamed from: g */
    private final int f8353g;
    private Writer i;
    private int k;

    /* renamed from: h */
    private long f8354h = 0;
    private final LinkedHashMap<String, c> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(null));
    private final Callable<Void> n = new com.bumptech.glide.a.a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public static final class a implements ThreadFactory {
        private a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ a(com.bumptech.glide.a.a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.b$b */
    /* loaded from: classes.dex */
    public final class C0044b {

        /* renamed from: a */
        private final c f8355a;

        /* renamed from: b */
        private final boolean[] f8356b;

        /* renamed from: c */
        private boolean f8357c;

        /* synthetic */ C0044b(b bVar, c cVar, com.bumptech.glide.a.a aVar) {
            this(cVar);
        }

        public void c() throws IOException {
            b.this.a(this, true);
            this.f8357c = true;
        }

        private C0044b(c cVar) {
            this.f8355a = cVar;
            this.f8356b = cVar.f8363e ? null : new boolean[b.this.f8353g];
        }

        public File a(int i) throws IOException {
            File b2;
            synchronized (b.this) {
                if (this.f8355a.f8364f == this) {
                    if (!this.f8355a.f8363e) {
                        this.f8356b[i] = true;
                    }
                    b2 = this.f8355a.b(i);
                    if (!b.this.f8347a.exists()) {
                        b.this.f8347a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return b2;
        }

        public void b() {
            if (this.f8357c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void a() throws IOException {
            b.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a */
        private final String f8359a;

        /* renamed from: b */
        private final long[] f8360b;

        /* renamed from: c */
        File[] f8361c;

        /* renamed from: d */
        File[] f8362d;

        /* renamed from: e */
        private boolean f8363e;

        /* renamed from: f */
        private C0044b f8364f;

        /* renamed from: g */
        private long f8365g;

        /* synthetic */ c(b bVar, String str, com.bumptech.glide.a.a aVar) {
            this(str);
        }

        private c(String str) {
            this.f8359a = str;
            this.f8360b = new long[b.this.f8353g];
            this.f8361c = new File[b.this.f8353g];
            this.f8362d = new File[b.this.f8353g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < b.this.f8353g; i++) {
                sb.append(i);
                this.f8361c[i] = new File(b.this.f8347a, sb.toString());
                sb.append(".tmp");
                this.f8362d[i] = new File(b.this.f8347a, sb.toString());
                sb.setLength(length);
            }
        }

        public void b(String[] strArr) throws IOException {
            if (strArr.length == b.this.f8353g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f8360b[i] = Long.parseLong(strArr[i]);
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
            for (long j : this.f8360b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f8362d[i];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f8361c[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a */
        private final String f8367a;

        /* renamed from: b */
        private final long f8368b;

        /* renamed from: c */
        private final long[] f8369c;

        /* renamed from: d */
        private final File[] f8370d;

        /* synthetic */ d(b bVar, String str, long j, File[] fileArr, long[] jArr, com.bumptech.glide.a.a aVar) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.f8370d[i];
        }

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f8367a = str;
            this.f8368b = j;
            this.f8370d = fileArr;
            this.f8369c = jArr;
        }
    }

    private b(File file, int i, int i2, long j) {
        this.f8347a = file;
        this.f8351e = i;
        this.f8348b = new File(file, "journal");
        this.f8349c = new File(file, "journal.tmp");
        this.f8350d = new File(file, "journal.bkp");
        this.f8353g = i2;
        this.f8352f = j;
    }

    private void h(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            c cVar = this.j.get(substring);
            if (cVar == null) {
                cVar = new c(this, substring, null);
                this.j.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f8363e = true;
                cVar.f8364f = null;
                cVar.b(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f8364f = new C0044b(this, cVar, null);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void r() throws IOException {
        a(this.f8349c);
        Iterator<c> it = this.j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.f8364f != null) {
                next.f8364f = null;
                while (i < this.f8353g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.f8353g) {
                    this.f8354h += next.f8360b[i];
                    i++;
                }
            }
        }
    }

    private void s() throws IOException {
        com.bumptech.glide.a.d dVar = new com.bumptech.glide.a.d(new FileInputStream(this.f8348b), e.f8378a);
        try {
            String b2 = dVar.b();
            String b3 = dVar.b();
            String b4 = dVar.b();
            String b5 = dVar.b();
            String b6 = dVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b3) || !Integer.toString(this.f8351e).equals(b4) || !Integer.toString(this.f8353g).equals(b5) || !"".equals(b6)) {
                throw new IOException("unexpected journal header: [" + b2 + ", " + b3 + ", " + b5 + ", " + b6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    h(dVar.b());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (dVar.a()) {
                        u();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8348b, true), e.f8378a));
                    }
                    e.a(dVar);
                    return;
                }
            }
        } catch (Throwable th) {
            e.a(dVar);
            throw th;
        }
    }

    public synchronized void u() throws IOException {
        if (this.i != null) {
            this.i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8349c), e.f8378a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f8351e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f8353g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.j.values()) {
                if (cVar.f8364f != null) {
                    bufferedWriter.write("DIRTY " + cVar.f8359a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f8359a + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f8348b.exists()) {
                a(this.f8348b, this.f8350d, true);
            }
            a(this.f8349c, this.f8348b, false);
            this.f8350d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8348b, true), e.f8378a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public void v() throws IOException {
        while (this.f8354h > this.f8352f) {
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
            c cVar = (c) it.next();
            if (cVar.f8364f != null) {
                cVar.f8364f.a();
            }
        }
        v();
        this.i.close();
        this.i = null;
    }

    public synchronized boolean g(String str) throws IOException {
        b();
        c cVar = this.j.get(str);
        if (cVar != null && cVar.f8364f == null) {
            for (int i = 0; i < this.f8353g; i++) {
                File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f8354h -= cVar.f8360b[i];
                cVar.f8360b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            this.j.remove(str);
            if (c()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    private void b() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public boolean c() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public C0044b e(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized d f(String str) throws IOException {
        b();
        c cVar = this.j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f8363e) {
            return null;
        }
        for (File file : cVar.f8361c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (c()) {
            this.m.submit(this.n);
        }
        return new d(this, str, cVar.f8365g, cVar.f8361c, cVar.f8360b, null);
    }

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            b bVar = new b(file, i, i2, j);
            if (bVar.f8348b.exists()) {
                try {
                    bVar.s();
                    bVar.r();
                    return bVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
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

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized C0044b a(String str, long j) throws IOException {
        b();
        c cVar = this.j.get(str);
        if (j != -1 && (cVar == null || cVar.f8365g != j)) {
            return null;
        }
        if (cVar != null) {
            if (cVar.f8364f != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, null);
            this.j.put(str, cVar);
        }
        C0044b c0044b = new C0044b(this, cVar, null);
        cVar.f8364f = c0044b;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        this.i.flush();
        return c0044b;
    }

    public synchronized void a(C0044b c0044b, boolean z) throws IOException {
        c cVar = c0044b.f8355a;
        if (cVar.f8364f == c0044b) {
            if (z && !cVar.f8363e) {
                for (int i = 0; i < this.f8353g; i++) {
                    if (c0044b.f8356b[i]) {
                        if (!cVar.b(i).exists()) {
                            c0044b.a();
                            return;
                        }
                    } else {
                        c0044b.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f8353g; i2++) {
                File b2 = cVar.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = cVar.a(i2);
                        b2.renameTo(a2);
                        long j = cVar.f8360b[i2];
                        long length = a2.length();
                        cVar.f8360b[i2] = length;
                        this.f8354h = (this.f8354h - j) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.k++;
            cVar.f8364f = null;
            if (!(cVar.f8363e | z)) {
                this.j.remove(cVar.f8359a);
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f8359a);
                this.i.append('\n');
            } else {
                cVar.f8363e = true;
                this.i.append((CharSequence) "CLEAN");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f8359a);
                this.i.append((CharSequence) cVar.a());
                this.i.append('\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    cVar.f8365g = j2;
                }
            }
            this.i.flush();
            if (this.f8354h > this.f8352f || c()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void a() throws IOException {
        close();
        e.a(this.f8347a);
    }
}
