package com.squareup.okhttp.a;

import java.io.IOException;
import okio.B;
import okio.y;

/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
class d implements y {
    @Override // okio.y
    public void a(okio.g gVar, long j) throws IOException {
        gVar.skip(j);
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // okio.y
    public B e() {
        return B.f29225a;
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
    }
}
