package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
class k extends l.a {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f27965b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f27966c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ okio.g f27967d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f27968e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f27969f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, boolean z, int i, okio.g gVar, int i2) {
        super(lVar, null);
        this.f27969f = lVar;
        this.f27965b = z;
        this.f27966c = i;
        this.f27967d = gVar;
        this.f27968e = i2;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27969f.f27971b.a(this.f27965b, this.f27966c, this.f27967d, this.f27968e);
    }
}
