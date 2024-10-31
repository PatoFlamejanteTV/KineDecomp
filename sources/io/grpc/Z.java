package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.J;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PickFirstBalancerFactory.java */
/* loaded from: classes3.dex */
public final class Z extends J.a {

    /* renamed from: a, reason: collision with root package name */
    private static final Z f27144a = new Z();

    /* compiled from: PickFirstBalancerFactory.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class b extends J.f {

        /* renamed from: a, reason: collision with root package name */
        private final J.c f27147a;

        b(J.c cVar) {
            Preconditions.a(cVar, "result");
            this.f27147a = cVar;
        }

        @Override // io.grpc.J.f
        public J.c a(J.d dVar) {
            return this.f27147a;
        }
    }

    private Z() {
    }

    public static Z a() {
        return f27144a;
    }

    @Override // io.grpc.J.a
    public J a(J.b bVar) {
        return new a(bVar);
    }

    /* compiled from: PickFirstBalancerFactory.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class a extends J {

        /* renamed from: a, reason: collision with root package name */
        private final J.b f27145a;

        /* renamed from: b, reason: collision with root package name */
        private J.e f27146b;

        a(J.b bVar) {
            Preconditions.a(bVar, "helper");
            this.f27145a = bVar;
        }

        @Override // io.grpc.J
        public void a(List<C2530z> list, C2403b c2403b) {
            C2530z a2 = a(list);
            J.e eVar = this.f27146b;
            if (eVar == null) {
                this.f27146b = this.f27145a.a(a2, C2403b.f27155a);
                this.f27145a.a(ConnectivityState.CONNECTING, new b(J.c.a(this.f27146b)));
                this.f27146b.c();
                return;
            }
            this.f27145a.a(eVar, a2);
        }

        @Override // io.grpc.J
        public void a(Status status) {
            J.e eVar = this.f27146b;
            if (eVar != null) {
                eVar.d();
                this.f27146b = null;
            }
            this.f27145a.a(ConnectivityState.TRANSIENT_FAILURE, new b(J.c.b(status)));
        }

        @Override // io.grpc.J
        public void a(J.e eVar, r rVar) {
            J.c e2;
            ConnectivityState a2 = rVar.a();
            if (eVar != this.f27146b || a2 == ConnectivityState.SHUTDOWN) {
                return;
            }
            int i = Y.f27143a[a2.ordinal()];
            if (i == 1) {
                e2 = J.c.e();
            } else if (i == 2 || i == 3) {
                e2 = J.c.a(eVar);
            } else if (i == 4) {
                e2 = J.c.b(rVar.b());
            } else {
                throw new IllegalArgumentException("Unsupported state:" + a2);
            }
            this.f27145a.a(a2, new b(e2));
        }

        @Override // io.grpc.J
        public void a() {
            J.e eVar = this.f27146b;
            if (eVar != null) {
                eVar.d();
            }
        }

        private static C2530z a(List<C2530z> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<C2530z> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().a());
            }
            return new C2530z(arrayList);
        }
    }
}
