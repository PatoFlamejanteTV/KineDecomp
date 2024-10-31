package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.C2524t;
import io.grpc.Context;

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
class P extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC2408g.a f27462b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f27463c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public P(io.grpc.internal.W r1, io.grpc.AbstractC2408g.a r2) {
        /*
            r0 = this;
            r0.f27463c = r1
            r0.f27462b = r2
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.P.<init>(io.grpc.internal.W, io.grpc.g$a):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public void b() {
        Context context;
        W w = this.f27463c;
        AbstractC2408g.a aVar = this.f27462b;
        context = w.f27524f;
        w.a(aVar, C2524t.a(context), new io.grpc.P());
    }
}
