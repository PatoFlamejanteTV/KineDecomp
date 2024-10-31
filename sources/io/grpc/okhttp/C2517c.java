package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* renamed from: io.grpc.okhttp.c */
/* loaded from: classes3.dex */
public class C2517c extends l.a {

    /* renamed from: b */
    final /* synthetic */ int f27849b;

    /* renamed from: c */
    final /* synthetic */ ErrorCode f27850c;

    /* renamed from: d */
    final /* synthetic */ byte[] f27851d;

    /* renamed from: e */
    final /* synthetic */ l f27852e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2517c(l lVar, int i, ErrorCode errorCode, byte[] bArr) {
        super(lVar, null);
        this.f27852e = lVar;
        this.f27849b = i;
        this.f27850c = errorCode;
        this.f27851d = bArr;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27852e.f27971b.a(this.f27849b, this.f27850c, this.f27851d);
        this.f27852e.f27971b.flush();
    }
}
