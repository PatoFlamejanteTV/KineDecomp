package io.grpc.internal;

import io.grpc.AbstractC2408g;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.Oc;
import io.grpc.internal.W;
import java.io.InputStream;

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
class T extends AbstractRunnableC2432fa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Oc.a f27504b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ W.a f27505c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T(io.grpc.internal.W.a r1, io.grpc.internal.Oc.a r2) {
        /*
            r0 = this;
            r0.f27505c = r1
            r0.f27504b = r2
            io.grpc.internal.W r1 = io.grpc.internal.W.this
            io.grpc.Context r1 = io.grpc.internal.W.e(r1)
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.T.<init>(io.grpc.internal.W$a, io.grpc.internal.Oc$a):void");
    }

    @Override // io.grpc.internal.AbstractRunnableC2432fa
    public final void b() {
        boolean z;
        AbstractC2408g.a aVar;
        MethodDescriptor methodDescriptor;
        z = this.f27505c.f27528b;
        if (z) {
            GrpcUtil.a(this.f27504b);
            return;
        }
        while (true) {
            try {
                InputStream next = this.f27504b.next();
                if (next == null) {
                    return;
                }
                try {
                    aVar = this.f27505c.f27527a;
                    methodDescriptor = W.this.f27521c;
                    aVar.a((AbstractC2408g.a) methodDescriptor.a(next));
                    next.close();
                } catch (Throwable th) {
                    GrpcUtil.a(next);
                    throw th;
                }
            } catch (Throwable th2) {
                GrpcUtil.a(this.f27504b);
                Status b2 = Status.f27130c.b(th2).b("Failed to read message.");
                W.this.k.a(b2);
                this.f27505c.b(b2, new io.grpc.P());
                return;
            }
        }
    }
}
