package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
public class g extends l.a {

    /* renamed from: b */
    final /* synthetic */ io.grpc.okhttp.internal.framed.g f27858b;

    /* renamed from: c */
    final /* synthetic */ l f27859c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(l lVar, io.grpc.okhttp.internal.framed.g gVar) {
        super(lVar, null);
        this.f27859c = lVar;
        this.f27858b = gVar;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27859c.f27971b.a(this.f27858b);
    }
}
