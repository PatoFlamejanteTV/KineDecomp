package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.Status;

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
class Q extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC2408g.a f27467b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f27468c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ W f27469d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Q(io.grpc.internal.W r1, io.grpc.AbstractC2408g.a r2, java.lang.String r3) {
        /*
            r0 = this;
            r0.f27469d = r1
            r0.f27467b = r2
            r0.f27468c = r3
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Q.<init>(io.grpc.internal.W, io.grpc.g$a, java.lang.String):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public void b() {
        this.f27469d.a(this.f27467b, Status.p.b(String.format("Unable to find compressor by name %s", this.f27468c)), new io.grpc.P());
    }
}
