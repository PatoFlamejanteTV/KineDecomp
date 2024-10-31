package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okio.B;
import okio.y;

/* compiled from: RetryableSink.java */
/* loaded from: classes3.dex */
public final class t implements y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f25484a;

    /* renamed from: b, reason: collision with root package name */
    private final int f25485b;

    /* renamed from: c, reason: collision with root package name */
    private final okio.g f25486c;

    public t(int i) {
        this.f25486c = new okio.g();
        this.f25485b = i;
    }

    @Override // okio.y
    public void a(okio.g gVar, long j) throws IOException {
        if (!this.f25484a) {
            com.squareup.okhttp.a.o.a(gVar.size(), 0L, j);
            if (this.f25485b != -1 && this.f25486c.size() > this.f25485b - j) {
                throw new ProtocolException("exceeded content-length limit of " + this.f25485b + " bytes");
            }
            this.f25486c.a(gVar, j);
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f25484a) {
            return;
        }
        this.f25484a = true;
        if (this.f25486c.size() >= this.f25485b) {
            return;
        }
        throw new ProtocolException("content-length promised " + this.f25485b + " bytes, but received " + this.f25486c.size());
    }

    @Override // okio.y
    public B e() {
        return B.f29225a;
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
    }

    public t() {
        this(-1);
    }

    public long a() throws IOException {
        return this.f25486c.size();
    }

    public void a(y yVar) throws IOException {
        okio.g gVar = new okio.g();
        okio.g gVar2 = this.f25486c;
        gVar2.a(gVar, 0L, gVar2.size());
        yVar.a(gVar, gVar.size());
    }
}
