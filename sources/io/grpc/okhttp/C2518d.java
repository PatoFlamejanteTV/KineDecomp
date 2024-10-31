package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* renamed from: io.grpc.okhttp.d */
/* loaded from: classes3.dex */
public class C2518d extends l.a {

    /* renamed from: b */
    final /* synthetic */ int f27853b;

    /* renamed from: c */
    final /* synthetic */ long f27854c;

    /* renamed from: d */
    final /* synthetic */ l f27855d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2518d(l lVar, int i, long j) {
        super(lVar, null);
        this.f27855d = lVar;
        this.f27853b = i;
        this.f27854c = j;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27855d.f27971b.a(this.f27853b, this.f27854c);
    }
}
