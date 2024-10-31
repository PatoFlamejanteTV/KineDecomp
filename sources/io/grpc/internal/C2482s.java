package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.C2403b;
import io.grpc.C2530z;
import io.grpc.ConnectivityState;
import io.grpc.J;
import io.grpc.Status;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: AutoConfiguredLoadBalancerFactory.java */
/* renamed from: io.grpc.internal.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2482s extends J.a {

    /* compiled from: AutoConfiguredLoadBalancerFactory.java */
    /* renamed from: io.grpc.internal.s$b */
    /* loaded from: classes3.dex */
    private static final class b extends J.f {
        private b() {
        }

        @Override // io.grpc.J.f
        public J.c a(J.d dVar) {
            return J.c.e();
        }
    }

    @Override // io.grpc.J.a
    public io.grpc.J a(J.b bVar) {
        return new a(bVar);
    }

    /* compiled from: AutoConfiguredLoadBalancerFactory.java */
    @VisibleForTesting
    /* renamed from: io.grpc.internal.s$a */
    /* loaded from: classes3.dex */
    static final class a extends io.grpc.J {

        /* renamed from: a, reason: collision with root package name */
        private final J.b f27731a;

        /* renamed from: b, reason: collision with root package name */
        private io.grpc.J f27732b;

        /* renamed from: c, reason: collision with root package name */
        private J.a f27733c;

        a(J.b bVar) {
            this.f27731a = bVar;
            a(io.grpc.Z.a());
            a(c().a(bVar));
        }

        @Override // io.grpc.J
        public void a(List<C2530z> list, C2403b c2403b) {
            J.a a2;
            if (c2403b.a().contains(Sa.f27502a) && (a2 = a(list, (Map<String, Object>) c2403b.a(Sa.f27502a))) != null && a2 != this.f27733c) {
                this.f27731a.a(ConnectivityState.CONNECTING, new b());
                b().a();
                a(a2);
                a(c().a(this.f27731a));
            }
            b().a(list, c2403b);
        }

        @VisibleForTesting
        io.grpc.J b() {
            return this.f27732b;
        }

        @VisibleForTesting
        J.a c() {
            return this.f27733c;
        }

        @Override // io.grpc.J
        public void a(Status status) {
            b().a(status);
        }

        @Override // io.grpc.J
        public void a(J.e eVar, io.grpc.r rVar) {
            b().a(eVar, rVar);
        }

        @Override // io.grpc.J
        public void a() {
            b().a();
            a((io.grpc.J) null);
        }

        @VisibleForTesting
        void a(io.grpc.J j) {
            this.f27732b = j;
        }

        @VisibleForTesting
        void a(J.a aVar) {
            this.f27733c = aVar;
        }

        @VisibleForTesting
        @Nullable
        static J.a a(List<C2530z> list, Map<String, Object> map) {
            boolean z;
            Iterator<C2530z> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().b().a(Sa.f27503b) != null) {
                    z = true;
                    break;
                }
            }
            if (z) {
                try {
                    return (J.a) Class.forName("io.grpc.grpclb.GrpclbLoadBalancerFactory").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException("Can't get GRPCLB, but balancer addresses were present", e3);
                }
            }
            String c2 = Hc.c(map);
            if (c2 != null) {
                if (c2.toUpperCase(Locale.ROOT).equals("ROUND_ROBIN")) {
                    try {
                        return (J.a) Class.forName("io.grpc.c.a").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception e5) {
                        throw new RuntimeException("Can't get Round Robin LB", e5);
                    }
                }
                throw new IllegalArgumentException("Unknown service config policy: " + c2);
            }
            return io.grpc.Z.a();
        }
    }
}
