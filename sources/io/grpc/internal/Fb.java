package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.C2403b;
import io.grpc.C2406e;
import io.grpc.C2512m;
import io.grpc.C2522q;
import io.grpc.C2528x;
import io.grpc.C2530z;
import io.grpc.ConnectivityState;
import io.grpc.InterfaceC2409h;
import io.grpc.J;
import io.grpc.MethodDescriptor;
import io.grpc.S;
import io.grpc.Status;
import io.grpc.internal.C;
import io.grpc.internal.InterfaceC2486t;
import io.grpc.internal.Nb;
import io.grpc.internal.W;
import io.grpc.internal.wc;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
@ThreadSafe
/* loaded from: classes3.dex */
public final class Fb extends io.grpc.K implements InterfaceC2429eb<Object> {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f27278a = Logger.getLogger(Fb.class.getName());

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    static final Pattern f27279b = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    static final Status f27280c = Status.q.b("Channel shutdownNow invoked");

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    static final Status f27281d = Status.q.b("Channel shutdown invoked");

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final Status f27282e = Status.q.b("Subchannel shutdown invoked");
    private boolean A;

    @Nullable
    private b B;

    @Nullable
    private volatile J.f C;
    private boolean D;
    private final C2460ma G;
    private final g H;
    private boolean J;
    private volatile boolean K;
    private volatile boolean L;
    private final C.a N;
    private final C O;
    private final N P;

    @Nullable
    private wc.h R;
    private final long S;
    private final long T;
    private final boolean U;

    @Nullable
    private ScheduledFuture<?> X;

    @Nullable
    private d Y;

    @Nullable
    private InterfaceC2486t Z;
    private final C2446ic ba;

    /* renamed from: g, reason: collision with root package name */
    private final String f27284g;

    /* renamed from: h, reason: collision with root package name */
    private final S.a f27285h;
    private final C2403b i;
    private final J.a j;
    private final Z k;
    private final Executor l;
    private final Ub<? extends Executor> m;
    private final Ub<? extends Executor> n;
    private boolean p;
    private final C2528x q;
    private final C2522q r;
    private final Supplier<Stopwatch> s;
    private final long t;
    private final Gc v;
    private final InterfaceC2486t.a w;
    private final AbstractC2407f x;

    @Nullable
    private final String y;
    private io.grpc.S z;

    /* renamed from: f, reason: collision with root package name */
    private final C2492ub f27283f = C2492ub.a(Fb.class.getName());
    private final M o = new C2502xb(this);
    private final C2428ea u = new C2428ea();
    private final Set<C2461mb> E = new HashSet(16, 0.75f);
    private final Set<Vb> F = new HashSet(1, 0.75f);
    private final AtomicBoolean I = new AtomicBoolean(false);
    private final CountDownLatch M = new CountDownLatch(1);
    private final wc.c Q = new wc.c();
    private final Nb.a V = new C2508zb(this);

