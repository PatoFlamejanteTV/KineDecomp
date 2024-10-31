package io.grpc.internal;

import io.grpc.internal.C2461mb;
import io.grpc.internal.Fb;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
public class Gb extends C2461mb.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fb.f f27323a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fb.b f27324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gb(Fb.b bVar, Fb.f fVar) {
        this.f27324b = bVar;
        this.f27323a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.grpc.internal.C2461mb.b
    public void a(C2461mb c2461mb, io.grpc.r rVar) {
        Fb.b bVar;
        this.f27324b.a(rVar);
        Fb.b bVar2 = this.f27324b;
        bVar = Fb.this.B;
        if (bVar2 == bVar) {
            this.f27324b.f27287a.a(this.f27323a, rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.grpc.internal.C2461mb.b
    public void b(C2461mb c2461mb) {
        Fb.this.W.a(c2461mb, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.grpc.internal.C2461mb.b
    public void c(C2461mb c2461mb) {
        Set set;
        set = Fb.this.E;
        set.remove(c2461mb);
        Fb.this.P.f(c2461mb);
        Fb.this.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.grpc.internal.C2461mb.b
    public void a(C2461mb c2461mb) {
        Fb.this.W.a(c2461mb, true);
    }
}
