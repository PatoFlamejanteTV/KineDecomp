package com.squareup.okhttp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ResponseBody.java */
/* loaded from: classes3.dex */
public abstract class I implements Closeable {
    public final InputStream a() throws IOException {
        return c().p();
    }

    public abstract long b() throws IOException;

    public abstract okio.i c() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c().close();
    }
}
