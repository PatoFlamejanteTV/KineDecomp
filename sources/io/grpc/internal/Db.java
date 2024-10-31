package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.C2406e;
import io.grpc.Context;
import io.grpc.J;
import io.grpc.MethodDescriptor;
import io.grpc.internal.Ac;
import io.grpc.internal.W;
import io.grpc.internal.wc;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
public class Db implements W.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fb f27228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Db(Fb fb) {
        this.f27228a = fb;
    }

    @Override // io.grpc.internal.W.b
    public Y a(J.d dVar) {
        J.f fVar;
        AtomicBoolean atomicBoolean;
        fVar = this.f27228a.C;
        atomicBoolean = this.f27228a.I;
        if (atomicBoolean.get()) {
            return this.f27228a.G;
        }
        if (fVar == null) {
            M m = this.f27228a.o;
            m.a(new Bb(this));
            m.a();
            return this.f27228a.G;
        }
        Y a2 = GrpcUtil.a(fVar.a(dVar), dVar.a().i());
        return a2 != null ? a2 : this.f27228a.G;
    }

    @Override // io.grpc.internal.W.b
    public <ReqT> wc<ReqT> a(MethodDescriptor<ReqT, ?> methodDescriptor, C2406e c2406e, io.grpc.P p, Context context) {
        wc.c cVar;
        long j;
        long j2;
        wc.h hVar;
        Preconditions.b(this.f27228a.U, "retry should be enabled");
        cVar = this.f27228a.Q;
        j = this.f27228a.S;
        j2 = this.f27228a.T;
        Executor a2 = this.f27228a.a(c2406e);
        ScheduledExecutorService I = this.f27228a.k.I();
        Ac.a aVar = (Ac.a) c2406e.a(Gc.f27326b);
        hVar = this.f27228a.R;
        return new Cb(this, methodDescriptor, p, cVar, j, j2, a2, I, aVar, hVar, c2406e, methodDescriptor, context);
    }
}
