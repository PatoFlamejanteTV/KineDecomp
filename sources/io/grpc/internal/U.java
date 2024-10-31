package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.W;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
public class U extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Status f27507b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ io.grpc.P f27508c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ W.a f27509d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public U(io.grpc.internal.W.a r1, io.grpc.Status r2, io.grpc.P r3) {
        /*
            r0 = this;
            r0.f27509d = r1
            r0.f27507b = r2
            r0.f27508c = r3
            io.grpc.internal.W r1 = io.grpc.internal.W.this
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.U.<init>(io.grpc.internal.W$a, io.grpc.Status, io.grpc.P):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public final void b() {
        boolean z;
        z = this.f27509d.f27528b;
        if (z) {
            return;
        }
        this.f27509d.b(this.f27507b, this.f27508c);
    }
}
