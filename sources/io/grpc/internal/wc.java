package io.grpc.internal;

import android.support.v4.app.NotificationManagerCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.AbstractC2513n;
import io.grpc.C2528x;
import io.grpc.InterfaceC2521p;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.internal.Ac;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Oc;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetriableStream.java */
/* loaded from: classes3.dex */
public abstract class wc<ReqT> implements X {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final P.e<String> f27756a = P.e.a("grpc-previous-rpc-attempts", io.grpc.P.f27117b);

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    static final P.e<String> f27757b = P.e.a("grpc-retry-pushback-ms", io.grpc.P.f27117b);

    /* renamed from: c, reason: collision with root package name */
    private static final Status f27758c = Status.f27130c.b("Stream thrown away because RetriableStream committed");

    /* renamed from: d, reason: collision with root package name */
    private static Random f27759d = new Random();

    /* renamed from: e, reason: collision with root package name */
    private final MethodDescriptor<ReqT, ?> f27760e;

    /* renamed from: f, reason: collision with root package name */
    private final Executor f27761f;

    /* renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f27762g;

    /* renamed from: h, reason: collision with root package name */
    private final io.grpc.P f27763h;
    private final Ac.a i;
    private Ac j;
    private final c l;
    private final long m;
    private final long n;

    @Nullable
    private final h o;
    private boolean q;
    private long r;
    private ClientStreamListener s;
    private Future<?> t;
    private long u;
    private final Object k = new Object();
    private volatile e p = new e(new ArrayList(8), Collections.emptyList(), null, false, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(g gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public class b extends AbstractC2513n {

        /* renamed from: a, reason: collision with root package name */
        private final g f27764a;

        /* renamed from: b, reason: collision with root package name */
        long f27765b;

        b(g gVar) {
            this.f27764a = gVar;
        }

        @Override // io.grpc.ea
        public void d(long j) {
            if (wc.this.p.f27773d != null) {
                return;
            }
            synchronized (wc.this.k) {
                if (wc.this.p.f27773d == null && !this.f27764a.f27778b) {
                    this.f27765b += j;
                    if (this.f27765b <= wc.this.r) {
                        return;
                    }
                    if (this.f27765b <= wc.this.m) {
                        long a2 = wc.this.l.a(this.f27765b - wc.this.r);
                        wc.this.r = this.f27765b;
                        if (a2 > wc.this.n) {
                            this.f27764a.f27779c = true;
                        }
                    } else {
                        this.f27764a.f27779c = true;
                    }
                    Runnable a3 = this.f27764a.f27779c ? wc.this.a(this.f27764a) : null;
                    if (a3 != null) {
                        a3.run();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicLong f27767a = new AtomicLong();

        @VisibleForTesting
        long a(long j) {
            return this.f27767a.addAndGet(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final boolean f27768a;

        /* renamed from: b, reason: collision with root package name */
        final long f27769b;

        d(boolean z, long j) {
            this.f27768a = z;
            this.f27769b = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        final boolean f27770a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        final List<a> f27771b;

        /* renamed from: c, reason: collision with root package name */
        final Collection<g> f27772c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        final g f27773d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f27774e;

        e(@Nullable List<a> list, Collection<g> collection, @Nullable g gVar, boolean z, boolean z2) {
            this.f27771b = list;
            Preconditions.a(collection, "drainedSubstreams");
            this.f27772c = collection;
            this.f27773d = gVar;
            this.f27774e = z;
            this.f27770a = z2;
            Preconditions.b(!z2 || list == null, "passThrough should imply buffer is null");
            Preconditions.b((z2 && gVar == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.b(!z2 || (collection.size() == 1 && collection.contains(gVar)) || (collection.size() == 0 && gVar.f27778b), "passThrough should imply winningSubstream is drained");
            Preconditions.b((z && gVar == null) ? false : true, "cancelled should imply committed");
        }

        @CheckReturnValue
        e a() {
            return new e(this.f27771b, this.f27772c, this.f27773d, true, this.f27770a);
        }

        @CheckReturnValue
        e b(g gVar) {
            gVar.f27778b = true;
            if (!this.f27772c.contains(gVar)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f27772c);
            arrayList.remove(gVar);
            return new e(this.f27771b, Collections.unmodifiableCollection(arrayList), this.f27773d, this.f27774e, this.f27770a);
        }

        @CheckReturnValue
        e c(g gVar) {
            Collection unmodifiableCollection;
            List<a> list;
            Preconditions.b(!this.f27770a, "Already passThrough");
            if (gVar.f27778b) {
                unmodifiableCollection = this.f27772c;
            } else if (this.f27772c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(gVar);
            } else {
                ArrayList arrayList = new ArrayList(this.f27772c);
                arrayList.add(gVar);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            boolean z = this.f27773d != null;
            List<a> list2 = this.f27771b;
            if (z) {
                Preconditions.b(this.f27773d == gVar, "Another RPC attempt has already committed");
                list = null;
            } else {
                list = list2;
            }
            return new e(list, collection, this.f27773d, this.f27774e, z);
        }

        @CheckReturnValue
        e a(g gVar) {
            List<a> list;
            Collection emptyList;
            boolean z;
            Preconditions.b(this.f27773d == null, "Already committed");
            List<a> list2 = this.f27771b;
            if (this.f27772c.contains(gVar)) {
                list = null;
                emptyList = Collections.singleton(gVar);
                z = true;
            } else {
                list = list2;
                emptyList = Collections.emptyList();
                z = false;
            }
            return new e(list, emptyList, gVar, this.f27774e, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        X f27777a;

        /* renamed from: b, reason: collision with root package name */
        boolean f27778b;

        /* renamed from: c, reason: collision with root package name */
        boolean f27779c;

        /* renamed from: d, reason: collision with root package name */
        final int f27780d;

        g(int i) {
            this.f27780d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        final int f27781a;

        /* renamed from: b, reason: collision with root package name */
        final int f27782b;

        /* renamed from: c, reason: collision with root package name */
        final int f27783c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f27784d = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(float f2, float f3) {
            this.f27783c = (int) (f3 * 1000.0f);
            this.f27781a = (int) (f2 * 1000.0f);
            int i = this.f27781a;
            this.f27782b = i / 2;
            this.f27784d.set(i);
        }

        @VisibleForTesting
        boolean a() {
            int i;
            int i2;
            do {
                i = this.f27784d.get();
                if (i == 0) {
                    return false;
                }
                i2 = i + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } while (!this.f27784d.compareAndSet(i, Math.max(i2, 0)));
            return i2 > this.f27782b;
        }

        @VisibleForTesting
        void b() {
            int i;
            int i2;
            do {
                i = this.f27784d.get();
                i2 = this.f27781a;
                if (i == i2) {
                    return;
                }
            } while (!this.f27784d.compareAndSet(i, Math.min(this.f27783c + i, i2)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f27781a == hVar.f27781a && this.f27783c == hVar.f27783c;
        }

        public int hashCode() {
            return Objects.a(Integer.valueOf(this.f27781a), Integer.valueOf(this.f27783c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public wc(MethodDescriptor<ReqT, ?> methodDescriptor, io.grpc.P p, c cVar, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, Ac.a aVar, @Nullable h hVar) {
        this.f27760e = methodDescriptor;
        this.l = cVar;
        this.m = j;
        this.n = j2;
        this.f27761f = executor;
        this.f27762g = scheduledExecutorService;
        this.f27763h = p;
        Preconditions.a(aVar, "retryPolicyProvider");
        this.i = aVar;
        this.o = hVar;
    }

    abstract X a(AbstractC2513n.a aVar, io.grpc.P p);

    boolean d() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    @CheckReturnValue
    @Nullable
    abstract Status f();

    @Override // io.grpc.internal.Nc
    public final void flush() {
        e eVar = this.p;
        if (eVar.f27770a) {
            eVar.f27773d.f27777a.flush();
        } else {
            a((a) new C2470oc(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g d(int i) {
        g gVar = new g(i);
        gVar.f27777a = a(new C2450jc(this, new b(gVar)), a(this.f27763h, i));
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        ArrayList<a> arrayList = null;
        int i = 0;
        while (true) {
            synchronized (this.k) {
                e eVar = this.p;
                if (eVar.f27773d != null && eVar.f27773d != gVar) {
                    gVar.f27777a.a(f27758c);
                    return;
                }
                if (i == eVar.f27771b.size()) {
                    this.p = eVar.c(gVar);
                    return;
                }
                if (gVar.f27778b) {
                    return;
                }
                int min = Math.min(i + 128, eVar.f27771b.size());
                if (arrayList == null) {
                    arrayList = new ArrayList(eVar.f27771b.subList(i, min));
                } else {
                    arrayList.clear();
                    arrayList.addAll(eVar.f27771b.subList(i, min));
                }
                for (a aVar : arrayList) {
                    e eVar2 = this.p;
                    g gVar2 = eVar2.f27773d;
                    if (gVar2 == null || gVar2 == gVar) {
                        if (eVar2.f27774e) {
                            Preconditions.b(eVar2.f27773d == gVar, "substream should be CANCELLED_BECAUSE_COMMITTED already");
                            return;
                        }
                        aVar.a(gVar);
                    }
                }
                i = min;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetriableStream.java */
    /* loaded from: classes3.dex */
    public final class f implements ClientStreamListener {

        /* renamed from: a, reason: collision with root package name */
        final g f27775a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(g gVar) {
            this.f27775a = gVar;
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(io.grpc.P p) {
            wc.this.b(this.f27775a);
            if (wc.this.p.f27773d == this.f27775a) {
                wc.this.s.a(p);
                if (wc.this.o != null) {
                    wc.this.o.b();
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, io.grpc.P p) {
            a(status, ClientStreamListener.RpcProgress.PROCESSED, p);
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void a(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.P p) {
            synchronized (wc.this.k) {
                wc.this.p = wc.this.p.b(this.f27775a);
            }
            g gVar = this.f27775a;
            if (!gVar.f27779c) {
                if (wc.this.p.f27773d == null) {
                    if (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && !wc.this.q) {
                        wc.this.q = true;
                        wc.this.f27761f.execute(new xc(this));
                        return;
                    }
                    if (rpcProgress != ClientStreamListener.RpcProgress.DROPPED) {
                        wc.this.q = true;
                        if (wc.this.j == null) {
                            wc wcVar = wc.this;
                            wcVar.j = wcVar.i.get();
                            wc wcVar2 = wc.this;
                            wcVar2.u = wcVar2.j.f27201c;
                        }
                        d a2 = a(wc.this.j, status, p);
                        if (a2.f27768a) {
                            wc wcVar3 = wc.this;
                            wcVar3.t = wcVar3.f27762g.schedule(new zc(this), a2.f27769b, TimeUnit.NANOSECONDS);
                            return;
                        }
                    }
                }
                if (wc.this.d()) {
                    return;
                }
                wc.this.b(this.f27775a);
                if (wc.this.p.f27773d == this.f27775a) {
                    wc.this.s.a(status, p);
                    return;
                }
                return;
            }
            wc.this.b(gVar);
            if (wc.this.p.f27773d == this.f27775a) {
                wc.this.s.a(status, p);
            }
        }

        private d a(Ac ac, Status status, io.grpc.P p) {
            Integer num;
            long j;
            boolean contains = ac.f27204f.contains(status.e());
            String str = (String) p.b(wc.f27757b);
            if (str != null) {
                try {
                    num = Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    num = -1;
                }
            } else {
                num = null;
            }
            boolean z = true;
            boolean z2 = (wc.this.o == null || (!contains && (num == null || num.intValue() >= 0))) ? false : !wc.this.o.a();
            if (ac.f27200b > this.f27775a.f27780d + 1 && !z2) {
                if (num == null) {
                    if (contains) {
                        double d2 = wc.this.u;
                        double nextDouble = wc.f27759d.nextDouble();
                        Double.isNaN(d2);
                        j = (long) (d2 * nextDouble);
                        wc wcVar = wc.this;
                        double d3 = wcVar.u;
                        double d4 = ac.f27203e;
                        Double.isNaN(d3);
                        wcVar.u = Math.min((long) (d3 * d4), ac.f27202d);
                    }
                } else if (num.intValue() >= 0) {
                    j = TimeUnit.MILLISECONDS.toNanos(num.intValue());
                    wc.this.u = ac.f27201c;
                }
                return new d(z, j);
            }
            j = 0;
            z = false;
            return new d(z, j);
        }

        @Override // io.grpc.internal.Oc
        public void a(Oc.a aVar) {
            e eVar = wc.this.p;
            Preconditions.b(eVar.f27773d != null, "Headers should be received prior to messages.");
            if (eVar.f27773d != this.f27775a) {
                return;
            }
            wc.this.s.a(aVar);
        }

        @Override // io.grpc.internal.Oc
        public void a() {
            if (wc.this.p.f27772c.contains(this.f27775a)) {
                wc.this.s.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(g gVar) {
        Runnable a2 = a(gVar);
        if (a2 != null) {
            a2.run();
        }
    }

    @Override // io.grpc.internal.X
    public final void b(int i) {
        a((a) new C2481rc(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable a(g gVar) {
        synchronized (this.k) {
            if (this.p.f27773d != null) {
                return null;
            }
            Collection<g> collection = this.p.f27772c;
            this.p = this.p.a(gVar);
            this.l.a(-this.r);
            return new RunnableC2458lc(this, collection, gVar);
        }
    }

    @VisibleForTesting
    final io.grpc.P a(io.grpc.P p, int i) {
        io.grpc.P p2 = new io.grpc.P();
        p2.a(p);
        if (i > 0) {
            p2.a((P.e<P.e<String>>) f27756a, (P.e<String>) String.valueOf(i));
        }
        return p2;
    }

    @Override // io.grpc.internal.X
    public final void a(ClientStreamListener clientStreamListener) {
        this.s = clientStreamListener;
        Status f2 = f();
        if (f2 != null) {
            a(f2);
            return;
        }
        synchronized (this.k) {
            this.p.f27771b.add(new vc(this));
        }
        c(d(0));
    }

    @Override // io.grpc.internal.X
    public final void c(int i) {
        a((a) new C2485sc(this, i));
    }

    @Override // io.grpc.internal.X
    public final void a(Status status) {
        g gVar = new g(0);
        gVar.f27777a = new Tb();
        Runnable a2 = a(gVar);
        if (a2 != null) {
            Future<?> future = this.t;
            if (future != null) {
                future.cancel(false);
                this.t = null;
            }
            this.s.a(status, new io.grpc.P());
            a2.run();
            return;
        }
        this.p.f27773d.f27777a.a(status);
        synchronized (this.k) {
            this.p = this.p.a();
        }
    }

    private void a(a aVar) {
        Collection<g> collection;
        synchronized (this.k) {
            if (!this.p.f27770a) {
                this.p.f27771b.add(aVar);
            }
            collection = this.p.f27772c;
        }
        Iterator<g> it = collection.iterator();
        while (it.hasNext()) {
            aVar.a(it.next());
        }
    }

    @Override // io.grpc.internal.Nc
    public final void a(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ReqT reqt) {
        e eVar = this.p;
        if (eVar.f27770a) {
            eVar.f27773d.f27777a.a(this.f27760e.a((MethodDescriptor<ReqT, ?>) reqt));
        } else {
            a((a) new C2493uc(this, reqt));
        }
    }

    @Override // io.grpc.internal.Nc
    public final void a(int i) {
        e eVar = this.p;
        if (eVar.f27770a) {
            eVar.f27773d.f27777a.a(i);
        } else {
            a((a) new C2489tc(this, i));
        }
    }

    @Override // io.grpc.internal.Nc
    public final void a(InterfaceC2521p interfaceC2521p) {
        a((a) new C2462mc(this, interfaceC2521p));
    }

    @Override // io.grpc.internal.X
    public final void a(boolean z) {
        a((a) new C2474pc(this, z));
    }

    @Override // io.grpc.internal.X
    public final void a() {
        a((a) new C2478qc(this));
    }

    @Override // io.grpc.internal.X
    public final void a(String str) {
        a((a) new C2454kc(this, str));
    }

    @Override // io.grpc.internal.X
    public final void a(C2528x c2528x) {
        a((a) new C2466nc(this, c2528x));
    }
}
