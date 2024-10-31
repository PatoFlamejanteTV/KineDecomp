package com.google.firebase.database.connection.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class StringListReader extends Reader {

    /* renamed from: a */
    private List<String> f16815a;

    /* renamed from: b */
    private boolean f16816b = false;

    /* renamed from: c */
    private int f16817c;

    /* renamed from: e */
    private int f16819e = this.f16817c;

    /* renamed from: d */
    private int f16818d;

    /* renamed from: f */
    private int f16820f = this.f16818d;

    /* renamed from: g */
    private boolean f16821g = false;

    public StringListReader() {
        this.f16815a = null;
        this.f16815a = new ArrayList();
    }

    private void b() throws IOException {
        if (!this.f16816b) {
            if (!this.f16821g) {
                throw new IOException("Reader needs to be frozen before read operations can be called");
            }
            return;
        }
        throw new IOException("Stream already closed");
    }

    private String c() {
        if (this.f16818d < this.f16815a.size()) {
            return this.f16815a.get(this.f16818d);
        }
        return null;
    }

    private long g(long j) {
        long j2 = 0;
        while (this.f16818d < this.f16815a.size() && j2 < j) {
            long j3 = j - j2;
            long r = r();
            if (j3 < r) {
                this.f16817c = (int) (this.f16817c + j3);
                j2 += j3;
            } else {
                j2 += r;
                this.f16817c = 0;
                this.f16818d++;
            }
        }
        return j2;
    }

    private int r() {
        String c2 = c();
        if (c2 == null) {
            return 0;
        }
        return c2.length() - this.f16817c;
    }

    public void a() {
        if (!this.f16821g) {
            this.f16821g = true;
            return;
        }
        throw new IllegalStateException("Trying to freeze frozen StringListReader");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b();
        this.f16816b = true;
    }

    public void e(String str) {
        if (!this.f16821g) {
            if (str.length() > 0) {
                this.f16815a.add(str);
                return;
            }
            return;
        }
        throw new IllegalStateException("Trying to add string after reading");
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        b();
        this.f16819e = this.f16817c;
        this.f16820f = this.f16818d;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        b();
        int remaining = charBuffer.remaining();
        String c2 = c();
        int i = 0;
        while (remaining > 0 && c2 != null) {
            int min = Math.min(c2.length() - this.f16817c, remaining);
            String str = this.f16815a.get(this.f16818d);
            int i2 = this.f16817c;
            charBuffer.put(str, i2, i2 + min);
            remaining -= min;
            i += min;
            g(min);
            c2 = c();
        }
        if (i > 0 || c2 != null) {
            return i;
        }
        return -1;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        b();
        return true;
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.f16817c = this.f16819e;
        this.f16818d = this.f16820f;
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        b();
        return g(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f16815a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        b();
        String c2 = c();
        if (c2 == null) {
            return -1;
        }
        char charAt = c2.charAt(this.f16817c);
        g(1L);
        return charAt;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        b();
        String c2 = c();
        int i3 = 0;
        while (c2 != null && i3 < i2) {
            int min = Math.min(r(), i2 - i3);
            int i4 = this.f16817c;
            c2.getChars(i4, i4 + min, cArr, i + i3);
            i3 += min;
            g(min);
            c2 = c();
        }
        if (i3 > 0 || c2 != null) {
            return i3;
        }
        return -1;
    }
}
