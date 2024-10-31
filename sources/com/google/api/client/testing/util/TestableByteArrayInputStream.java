package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class TestableByteArrayInputStream extends ByteArrayInputStream {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2519a;

    public TestableByteArrayInputStream(byte[] bArr) {
        super(bArr);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2519a = true;
    }
}
