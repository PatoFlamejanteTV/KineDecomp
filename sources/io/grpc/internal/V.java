package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.Status;
import io.grpc.internal.W;

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
class V extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ W.a f27510b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V(io.grpc.internal.W.a r1) {
        /*
            r0 = this;
            r0.f27510b = r1
            io.grpc.internal.W r1 = io.grpc.internal.W.this
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.V.<init>(io.grpc.internal.W$a):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public final void b() {
        AbstractC2408g.a aVar;
        try {
            aVar = this.f27510b.f27527a;
            aVar.a();
        } catch (Throwable th) {
            Status b2 = Status.f27130c.b(th).b("Failed to call onReady.");
            W.this.k.a(b2);
            this.f27510b.b(b2, new io.grpc.P());
        }
    }
}
