package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* renamed from: io.grpc.okhttp.b */
/* loaded from: classes3.dex */
public class C2516b extends l.a {

    /* renamed from: b */
    final /* synthetic */ boolean f27845b;

    /* renamed from: c */
    final /* synthetic */ int f27846c;

    /* renamed from: d */
    final /* synthetic */ int f27847d;

    /* renamed from: e */
    final /* synthetic */ l f27848e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2516b(l lVar, boolean z, int i, int i2) {
        super(lVar, null);
        this.f27848e = lVar;
        this.f27845b = z;
        this.f27846c = i;
        this.f27847d = i2;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27848e.f27971b.a(this.f27845b, this.f27846c, this.f27847d);
    }
}
