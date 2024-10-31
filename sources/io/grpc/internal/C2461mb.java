package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.ForOverride;
import io.grpc.C2406e;
import io.grpc.C2530z;
import io.grpc.ConnectivityState;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.InterfaceC2486t;
import io.grpc.internal.Nb;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalSubchannel.java */
@ThreadSafe
/* renamed from: io.grpc.internal.mb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2461mb implements InterfaceC2429eb<Object> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27681a = Logger.getLogger(C2461mb.class.getName());

    /* renamed from: c, reason: collision with root package name */
    private final String f27683c;

    /* renamed from: d, reason: collision with root package name */
    private final String f27684d;

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC2486t.a f27685e;

    /* renamed from: f, reason: collision with root package name */
    private final b f27686f;

    /* renamed from: g, reason: collision with root package name */
    private final Z f27687g;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f27688h;
    private final N i;
    private final C j;
    private final M l;
    private C2530z m;
    private int n;
    private InterfaceC2486t o;
    private final Stopwatch p;

    @Nullable
    private ScheduledFuture<?> q;
    private boolean r;

    @Nullable
    private InterfaceC2424da u;

    @Nullable
    private volatile Nb v;
    private Status x;

    /* renamed from: b, reason: collision with root package name */
    private final C2492ub f27682b = C2492ub.a(C2461mb.class.getName());
    private final Object k = new Object();
    private final Collection<InterfaceC2424da> s = new ArrayList();
    private final AbstractC2425db<InterfaceC2424da> t = new C2433fb(this);
    private io.grpc.r w = io.grpc.r.a(ConnectivityState.IDLE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalSubchannel.java */
    @VisibleForTesting
    /* renamed from: io.grpc.internal.mb$a */
    /* loaded from: classes3.dex */
    public static final class a extends Na {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC2424da f27689a;

        /* renamed from: b, reason: collision with root package name */
        private final C f27690b;

        /* synthetic */ a(InterfaceC2424da interfaceC2424da, C c2, C2433fb c2433fb) {
            this(interfaceC2424da, c2);
        }

        @Override // io.grpc.internal.Na
        protected InterfaceC2424da b() {
            return this.f27689a;
        }

        private a(InterfaceC2424da interfaceC2424da, C c2) {
            this.f27689a = interfaceC2424da;
            this.f27690b = c2;
        }

        @Override // io.grpc.internal.Na, io.grpc.internal.Y
        public X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
            return new C2457lb(this, super.a(methodDescriptor, p, c2406e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalSubchannel.java */
    /* renamed from: io.grpc.internal.mb$b */
    /* loaded from: classes3.dex */
    public static abstract class b {
        /* JADX INFO: Access modifiers changed from: package-private */
        @ForOverride
        public abstract void a(C2461mb c2461mb);

        /* JADX INFO: Access modifiers changed from: package-private */
        @ForOverride
        public abstract void a(C2461mb c2461mb, io.grpc.r rVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        @ForOverride
        public abstract void b(C2461mb c2461mb);

        /* JADX INFO: Access modifiers changed from: package-private */
        @ForOverride
        public abstract void c(C2461mb c2461mb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2461mb(C2530z c2530z, String str, String str2, InterfaceC2486t.a aVar, Z z, ScheduledExecutorService scheduledExecutorService, Supplier<Stopwatch> supplier, M m, b bVar, N n, C c2) {
        Preconditions.a(c2530z, "addressGroup");
        this.m = c2530z;
        this.f27683c = str;
        this.f27684d = str2;
        this.f27685e = aVar;
        this.f27687g = z;
        this.f27688h = scheduledExecutorService;
        this.p = supplier.get();
        this.l = m;
        this.f27686f = bVar;
        this.i = n;
        this.j = c2;
    }

    static /* synthetic */ int h(C2461mb c2461mb) {
        int i = c2461mb.n;
        c2461mb.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Status status) {
        a(io.grpc.r.a(status));
        if (this.o == null) {
            this.o = this.f27685e.get();
        }
        long a2 = this.o.a() - this.p.a(TimeUnit.NANOSECONDS);
        if (f27681a.isLoggable(Level.FINE)) {
            f27681a.log(Level.FINE, "[{0}] Scheduling backoff for {1} ns", new Object[]{this.f27682b, Long.valueOf(a2)});
        }
        Preconditions.b(this.q == null, "previous reconnectTask is not done");
        this.r = false;
        this.q = this.f27688h.schedule(new RunnableC2488tb(new RunnableC2437gb(this)), a2, TimeUnit.NANOSECONDS);
    }

    private void e() {
        ScheduledFuture<?> scheduledFuture = this.q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.r = true;
            this.q = null;
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.l.a(new RunnableC2445ib(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        C2422cc c2422cc;
        Preconditions.b(this.q == null, "Should have no reconnectTask scheduled");
        if (this.n == 0) {
            this.p.c().d();
        }
        SocketAddress socketAddress = this.m.a().get(this.n);
        C2433fb c2433fb = null;
        if (socketAddress instanceof PairSocketAddress) {
            PairSocketAddress pairSocketAddress = (PairSocketAddress) socketAddress;
            c2422cc = (C2422cc) pairSocketAddress.getAttributes().a(Zb.f27542a);
            socketAddress = pairSocketAddress.getAddress();
        } else {
            c2422cc = null;
        }
        a aVar = new a(this.f27687g.a(socketAddress, this.f27683c, this.f27684d, c2422cc), this.j, c2433fb);
        this.i.a((InterfaceC2429eb<Object>) aVar);
        if (f27681a.isLoggable(Level.FINE)) {
            f27681a.log(Level.FINE, "[{0}] Created {1} for {2}", new Object[]{this.f27682b, aVar.a(), socketAddress});
        }
        this.u = aVar;
        this.s.add(aVar);
        Runnable a2 = aVar.a(new c(aVar, socketAddress));
        if (a2 != null) {
            this.l.a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Y d() {
        Nb nb = this.v;
        if (nb != null) {
            return nb;
        }
        try {
            synchronized (this.k) {
                Nb nb2 = this.v;
                if (nb2 != null) {
                    return nb2;
                }
                if (this.w.a() == ConnectivityState.IDLE) {
                    a(ConnectivityState.CONNECTING);
                    g();
                }
                this.l.a();
                return null;
            }
        } finally {
            this.l.a();
        }
    }

    public void b(Status status) {
        try {
            synchronized (this.k) {
                if (this.w.a() == ConnectivityState.SHUTDOWN) {
                    return;
                }
                this.x = status;
                a(ConnectivityState.SHUTDOWN);
                Nb nb = this.v;
                InterfaceC2424da interfaceC2424da = this.u;
                this.v = null;
                this.u = null;
                this.n = 0;
                if (this.s.isEmpty()) {
                    f();
                    if (f27681a.isLoggable(Level.FINE)) {
                        f27681a.log(Level.FINE, "[{0}] Terminated in shutdown()", this.f27682b);
                    }
                }
                e();
                if (nb != null) {
                    nb.b(status);
                }
                if (interfaceC2424da != null) {
                    interfaceC2424da.b(status);
                }
            }
        } finally {
            this.l.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConnectivityState connectivityState) {
        a(io.grpc.r.a(connectivityState));
    }

    private void a(io.grpc.r rVar) {
        if (this.w.a() != rVar.a()) {
            Preconditions.b(this.w.a() != ConnectivityState.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + rVar);
            this.w = rVar;
            this.l.a(new RunnableC2441hb(this, rVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2530z c() {
        C2530z c2530z;
        try {
            synchronized (this.k) {
                c2530z = this.m;
            }
            return c2530z;
        } finally {
            this.l.a();
        }
    }

    public void a(C2530z c2530z) {
        Nb nb;
        try {
            synchronized (this.k) {
                C2530z c2530z2 = this.m;
                this.m = c2530z;
                if (this.w.a() == ConnectivityState.READY || this.w.a() == ConnectivityState.CONNECTING) {
                    int indexOf = c2530z.a().indexOf(c2530z2.a().get(this.n));
                    if (indexOf != -1) {
                        this.n = indexOf;
                    } else if (this.w.a() == ConnectivityState.READY) {
                        nb = this.v;
                        this.v = null;
                        this.n = 0;
                        a(ConnectivityState.IDLE);
                    } else {
                        nb = this.u;
                        this.u = null;
                        this.n = 0;
                        g();
                    }
                }
                nb = null;
            }
            if (nb != null) {
                nb.b(Status.q.b("InternalSubchannel closed transport due to address change"));
            }
        } finally {
            this.l.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalSubchannel.java */
    /* renamed from: io.grpc.internal.mb$c */
    /* loaded from: classes3.dex */
    public class c implements Nb.a {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC2424da f27691a;

        /* renamed from: b, reason: collision with root package name */
        final SocketAddress f27692b;

        c(InterfaceC2424da interfaceC2424da, SocketAddress socketAddress) {
            this.f27691a = interfaceC2424da;
            this.f27692b = socketAddress;
        }

        @Override // io.grpc.internal.Nb.a
        public void a() {
            Status status;
            boolean z = true;
            if (C2461mb.f27681a.isLoggable(Level.FINE)) {
                C2461mb.f27681a.log(Level.FINE, "[{0}] {1} for {2} is ready", new Object[]{C2461mb.this.f27682b, this.f27691a.a(), this.f27692b});
            }
            try {
                synchronized (C2461mb.this.k) {
                    status = C2461mb.this.x;
                    C2461mb.this.o = null;
                    if (status != null) {
                        if (C2461mb.this.v != null) {
                            z = false;
                        }
                        Preconditions.b(z, "Unexpected non-null activeTransport");
                    } else if (C2461mb.this.u == this.f27691a) {
                        C2461mb.this.a(ConnectivityState.READY);
                        C2461mb.this.v = this.f27691a;
                        C2461mb.this.u = null;
                    }
                }
                if (status != null) {
                    this.f27691a.b(status);
                }
            } finally {
                C2461mb.this.l.a();
            }
        }

        @Override // io.grpc.internal.Nb.a
        public void b() {
            if (C2461mb.f27681a.isLoggable(Level.FINE)) {
                C2461mb.f27681a.log(Level.FINE, "[{0}] {1} for {2} is terminated", new Object[]{C2461mb.this.f27682b, this.f27691a.a(), this.f27692b});
            }
            C2461mb.this.i.d(this.f27691a);
            C2461mb.this.a(this.f27691a, false);
            try {
                synchronized (C2461mb.this.k) {
                    C2461mb.this.s.remove(this.f27691a);
                    if (C2461mb.this.w.a() == ConnectivityState.SHUTDOWN && C2461mb.this.s.isEmpty()) {
                        if (C2461mb.f27681a.isLoggable(Level.FINE)) {
                            C2461mb.f27681a.log(Level.FINE, "[{0}] Terminated in transportTerminated()", C2461mb.this.f27682b);
                        }
                        C2461mb.this.f();
                    }
                }
                C2461mb.this.l.a();
                Preconditions.b(C2461mb.this.v != this.f27691a, "activeTransport still points to this transport. Seems transportShutdown() was not called.");
            } catch (Throwable th) {
                C2461mb.this.l.a();
                throw th;
            }
        }

        @Override // io.grpc.internal.Nb.a
        public void a(boolean z) {
            C2461mb.this.a(this.f27691a, z);
        }

        @Override // io.grpc.internal.Nb.a
        public void a(Status status) {
            boolean z = true;
            if (C2461mb.f27681a.isLoggable(Level.FINE)) {
                C2461mb.f27681a.log(Level.FINE, "[{0}] {1} for {2} is being shutdown with status {3}", new Object[]{C2461mb.this.f27682b, this.f27691a.a(), this.f27692b, status});
            }
            try {
                synchronized (C2461mb.this.k) {
                    if (C2461mb.this.w.a() == ConnectivityState.SHUTDOWN) {
                        return;
                    }
                    if (C2461mb.this.v != this.f27691a) {
                        if (C2461mb.this.u == this.f27691a) {
                            if (C2461mb.this.w.a() != ConnectivityState.CONNECTING) {
                                z = false;
                            }
                            Preconditions.b(z, "Expected state is CONNECTING, actual state is %s", C2461mb.this.w.a());
                            C2461mb.h(C2461mb.this);
                            if (C2461mb.this.n < C2461mb.this.m.a().size()) {
                                C2461mb.this.g();
                            } else {
                                C2461mb.this.u = null;
                                C2461mb.this.n = 0;
                                C2461mb.this.c(status);
                            }
                        }
                    } else {
                        C2461mb.this.a(ConnectivityState.IDLE);
                        C2461mb.this.v = null;
                        C2461mb.this.n = 0;
                    }
                }
            } finally {
                C2461mb.this.l.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC2424da interfaceC2424da, boolean z) {
        M m = this.l;
        m.a(new RunnableC2449jb(this, interfaceC2424da, z));
        m.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Status status) {
        ArrayList arrayList;
        b(status);
        try {
            synchronized (this.k) {
                arrayList = new ArrayList(this.s);
            }
            this.l.a();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Nb) it.next()).a(status);
            }
        } catch (Throwable th) {
            this.l.a();
            throw th;
        }
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.f27682b;
    }
}
