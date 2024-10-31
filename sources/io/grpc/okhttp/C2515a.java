package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* renamed from: io.grpc.okhttp.a */
/* loaded from: classes3.dex */
class C2515a extends l.a {

    /* renamed from: b */
    final /* synthetic */ io.grpc.okhttp.internal.framed.g f27843b;

    /* renamed from: c */
    final /* synthetic */ l f27844c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2515a(l lVar, io.grpc.okhttp.internal.framed.g gVar) {
        super(lVar, null);
        this.f27844c = lVar;
        this.f27843b = gVar;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27844c.f27971b.b(this.f27843b);
    }
}
