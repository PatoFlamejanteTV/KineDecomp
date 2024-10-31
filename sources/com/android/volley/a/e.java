package com.android.volley.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.a;
import com.android.volley.p;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DiskBasedCache.java */
/* loaded from: classes.dex */
public class e implements com.android.volley.a {

    /* renamed from: a */
    private final Map<String, a> f7998a = new LinkedHashMap(16, 0.75f, true);

    /* renamed from: b */
    private long f7999b = 0;

    /* renamed from: c */
    private final File f8000c;

    /* renamed from: d */
    private final int f8001d;

    public e(File file, int i) {
        this.f8000c = file;
        this.f8001d = i;
    }

    private void e(String str) {
        a remove = this.f7998a.remove(str);
        if (remove != null) {
            this.f7999b -= remove.f8002a;
        }
    }

    @Override // com.android.volley.a
    public synchronized a.C0040a a(String str) {
        a aVar = this.f7998a.get(str);
        if (aVar == null) {
            return null;
        }
        File b2 = b(str);
        try {
            b bVar = new b(new BufferedInputStream(a(b2)), b2.length());
            try {
                a a2 = a.a(bVar);
                if (!TextUtils.equals(str, a2.f8003b)) {
                    p.a("%s: key=%s, found=%s", b2.getAbsolutePath(), str, a2.f8003b);
                    e(str);
                    return null;
                }
                return aVar.a(a(bVar, bVar.a()));
            } finally {
                bVar.close();
            }
        } catch (IOException e2) {
            p.a("%s: %s", b2.getAbsolutePath(), e2.toString());
            c(str);
            return null;
        }
    }

    public File b(String str) {
        return new File(this.f8000c, d(str));
    }

    public synchronized void c(String str) {
        boolean delete = b(str).delete();
        e(str);
        if (!delete) {
            p.a("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    @Override // com.android.volley.a
    public synchronized void clear() {
        File[] listFiles = this.f8000c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.f7998a.clear();
        this.f7999b = 0L;
        p.a("Cache cleared.", new Object[0]);
    }

    @Override // com.android.volley.a
    public synchronized void d() {
        if (!this.f8000c.exists()) {
            if (!this.f8000c.mkdirs()) {
                p.b("Unable to create cache dir %s", this.f8000c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f8000c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                long length = file.length();
                b bVar = new b(new BufferedInputStream(a(file)), length);
                try {
                    a a2 = a.a(bVar);
                    a2.f8002a = length;
                    a(a2.f8003b, a2);
                    bVar.close();
                } catch (Throwable th) {
                    bVar.close();
                    throw th;
                    break;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        long f8002a;

        /* renamed from: b */
        final String f8003b;

        /* renamed from: c */
        final String f8004c;

        /* renamed from: d */
        final long f8005d;

        /* renamed from: e */
        final long f8006e;

        /* renamed from: f */
        final long f8007f;

        /* renamed from: g */
        final long f8008g;

        /* renamed from: h */
        final List<com.android.volley.g> f8009h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<com.android.volley.g> list) {
            this.f8003b = str;
            this.f8004c = "".equals(str2) ? null : str2;
            this.f8005d = j;
            this.f8006e = j2;
            this.f8007f = j3;
            this.f8008g = j4;
            this.f8009h = list;
        }

        private static List<com.android.volley.g> a(a.C0040a c0040a) {
            List<com.android.volley.g> list = c0040a.f7988h;
            return list != null ? list : f.a(c0040a.f7987g);
        }

        static a a(b bVar) throws IOException {
            if (e.a((InputStream) bVar) == 538247942) {
                return new a(e.b(bVar), e.b(bVar), e.b((InputStream) bVar), e.b((InputStream) bVar), e.b((InputStream) bVar), e.b((InputStream) bVar), e.a(bVar));
            }
            throw new IOException();
        }

        a(String str, a.C0040a c0040a) {
            this(str, c0040a.f7982b, c0040a.f7983c, c0040a.f7984d, c0040a.f7985e, c0040a.f7986f, a(c0040a));
            this.f8002a = c0040a.f7981a.length;
        }

        a.C0040a a(byte[] bArr) {
            a.C0040a c0040a = new a.C0040a();
            c0040a.f7981a = bArr;
            c0040a.f7982b = this.f8004c;
            c0040a.f7983c = this.f8005d;
            c0040a.f7984d = this.f8006e;
            c0040a.f7985e = this.f8007f;
            c0040a.f7986f = this.f8008g;
            c0040a.f7987g = f.a(this.f8009h);
            c0040a.f7988h = Collections.unmodifiableList(this.f8009h);
            return c0040a;
        }

        boolean a(OutputStream outputStream) {
            try {
                e.a(outputStream, 538247942);
                e.a(outputStream, this.f8003b);
                e.a(outputStream, this.f8004c == null ? "" : this.f8004c);
                e.a(outputStream, this.f8005d);
                e.a(outputStream, this.f8006e);
                e.a(outputStream, this.f8007f);
                e.a(outputStream, this.f8008g);
                e.a(this.f8009h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                p.a("%s", e2.toString());
                return false;
            }
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a */
        private final long f8010a;

        /* renamed from: b */
        private long f8011b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.f8010a = j;
        }

        long a() {
            return this.f8010a - this.f8011b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f8011b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f8011b += read;
            }
            return read;
        }
    }

    OutputStream b(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    static long b(InputStream inputStream) throws IOException {
        return ((c(inputStream) & 255) << 0) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56);
    }

    private static int c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static String b(b bVar) throws IOException {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    @Override // com.android.volley.a
    public synchronized void a(String str, a.C0040a c0040a) {
        a(c0040a.f7981a.length);
        File b2 = b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b(b2));
            a aVar = new a(str, c0040a);
            if (aVar.a(bufferedOutputStream)) {
                bufferedOutputStream.write(c0040a.f7981a);
                bufferedOutputStream.close();
                a(str, aVar);
            } else {
                bufferedOutputStream.close();
                p.a("Failed to write header for %s", b2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (b2.delete()) {
                return;
            }
            p.a("Could not clean up file %s", b2.getAbsolutePath());
        }
    }

    private void a(int i) {
        long j;
        long j2 = i;
        if (this.f7999b + j2 < this.f8001d) {
            return;
        }
        if (p.f8092b) {
            p.c("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f7999b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f7998a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (b(value.f8003b).delete()) {
                j = j2;
                this.f7999b -= value.f8002a;
            } else {
                j = j2;
                String str = value.f8003b;
                p.a("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) (this.f7999b + j)) < this.f8001d * 0.9f) {
                break;
            } else {
                j2 = j;
            }
        }
        if (p.f8092b) {
            p.c("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f7999b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void a(String str, a aVar) {
        if (!this.f7998a.containsKey(str)) {
            this.f7999b += aVar.f8002a;
        } else {
            this.f7999b += aVar.f8002a - this.f7998a.get(str).f8002a;
        }
        this.f7998a.put(str, aVar);
    }

    static byte[] a(b bVar, long j) throws IOException {
        long a2 = bVar.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
    }

    InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws IOException {
        return (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static void a(List<com.android.volley.g> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            a(outputStream, list.size());
            for (com.android.volley.g gVar : list) {
                a(outputStream, gVar.a());
                a(outputStream, gVar.b());
            }
            return;
        }
        a(outputStream, 0);
    }

    static List<com.android.volley.g> a(b bVar) throws IOException {
        int a2 = a((InputStream) bVar);
        List<com.android.volley.g> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyList.add(new com.android.volley.g(b(bVar).intern(), b(bVar).intern()));
        }
        return emptyList;
    }
}
