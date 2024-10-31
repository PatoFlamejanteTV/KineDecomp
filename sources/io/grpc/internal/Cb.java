package io.grpc.internal;

import io.grpc.AbstractC2513n;
import io.grpc.C2406e;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.Ac;
import io.grpc.internal.Fb;
import io.grpc.internal.wc;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Add missing generic type declarations: [ReqT] */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
class Cb<ReqT> extends wc<ReqT> {
    final /* synthetic */ C2406e v;
    final /* synthetic */ MethodDescriptor w;
    final /* synthetic */ Context x;
    final /* synthetic */ Db y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cb(Db db, MethodDescriptor methodDescriptor, io.grpc.P p, wc.c cVar, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, Ac.a aVar, wc.h hVar, C2406e c2406e, MethodDescriptor methodDescriptor2, Context context) {
        super(methodDescriptor, p, cVar, j, j2, executor, scheduledExecutorService, aVar, hVar);
        this.y = db;
        this.v = c2406e;
        this.w = methodDescriptor2;
        this.x = context;
    }

    @Override // io.grpc.internal.wc
    X a(AbstractC2513n.a aVar, io.grpc.P p) {
        C2406e a2 = this.v.a(aVar);
        Y a3 = this.y.a(new Yb(this.w, p, a2));
        Context b2 = this.x.b();
        try {
            return a3.a(this.w, p, a2);
        } finally {
            this.x.b(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.grpc.internal.wc
    public void e() {
        Fb.g gVar;
        gVar = this.y.f27228a.H;
        gVar.b(this);
    }

    @Override // io.grpc.internal.wc
    Status f() {
        Fb.g gVar;
        gVar = this.y.f27228a.H;
        return gVar.a(this);
    }
}
