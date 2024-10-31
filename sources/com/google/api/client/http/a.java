package com.google.api.client.http;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GZipEncoding.java */
/* loaded from: classes2.dex */
class a extends BufferedOutputStream {

    /* renamed from: a */
    final /* synthetic */ GZipEncoding f14802a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GZipEncoding gZipEncoding, OutputStream outputStream) {
        super(outputStream);
        this.f14802a = gZipEncoding;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}
