package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2406e;
import io.grpc.C2526v;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.Ac;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/* compiled from: ServiceConfigInterceptor.java */
/* loaded from: classes3.dex */
public final class Gc implements InterfaceC2409h {

    /* renamed from: a */
    private static final Logger f27325a = Logger.getLogger(Gc.class.getName());

    /* renamed from: b */
    static final C2406e.a<Ac.a> f27326b = C2406e.a.a("internal-retry-policy", null);

    /* renamed from: c */
    @VisibleForTesting
    final AtomicReference<Map<String, a>> f27327c = new AtomicReference<>();

    /* renamed from: d */
    @VisibleForTesting
    final AtomicReference<Map<String, a>> f27328d = new AtomicReference<>();

    /* renamed from: e */
    private final boolean f27329e;

    /* renamed from: f */
    private final int f27330f;

    /* renamed from: g */
    private volatile boolean f27331g;

    /* compiled from: ServiceConfigInterceptor.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final Long f27332a;

        /* renamed from: b */
        final Boolean f27333b;

        /* renamed from: c */
        final Integer f27334c;

        /* renamed from: d */
        final Integer f27335d;

        /* renamed from: e */
        final Ac f27336e;

        a(Map<String, Object> map, boolean z, int i) {
            this.f27332a = Hc.o(map);
            this.f27333b = Hc.p(map);
            this.f27334c = Hc.g(map);
            Integer num = this.f27334c;
            if (num != null) {
                Preconditions.a(num.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", this.f27334c);
            }
            this.f27335d = Hc.f(map);
            Integer num2 = this.f27335d;
            if (num2 != null) {
                Preconditions.a(num2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", this.f27335d);
            }
            Map<String, Object> k = z ? Hc.k(map) : null;
            this.f27336e = k == null ? Ac.f27199a : a(k, i);
        }

        private static Ac a(Map<String, Object> map, int i) {
            Integer d2 = Hc.d(map);
            Preconditions.a(d2, "maxAttempts cannot be empty");
            int intValue = d2.intValue();
            Preconditions.a(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            Long b2 = Hc.b(map);
            Preconditions.a(b2, "initialBackoff cannot be empty");
            long longValue = b2.longValue();
            Preconditions.a(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            Long e2 = Hc.e(map);
            Preconditions.a(e2, "maxBackoff cannot be empty");
            long longValue2 = e2.longValue();
            Preconditions.a(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            Double a2 = Hc.a(map);
            Preconditions.a(a2, "backoffMultiplier cannot be empty");
            double doubleValue = a2.doubleValue();
            Preconditions.a(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            List<String> l = Hc.l(map);
            Preconditions.a(l, "rawCodes must be present");
            Preconditions.a(!l.isEmpty(), "rawCodes can't be empty");
            EnumSet noneOf = EnumSet.noneOf(Status.Code.class);
            Iterator<String> it = l.iterator();
            while (it.hasNext()) {
                noneOf.add(Status.Code.valueOf(it.next()));
            }
            return new Ac(min, longValue, longValue2, doubleValue, Collections.unmodifiableSet(noneOf));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.a(this.f27332a, aVar.f27332a) && Objects.a(this.f27333b, aVar.f27333b) && Objects.a(this.f27334c, aVar.f27334c) && Objects.a(this.f27335d, aVar.f27335d) && Objects.a(this.f27336e, aVar.f27336e);
        }

        public int hashCode() {
            return Objects.a(this.f27332a, this.f27333b, this.f27334c, this.f27335d, this.f27336e);
        }

        public String toString() {
            return MoreObjects.a(this).a("timeoutNanos", this.f27332a).a("waitForReady", this.f27333b).a("maxInboundMessageSize", this.f27334c).a("maxOutboundMessageSize", this.f27335d).a("retryPolicy", this.f27336e).toString();
        }
    }

    public Gc(boolean z, int i) {
        this.f27329e = z;
        this.f27330f = i;
    }

    @CheckForNull
    private a b(MethodDescriptor<?, ?> methodDescriptor) {
        Map<String, a> map;
        Map<String, a> map2 = this.f27327c.get();
        a aVar = map2 != null ? map2.get(methodDescriptor.a()) : null;
        return (aVar != null || (map = this.f27328d.get()) == null) ? aVar : map.get(MethodDescriptor.a(methodDescriptor.a()));
    }

    public void a(@Nonnull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<Map<String, Object>> h2 = Hc.h(map);
        if (h2 == null) {
            f27325a.log(Level.FINE, "No method configs found, skipping");
            this.f27331g = true;
            return;
        }
        for (Map<String, Object> map2 : h2) {
            a aVar = new a(map2, this.f27329e, this.f27330f);
            List<Map<String, Object>> j = Hc.j(map2);
            Preconditions.a((j == null || j.isEmpty()) ? false : true, "no names in method config %s", map2);
            for (Map<String, Object> map3 : j) {
                String m = Hc.m(map3);
                Preconditions.a(!Strings.a(m), "missing service name");
                String i = Hc.i(map3);
                if (Strings.a(i)) {
                    Preconditions.a(!hashMap2.containsKey(m), "Duplicate service %s", m);
                    hashMap2.put(m, aVar);
                } else {
                    String a2 = MethodDescriptor.a(m, i);
                    Preconditions.a(!hashMap.containsKey(a2), "Duplicate method name %s", a2);
                    hashMap.put(a2, aVar);
                }
            }
        }
        this.f27327c.set(Collections.unmodifiableMap(hashMap));
        this.f27328d.set(Collections.unmodifiableMap(hashMap2));
        this.f27331g = true;
    }

    @Override // io.grpc.InterfaceC2409h
    public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
        if (this.f27329e) {
            if (this.f27331g) {
                c2406e = c2406e.a(f27326b, new Fc(this, a((MethodDescriptor<?, ?>) methodDescriptor)));
            } else {
                c2406e = c2406e.a(f27326b, new Ec(this, methodDescriptor));
            }
        }
        a b2 = b(methodDescriptor);
        if (b2 == null) {
            return abstractC2407f.a(methodDescriptor, c2406e);
        }
        Long l = b2.f27332a;
        if (l != null) {
            C2526v a2 = C2526v.a(l.longValue(), TimeUnit.NANOSECONDS);
            C2526v d2 = c2406e.d();
            if (d2 == null || a2.compareTo(d2) < 0) {
                c2406e = c2406e.a(a2);
            }
        }
        Boolean bool = b2.f27333b;
        if (bool != null) {
            c2406e = bool.booleanValue() ? c2406e.j() : c2406e.k();
        }
        if (b2.f27334c != null) {
            Integer f2 = c2406e.f();
            if (f2 != null) {
                c2406e = c2406e.a(Math.min(f2.intValue(), b2.f27334c.intValue()));
            } else {
                c2406e = c2406e.a(b2.f27334c.intValue());
            }
        }
        if (b2.f27335d != null) {
            Integer g2 = c2406e.g();
            if (g2 != null) {
                c2406e = c2406e.b(Math.min(g2.intValue(), b2.f27335d.intValue()));
            } else {
                c2406e = c2406e.b(b2.f27335d.intValue());
            }
        }
        return abstractC2407f.a(methodDescriptor, c2406e);
    }

    @VisibleForTesting
    public Ac a(MethodDescriptor<?, ?> methodDescriptor) {
        Ac ac;
        a b2 = b(methodDescriptor);
        return (b2 == null || (ac = b2.f27336e) == null) ? Ac.f27199a : ac;
    }
}
