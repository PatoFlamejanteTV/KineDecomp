package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.Status;
import io.grpc.internal.W;

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
class S extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27500b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ W.a f27501c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public S(io.grpc.internal.W.a r1, io.grpc.P r2) {
        /*
            r0 = this;
            r0.f27501c = r1
            r0.f27500b = r2
            io.grpc.internal.W r1 = io.grpc.internal.W.this
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.S.<init>(io.grpc.internal.W$a, io.grpc.P):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public final void b() {
        boolean z;
        AbstractC2408g.a aVar;
        try {
            z = this.f27501c.f27528b;
            if (z) {
                return;
            }
            aVar = this.f27501c.f27527a;
            aVar.a(this.f27500b);
        } catch (Throwable th) {
            Status b2 = Status.f27130c.b(th).b("Failed to read headers");
            W.this.k.a(b2);
            this.f27501c.b(b2, new io.grpc.P());
        }
    }
}
