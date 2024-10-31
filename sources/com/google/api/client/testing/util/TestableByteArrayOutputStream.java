package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class TestableByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2520a;

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2520a = true;
    }
}
