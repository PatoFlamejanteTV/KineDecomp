package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* compiled from: ForwardingReadableBuffer.java */
/* loaded from: classes3.dex */
public abstract class Qa implements InterfaceC2426dc {

    /* renamed from: a */
    private final InterfaceC2426dc f27470a;

    public Qa(InterfaceC2426dc interfaceC2426dc) {
        Preconditions.a(interfaceC2426dc, "buf");
        this.f27470a = interfaceC2426dc;
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int B() {
        return this.f27470a.B();
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public void a(byte[] bArr, int i, int i2) {
        this.f27470a.a(bArr, i, i2);
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public InterfaceC2426dc g(int i) {
        return this.f27470a.g(i);
    }

    @Override // io.grpc.internal.InterfaceC2426dc
    public int readUnsignedByte() {
        return this.f27470a.readUnsignedByte();
    }

    public String toString() {
        return MoreObjects.a(this).a("delegate", this.f27470a).toString();
    }
}
