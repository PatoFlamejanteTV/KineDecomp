package io.grpc.internal;

import io.grpc.internal.C2420ca;

/* compiled from: CompositeReadableBuffer.java */
/* renamed from: io.grpc.internal.aa */
/* loaded from: classes3.dex */
public class C2412aa extends C2420ca.a {

    /* renamed from: c */
    final /* synthetic */ C2420ca f27555c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2412aa(C2420ca c2420ca) {
        super(null);
        this.f27555c = c2420ca;
    }

    @Override // io.grpc.internal.C2420ca.a
    int b(InterfaceC2426dc interfaceC2426dc, int i) {
        return interfaceC2426dc.readUnsignedByte();
    }
}
