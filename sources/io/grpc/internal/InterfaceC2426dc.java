package io.grpc.internal;

import java.io.Closeable;

/* compiled from: ReadableBuffer.java */
/* renamed from: io.grpc.internal.dc */
/* loaded from: classes3.dex */
public interface InterfaceC2426dc extends Closeable {
    int B();

    void a(byte[] bArr, int i, int i2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    InterfaceC2426dc g(int i);

    int readUnsignedByte();
}
