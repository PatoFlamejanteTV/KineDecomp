package com.bumptech.glide.g;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: a */
    private static final Queue<d> f8503a = n.a(0);

    /* renamed from: b */
    private InputStream f8504b;

    /* renamed from: c */
    private IOException f8505c;

    d() {
    }

    public static d a(InputStream inputStream) {
        d poll;
        synchronized (f8503a) {
            poll = f8503a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f8504b.available();
    }

    void b(InputStream inputStream) {
        this.f8504b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8504b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f8504b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f8504b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f8504b.read(bArr);
        } catch (IOException e2) {
            this.f8505c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f8504b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f8504b.skip(j);
        } catch (IOException e2) {
            this.f8505c = e2;
            return 0L;
        }
    }

    public void b() {
        this.f8505c = null;
        this.f8504b = null;
        synchronized (f8503a) {
            f8503a.offer(this);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f8504b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f8505c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f8504b.read();
        } catch (IOException e2) {
            this.f8505c = e2;
            return -1;
        }
    }

    public IOException a() {
        return this.f8505c;
    }
}
