package io.grpc.internal;

/* compiled from: AbstractReadableBuffer.java */
/* renamed from: io.grpc.internal.d */
/* loaded from: classes3.dex */
public abstract class AbstractC2423d implements InterfaceC2426dc {
    public final int a() {
        a(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // io.grpc.internal.InterfaceC2426dc, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void a(int i) {
        if (B() < i) {
            throw new IndexOutOfBoundsException();
        }
    }
}
