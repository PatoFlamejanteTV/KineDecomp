package io.grpc.c;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.umeng.commonsdk.proguard.e;
import io.grpc.C2403b;
import io.grpc.C2530z;
import io.grpc.ConnectivityState;
import io.grpc.J;
import io.grpc.Status;
import io.grpc.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nullable;

/* compiled from: RoundRobinLoadBalancerFactory.java */
/* loaded from: classes3.dex */
public final class a extends J.a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f27172a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundRobinLoadBalancerFactory.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        T f27177a;

        b(T t) {
            this.f27177a = t;
        }
    }

    private a() {
    }

    @Override // io.grpc.J.a
    public J a(J.b bVar) {
        return new c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundRobinLoadBalancerFactory.java */
    @VisibleForTesting
    /* renamed from: io.grpc.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0156a extends J.f {

        /* renamed from: a, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater<C0156a> f27173a = AtomicIntegerFieldUpdater.newUpdater(C0156a.class, e.am);

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Status f27174b;

        /* renamed from: c, reason: collision with root package name */
        private final List<J.e> f27175c;

        /* renamed from: d, reason: collision with root package name */
        private volatile int f27176d = -1;

        C0156a(List<J.e> list, @Nullable Status status) {
            this.f27175c = list;
            this.f27174b = status;
        }

        @Override // io.grpc.J.f
        public J.c a(J.d dVar) {
            if (this.f27175c.size() > 0) {
                return J.c.a(a());
            }
            Status status = this.f27174b;
            if (status != null) {
                return J.c.b(status);
            }
            return J.c.e();
        }

        private J.e a() {
            int i;
            if (!this.f27175c.isEmpty()) {
                int size = this.f27175c.size();
                int incrementAndGet = f27173a.incrementAndGet(this);
                if (incrementAndGet >= size) {
                    i = incrementAndGet % size;
                    f27173a.compareAndSet(this, incrementAndGet, i);
                } else {
                    i = incrementAndGet;
                }
                return this.f27175c.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: RoundRobinLoadBalancerFactory.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    static final class c extends J {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        static final C2403b.C0153b<b<r>> f27178a = C2403b.C0153b.a("state-info");

        /* renamed from: b, reason: collision with root package name */
        private final J.b f27179b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<C2530z, J.e> f27180c = new HashMap();

        c(J.b bVar) {
            Preconditions.a(bVar, "helper");
            this.f27179b = bVar;
        }

        @Nullable
        private Status c() {
            Iterator<J.e> it = b().iterator();
            Status status = null;
            while (it.hasNext()) {
                r rVar = a(it.next()).f27177a;
                if (rVar.a() != ConnectivityState.TRANSIENT_FAILURE) {
                    return null;
                }
                status = rVar.b();
            }
            return status;
        }

        private ConnectivityState d() {
            EnumSet noneOf = EnumSet.noneOf(ConnectivityState.class);
            Iterator<J.e> it = b().iterator();
            while (it.hasNext()) {
                noneOf.add(a(it.next()).f27177a.a());
            }
            if (noneOf.contains(ConnectivityState.READY)) {
                return ConnectivityState.READY;
            }
            if (noneOf.contains(ConnectivityState.CONNECTING)) {
                return ConnectivityState.CONNECTING;
            }
            if (noneOf.contains(ConnectivityState.IDLE)) {
                return ConnectivityState.CONNECTING;
            }
            return ConnectivityState.TRANSIENT_FAILURE;
        }

        @Override // io.grpc.J
        public void a(List<C2530z> list, C2403b c2403b) {
            Set<C2530z> keySet = this.f27180c.keySet();
            Set<C2530z> a2 = a(list);
            Set<C2530z> a3 = a(a2, keySet);
            Set a4 = a(keySet, a2);
            for (C2530z c2530z : a3) {
                C2403b.a b2 = C2403b.b();
                b2.a(f27178a, new b(r.a(ConnectivityState.IDLE)));
                J.e a5 = this.f27179b.a(c2530z, b2.a());
                Preconditions.a(a5, "subchannel");
                J.e eVar = a5;
                this.f27180c.put(c2530z, eVar);
                eVar.c();
            }
            Iterator it = a4.iterator();
            while (it.hasNext()) {
                this.f27180c.remove((C2530z) it.next()).d();
            }
            a(d(), c());
        }

        @VisibleForTesting
        Collection<J.e> b() {
            return this.f27180c.values();
        }

        @Override // io.grpc.J
        public void a(Status status) {
            a(ConnectivityState.TRANSIENT_FAILURE, status);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.J
        public void a(J.e eVar, r rVar) {
            if (this.f27180c.get(eVar.a()) != eVar) {
                return;
            }
            if (rVar.a() == ConnectivityState.IDLE) {
                eVar.c();
            }
            a(eVar).f27177a = rVar;
            a(d(), c());
        }

        @Override // io.grpc.J
        public void a() {
            Iterator<J.e> it = b().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }

        private void a(ConnectivityState connectivityState, Status status) {
            this.f27179b.a(connectivityState, new C0156a(a(b()), status));
        }

        private static List<J.e> a(Collection<J.e> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (J.e eVar : collection) {
                if (a(eVar).f27177a.a() == ConnectivityState.READY) {
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        }

        private static Set<C2530z> a(List<C2530z> list) {
            HashSet hashSet = new HashSet(list.size());
            Iterator<C2530z> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(new C2530z(it.next().a()));
            }
            return hashSet;
        }

        private static b<r> a(J.e eVar) {
            Object a2 = eVar.b().a(f27178a);
            Preconditions.a(a2, "STATE_INFO");
            return (b) a2;
        }

        private static <T> Set<T> a(Set<T> set, Set<T> set2) {
            HashSet hashSet = new HashSet(set);
            hashSet.removeAll(set2);
            return hashSet;
        }
    }
}
