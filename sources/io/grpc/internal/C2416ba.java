package io.grpc.internal;

import io.grpc.internal.C2420ca;

/* compiled from: CompositeReadableBuffer.java */
/* renamed from: io.grpc.internal.ba */
/* loaded from: classes3.dex */
public class C2416ba extends C2420ca.a {

    /* renamed from: c */
    int f27562c;

    /* renamed from: d */
    final /* synthetic */ int f27563d;

    /* renamed from: e */
    final /* synthetic */ byte[] f27564e;

    /* renamed from: f */
    final /* synthetic */ C2420ca f27565f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2416ba(C2420ca c2420ca, int i, byte[] bArr) {
        super(null);
        this.f27565f = c2420ca;
        this.f27563d = i;
        this.f27564e = bArr;
        this.f27562c = this.f27563d;
    }

    @Override // io.grpc.internal.C2420ca.a
    public int b(InterfaceC2426dc interfaceC2426dc, int i) {
        interfaceC2426dc.a(this.f27564e, this.f27562c, i);
        this.f27562c += i;
        return 0;
    }
}
