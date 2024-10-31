package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.C2406e;
import io.grpc.Context;
import io.grpc.J;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.Nb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.ma, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2460ma implements Nb {

    /* renamed from: c, reason: collision with root package name */
    private final Executor f27673c;

    /* renamed from: d, reason: collision with root package name */
    private final M f27674d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f27675e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f27676f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f27677g;

    /* renamed from: h, reason: collision with root package name */
    private Nb.a f27678h;
    private Status j;

    @Nullable
    private J.f k;
    private long l;

    /* renamed from: a, reason: collision with root package name */
    private final C2492ub f27671a = C2492ub.a(C2460ma.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final Object f27672b = new Object();

    @Nonnull
    private Collection<a> i = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.ma$a */
    /* loaded from: classes3.dex */
    public class a extends Ea {

        /* renamed from: g, reason: collision with root package name */
        private final J.d f27679g;

        /* renamed from: h, reason: collision with root package name */
        private final Context f27680h;

        /* synthetic */ a(C2460ma c2460ma, J.d dVar, RunnableC2440ha runnableC2440ha) {
            this(dVar);
        }

        private a(J.d dVar) {
            this.f27680h = Context.s();
            this.f27679g = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Y y) {
            Context b2 = this.f27680h.b();
            try {
                X a2 = y.a(this.f27679g.c(), this.f27679g.b(), this.f27679g.a());
                this.f27680h.b(b2);
                a(a2);
            } catch (Throwable th) {
                this.f27680h.b(b2);
                throw th;
            }
        }

        @Override // io.grpc.internal.Ea, io.grpc.internal.X
        public void a(Status status) {
            super.a(status);
            synchronized (C2460ma.this.f27672b) {
                if (C2460ma.this.f27677g != null) {
                    boolean remove = C2460ma.this.i.remove(this);
                    if (!C2460ma.this.c() && remove) {
                        C2460ma.this.f27674d.a(C2460ma.this.f27676f);
                        if (C2460ma.this.j != null) {
                            C2460ma.this.f27674d.a(C2460ma.this.f27677g);
                            C2460ma.this.f27677g = null;
                        }
                    }
                }
            }
            C2460ma.this.f27674d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2460ma(Executor executor, M m) {
        this.f27673c = executor;
        this.f27674d = m;
    }

    @Override // io.grpc.internal.Nb
    public final void b(Status status) {
        synchronized (this.f27672b) {
            if (this.j != null) {
                return;
            }
            this.j = status;
            this.f27674d.a(new RunnableC2452ka(this, status));
            if (!c() && this.f27677g != null) {
                this.f27674d.a(this.f27677g);
                this.f27677g = null;
            }
            this.f27674d.a();
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.f27672b) {
            z = !this.i.isEmpty();
        }
        return z;
    }

    @Override // io.grpc.internal.Nb
    public final Runnable a(Nb.a aVar) {
        this.f27678h = aVar;
        this.f27675e = new RunnableC2440ha(this, aVar);
        this.f27676f = new RunnableC2444ia(this, aVar);
        this.f27677g = new RunnableC2448ja(this, aVar);
        return null;
    }

    @Override // io.grpc.internal.Y
    public final X a(MethodDescriptor<?, ?> methodDescriptor, io.grpc.P p, C2406e c2406e) {
        X ja;
        try {
            Yb yb = new Yb(methodDescriptor, p, c2406e);
            synchronized (this.f27672b) {
                if (this.j == null) {
                    if (this.k == null) {
                        ja = a(yb);
                    } else {
                        J.f fVar = this.k;
                        long j = this.l;
                        while (true) {
                            Y a2 = GrpcUtil.a(fVar.a(yb), c2406e.i());
                            if (a2 != null) {
                                return a2.a(yb.c(), yb.b(), yb.a());
                            }
                            synchronized (this.f27672b) {
                                if (this.j != null) {
                                    ja = new Ja(this.j);
                                } else if (j == this.l) {
                                    ja = a(yb);
                                } else {
                                    fVar = this.k;
                                    j = this.l;
                                }
                            }
                            break;
                        }
                    }
                } else {
                    ja = new Ja(this.j);
                }
            }
            return ja;
        } finally {
            this.f27674d.a();
        }
    }

    @VisibleForTesting
    final int b() {
        int size;
        synchronized (this.f27672b) {
            size = this.i.size();
        }
        return size;
    }

    private a a(J.d dVar) {
        a aVar = new a(this, dVar, null);
        this.i.add(aVar);
        if (b() == 1) {
            this.f27674d.a(this.f27675e);
        }
        return aVar;
    }

    @Override // io.grpc.internal.Nb
    public final void a(Status status) {
        Collection<a> collection;
        Runnable runnable;
        b(status);
        synchronized (this.f27672b) {
            collection = this.i;
            runnable = this.f27677g;
            this.f27677g = null;
            if (!this.i.isEmpty()) {
                this.i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            Iterator<a> it = collection.iterator();
            while (it.hasNext()) {
                it.next().a(status);
            }
            M m = this.f27674d;
            m.a(runnable);
            m.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@Nullable J.f fVar) {
        synchronized (this.f27672b) {
            this.k = fVar;
            this.l++;
            if (fVar != null && c()) {
                ArrayList arrayList = new ArrayList(this.i);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    J.c a2 = fVar.a(aVar.f27679g);
                    C2406e a3 = aVar.f27679g.a();
                    Y a4 = GrpcUtil.a(a2, a3.i());
                    if (a4 != null) {
                        Executor executor = this.f27673c;
                        if (a3.e() != null) {
                            executor = a3.e();
                        }
                        executor.execute(new RunnableC2456la(this, aVar, a4));
                        arrayList2.add(aVar);
                    }
                }
                synchronized (this.f27672b) {
                    if (c()) {
                        this.i.removeAll(arrayList2);
                        if (this.i.isEmpty()) {
                            this.i = new LinkedHashSet();
                        }
                        if (!c()) {
                            this.f27674d.a(this.f27676f);
                            if (this.j != null && this.f27677g != null) {
                                this.f27674d.a(this.f27677g);
                                this.f27677g = null;
                            }
                        }
                        this.f27674d.a();
                    }
                }
            }
        }
    }

    @Override // io.grpc.internal.Sc
    public C2492ub a() {
        return this.f27671a;
    }
}
