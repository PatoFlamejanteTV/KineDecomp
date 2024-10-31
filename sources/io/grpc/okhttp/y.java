package io.grpc.okhttp;

import io.grpc.internal.AbstractC2423d;
import io.grpc.internal.InterfaceC2426dc;

/* compiled from: OkHttpReadableBuffer.java */
/* loaded from: classes3.dex */
public class y extends AbstractC2423d {

    /* renamed from: a */
    private final okio.g f28020a;

    public y(okio.g gVar) {
        this.f28020a = gVar;
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int B() {
        return (int) this.f28020a.size();
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public void a(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int a2 = this.f28020a.a(bArr, i, i2);
            if (a2 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i2 + " bytes");
            }
            i2 -= a2;
            i += a2;
        }
    }

    @Override // io.grpc.internal.AbstractC2423d, io.grpc.internal.InterfaceC2426dc, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f28020a.a();
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public InterfaceC2426dc g(int i) {
        okio.g gVar = new okio.g();
        gVar.a(this.f28020a, i);
        return new y(gVar);
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int readUnsignedByte() {
        return this.f28020a.readByte() & 255;
    }
}