    @VisibleForTesting
    final AbstractC2425db<Object> W = new Ab(this);
    private final W.b aa = new Db(this);

    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fb.this.f();
        }

        /* synthetic */ a(Fb fb, C2502xb c2502xb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ManagedChannelImpl.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f27292a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27292a) {
                return;
            }
            Fb.this.X = null;
            Fb.this.Y = null;
            if (Fb.this.z != null) {
                Fb.this.z.b();
            }
        }
    }

    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    private class e extends AbstractC2407f {
        private e() {
        }

        @Override // io.grpc.AbstractC2407f
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e) {
            W w = new W(methodDescriptor, Fb.this.a(c2406e), c2406e, Fb.this.aa, Fb.this.L ? null : Fb.this.k.I(), Fb.this.O, Fb.this.U);
            w.a(Fb.this.p);
            w.a(Fb.this.q);
            w.a(Fb.this.r);
            return w;
        }

        @Override // io.grpc.AbstractC2407f
        public String b() {
            String a2 = Fb.this.z.a();
            Preconditions.a(a2, "authority");
            return a2;
        }

        /* synthetic */ e(Fb fb, C2502xb c2502xb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    public final class f extends AbstractC2431f {

        /* renamed from: a, reason: collision with root package name */
        C2461mb f27295a;

        /* renamed from: b, reason: collision with root package name */
        final Object f27296b = new Object();

        /* renamed from: c, reason: collision with root package name */
        final C2403b f27297c;

        /* renamed from: d, reason: collision with root package name */
        boolean f27298d;

        /* renamed from: e, reason: collision with root package name */
        ScheduledFuture<?> f27299e;

        f(C2403b c2403b) {
            Preconditions.a(c2403b, "attrs");
            this.f27297c = c2403b;
        }

        @Override // io.grpc.J.e
        public C2530z a() {
            return this.f27295a.c();
        }

        @Override // io.grpc.J.e
        public C2403b b() {
            return this.f27297c;
        }

        @Override // io.grpc.J.e
        public void c() {
            this.f27295a.d();
        }

        @Override // io.grpc.J.e
        public void d() {
            synchronized (this.f27296b) {
                if (this.f27298d) {
                    if (!Fb.this.K || this.f27299e == null) {
                        return;
                    }
                    this.f27299e.cancel(false);
                    this.f27299e = null;
                } else {
                    this.f27298d = true;
                }
                if (!Fb.this.K) {
                    this.f27299e = Fb.this.k.I().schedule(new RunnableC2488tb(new Lb(this)), 5L, TimeUnit.SECONDS);
                } else {
                    this.f27295a.b(Fb.f27281d);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.grpc.internal.AbstractC2431f
        public Y e() {
            return this.f27295a.d();
        }

        public String toString() {
            return this.f27295a.a().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(AbstractC2419c<?> abstractC2419c, Z z, InterfaceC2486t.a aVar, Ub<? extends Executor> ub, Supplier<Stopwatch> supplier, List<InterfaceC2409h> list, C.a aVar2) {
        C2502xb c2502xb = null;
        this.H = new g(this, c2502xb);
        String str = abstractC2419c.j;
        Preconditions.a(str, "target");
        this.f27284g = str;
        this.f27285h = abstractC2419c.d();
        C2403b e2 = abstractC2419c.e();
        Preconditions.a(e2, "nameResolverParams");
        this.i = e2;
        this.z = a(this.f27284g, this.f27285h, this.i);
        J.a aVar3 = abstractC2419c.n;
        if (aVar3 == null) {
            this.j = new C2482s();
        } else {
            this.j = aVar3;
        }
        Ub<? extends Executor> ub2 = abstractC2419c.f27580g;
        Preconditions.a(ub2, "executorPool");
        this.m = ub2;
        Preconditions.a(ub, "oobExecutorPool");
        this.n = ub;
        Executor object = this.m.getObject();
        Preconditions.a(object, "executor");
        this.l = object;
        this.G = new C2460ma(this.l, this.o);
        this.G.a(this.V);
        this.w = aVar;
        this.k = new C2506z(z, this.l);
        this.U = abstractC2419c.w && !abstractC2419c.x;
        this.v = new Gc(this.U, abstractC2419c.s);
        AbstractC2407f a2 = C2512m.a(new e(this, c2502xb), this.v);
        AbstractC2503y abstractC2503y = abstractC2419c.B;
        this.x = C2512m.a(abstractC2503y != null ? abstractC2503y.a(a2) : a2, list);
        Preconditions.a(supplier, "stopwatchSupplier");
        this.s = supplier;
        long j = abstractC2419c.r;
        if (j == -1) {
            this.t = j;
        } else {
            Preconditions.a(j >= AbstractC2419c.f27575b, "invalid idleTimeoutMillis %s", abstractC2419c.r);
            this.t = abstractC2419c.r;
        }
        this.ba = new C2446ic(new a(this, c2502xb), new ExecutorC2505yb(this), this.k.I(), supplier.get());
        this.p = abstractC2419c.o;
        C2528x c2528x = abstractC2419c.p;
        Preconditions.a(c2528x, "decompressorRegistry");
        this.q = c2528x;
        C2522q c2522q = abstractC2419c.q;
        Preconditions.a(c2522q, "compressorRegistry");
        this.r = c2522q;
        this.y = abstractC2419c.l;
        this.T = abstractC2419c.u;
        this.S = abstractC2419c.v;
        this.N = aVar2;
        this.O = aVar2.create();
        N n = abstractC2419c.y;
        Preconditions.a(n);
        this.P = n;
        this.P.b(this);
        f27278a.log(Level.FINE, "[{0}] Created with target {1}", new Object[]{a(), this.f27284g});
    }

    public String toString() {
        return MoreObjects.a(this).a("logId", this.f27283f).a("target", this.f27284g).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    public class b extends J.b {

        /* renamed from: a, reason: collision with root package name */
        io.grpc.J f27287a;

        /* renamed from: b, reason: collision with root package name */
        final io.grpc.S f27288b;

        b(io.grpc.S s) {
            Preconditions.a(s, "NameResolver");
            this.f27288b = s;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(io.grpc.r rVar) {
            if (rVar.a() == ConnectivityState.TRANSIENT_FAILURE || rVar.a() == ConnectivityState.IDLE) {
                this.f27288b.b();
            }
        }

        @Override // io.grpc.J.b
        public AbstractC2431f a(C2530z c2530z, C2403b c2403b) {
            Preconditions.a(c2530z, "addressGroup");
            Preconditions.a(c2403b, "attrs");
            Preconditions.b(!Fb.this.L, "Channel is terminated");
            f fVar = new f(c2403b);
            C2461mb c2461mb = new C2461mb(c2530z, Fb.this.b(), Fb.this.y, Fb.this.w, Fb.this.k, Fb.this.k.I(), Fb.this.s, Fb.this.o, new Gb(this, fVar), Fb.this.P, Fb.this.N.create());
            Fb.this.P.c(c2461mb);
            fVar.f27295a = c2461mb;
            Fb.f27278a.log(Level.FINE, "[{0}] {1} created for {2}", new Object[]{Fb.this.a(), c2461mb.a(), c2530z});
            a(new Hb(this, c2461mb));
            return fVar;
        }

        @Override // io.grpc.J.b
        public void a(ConnectivityState connectivityState, J.f fVar) {
            Preconditions.a(connectivityState, "newState");
            Preconditions.a(fVar, "newPicker");
            a(new Ib(this, fVar, connectivityState));
        }

        @Override // io.grpc.J.b
        public void a(J.e eVar, C2530z c2530z) {
            Preconditions.a(eVar instanceof f, "subchannel must have been returned from createSubchannel");
            ((f) eVar).f27295a.a(c2530z);
        }

        public void a(Runnable runnable) {
            M m = Fb.this.o;
            m.a(runnable);
            m.a();
        }
    }

    private void e() {
        ScheduledFuture<?> scheduledFuture = this.X;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.Y.f27292a = true;
            this.X = null;
            this.Y = null;
            this.Z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        f27278a.log(Level.FINE, "[{0}] Entering idle mode", a());
        b(true);
        this.G.a((J.f) null);
        this.z = a(this.f27284g, this.f27285h, this.i);
        this.u.a(ConnectivityState.IDLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.J) {
            Iterator<C2461mb> it = this.E.iterator();
            while (it.hasNext()) {
                it.next().a(f27280c);
            }
            Iterator<Vb> it2 = this.F.iterator();
            while (it2.hasNext()) {
                it2.next().d().a(f27280c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.L && this.I.get() && this.E.isEmpty() && this.F.isEmpty()) {
            f27278a.log(Level.FINE, "[{0}] Terminated", a());
            this.P.e(this);
            this.L = true;
            this.M.countDown();
            this.m.a(this.l);
            this.k.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        long j = this.t;
        if (j == -1) {
            return;
        }
        this.ba.a(j, TimeUnit.MILLISECONDS);
    }

    @Override // io.grpc.K
    public boolean c() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public void d() {
        if (this.I.get() || this.D) {
            return;
        }
        if (this.W.c()) {
            a(false);
        } else {
            i();
        }
        if (this.B != null) {
            return;
        }
        f27278a.log(Level.FINE, "[{0}] Exiting idle mode", a());
        this.B = new b(this.z);
        b bVar = this.B;
        bVar.f27287a = this.j.a(bVar);
        c cVar = new c(this.B);
        try {
            this.z.a(cVar);
            this.A = true;
        } catch (Throwable th) {
            cVar.a(Status.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    public final class g {

        /* renamed from: a, reason: collision with root package name */
        final Object f27301a;

        /* renamed from: b, reason: collision with root package name */
        Collection<X> f27302b;

        /* renamed from: c, reason: collision with root package name */
        Status f27303c;

        private g() {
            this.f27301a = new Object();
            this.f27302b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public Status a(wc<?> wcVar) {
            synchronized (this.f27301a) {
                if (this.f27303c != null) {
                    return this.f27303c;
                }
                this.f27302b.add(wcVar);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(wc<?> wcVar) {
            Status status;
            synchronized (this.f27301a) {
                this.f27302b.remove(wcVar);
                if (this.f27302b.isEmpty()) {
                    status = this.f27303c;
                    this.f27302b = new HashSet();
                } else {
                    status = null;
                }
            }
            if (status != null) {
                Fb.this.G.b(status);
            }
        }

        /* synthetic */ g(Fb fb, C2502xb c2502xb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            Preconditions.b(this.z != null, "nameResolver is null");
            Preconditions.b(this.B != null, "lbHelper is null");
        }
        if (this.z != null) {
            e();
            this.z.c();
            this.z = null;
            this.A = false;
        }
        b bVar = this.B;
        if (bVar != null) {
            bVar.f27287a.a();
            this.B = null;
        }
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ManagedChannelImpl.java */
    /* loaded from: classes3.dex */
    public class c implements S.b {

        /* renamed from: a, reason: collision with root package name */
        final b f27290a;

        c(b bVar) {
            this.f27290a = bVar;
        }

        @Override // io.grpc.S.b
        public void a(List<C2530z> list, C2403b c2403b) {
            if (list.isEmpty()) {
                a(Status.q.b("NameResolver returned an empty list"));
                return;
            }
            if (Fb.f27278a.isLoggable(Level.FINE)) {
                Fb.f27278a.log(Level.FINE, "[{0}] resolved address: {1}, config={2}", new Object[]{Fb.this.a(), list, c2403b});
            }
            this.f27290a.a(new Kb(this, c2403b, list));
        }

        @Override // io.grpc.S.b
        public void a(Status status) {
            Preconditions.a(!status.g(), "the error status must not be OK");
            Fb.f27278a.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{Fb.this.a(), status});
            M m = Fb.this.o;
            m.a(new Jb(this, status));
            m.a();
        }
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.f27283f;
    }

    private void a(boolean z) {
        this.ba.a(z);
    }

    @VisibleForTesting
    static io.grpc.S a(String str, S.a aVar, C2403b c2403b) {
        URI uri;
        io.grpc.S a2;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb.append(e2.getMessage());
            uri = null;
        }
        if (uri != null && (a2 = aVar.a(uri, c2403b)) != null) {
            return a2;
        }
        String str2 = "";
        if (!f27279b.matcher(str).matches()) {
            try {
                io.grpc.S a3 = aVar.a(new URI(aVar.a(), "", "/" + str, null), c2403b);
                if (a3 != null) {
                    return a3;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    @Override // io.grpc.AbstractC2407f
    public String b() {
        return this.x.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static wc.h b(C2403b c2403b) {
        return Hc.n((Map) c2403b.a(Sa.f27502a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public void a(Throwable th) {
        if (this.D) {
            return;
        }
        this.D = true;
        a(true);
        b(false);
        a(new Eb(this, th));
        this.u.a(ConnectivityState.TRANSIENT_FAILURE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(J.f fVar) {
        this.C = fVar;
        this.G.a(fVar);
    }

    @Override // io.grpc.AbstractC2407f
    public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e) {
        return this.x.a(methodDescriptor, c2406e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Executor a(C2406e c2406e) {
        Executor e2 = c2406e.e();
        return e2 == null ? this.l : e2;
    }
}
