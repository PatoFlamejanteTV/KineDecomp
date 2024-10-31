package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.qq.e.comm.constants.Constants;
import e.a.d.d;
import io.grpc.AbstractC2407f;
import io.grpc.AbstractC2408g;
import io.grpc.AbstractC2513n;
import io.grpc.C2406e;
import io.grpc.InterfaceC2409h;
import io.grpc.MethodDescriptor;
import io.grpc.P;
import io.grpc.Status;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: CensusStatsModule.java */
/* loaded from: classes3.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27235a = Logger.getLogger(E.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final double f27236b = TimeUnit.MILLISECONDS.toNanos(1);

    /* renamed from: c, reason: collision with root package name */
    private static final b f27237c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    private final e.a.e.j f27238d;

    /* renamed from: e, reason: collision with root package name */
    private final e.a.d.j f27239e;

    /* renamed from: f, reason: collision with root package name */
    private final Supplier<Stopwatch> f27240f;

    /* renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    final P.e<e.a.e.f> f27241g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f27242h;

    /* compiled from: CensusStatsModule.java */
    /* loaded from: classes3.dex */
    private static final class b extends AbstractC2513n {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27251a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27252b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27253c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27254d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27255e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private static final AtomicLongFieldUpdater<b> f27256f;

        /* renamed from: g, reason: collision with root package name */
        volatile long f27257g;

        /* renamed from: h, reason: collision with root package name */
        volatile long f27258h;
        volatile long i;
        volatile long j;
        volatile long k;
        volatile long l;

        static {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater;
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater2;
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater3;
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater4;
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater5;
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater6 = null;
            try {
                AtomicLongFieldUpdater<b> newUpdater = AtomicLongFieldUpdater.newUpdater(b.class, "g");
                atomicLongFieldUpdater2 = AtomicLongFieldUpdater.newUpdater(b.class, "h");
                atomicLongFieldUpdater3 = AtomicLongFieldUpdater.newUpdater(b.class, com.umeng.commonsdk.proguard.e.aq);
                atomicLongFieldUpdater4 = AtomicLongFieldUpdater.newUpdater(b.class, "j");
                atomicLongFieldUpdater5 = AtomicLongFieldUpdater.newUpdater(b.class, "k");
                atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(b.class, Constants.LANDSCAPE);
                atomicLongFieldUpdater6 = newUpdater;
            } catch (Throwable th) {
                E.f27235a.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicLongFieldUpdater = null;
                atomicLongFieldUpdater2 = null;
                atomicLongFieldUpdater3 = null;
                atomicLongFieldUpdater4 = null;
                atomicLongFieldUpdater5 = null;
            }
            f27251a = atomicLongFieldUpdater6;
            f27252b = atomicLongFieldUpdater2;
            f27253c = atomicLongFieldUpdater3;
            f27254d = atomicLongFieldUpdater4;
            f27255e = atomicLongFieldUpdater5;
            f27256f = atomicLongFieldUpdater;
        }

        private b() {
        }

        @Override // io.grpc.ea
        public void a(long j) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27256f;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.l += j;
            }
        }

        @Override // io.grpc.ea
        public void b(long j) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27254d;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.j += j;
            }
        }

        @Override // io.grpc.ea
        public void c(long j) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27255e;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.k += j;
            }
        }

        @Override // io.grpc.ea
        public void d(long j) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27253c;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndAdd(this, j);
            } else {
                this.i += j;
            }
        }

        /* synthetic */ b(D d2) {
            this();
        }

        @Override // io.grpc.ea
        public void a(int i) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27252b;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.f27258h++;
            }
        }

        @Override // io.grpc.ea
        public void b(int i) {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f27251a;
            if (atomicLongFieldUpdater != null) {
                atomicLongFieldUpdater.getAndIncrement(this);
            } else {
                this.f27257g++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CensusStatsModule.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public final class c implements InterfaceC2409h {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f27259a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f27260b;

        c(boolean z, boolean z2) {
            this.f27259a = z;
            this.f27260b = z2;
        }

        @Override // io.grpc.InterfaceC2409h
        public <ReqT, RespT> AbstractC2408g<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, C2406e c2406e, AbstractC2407f abstractC2407f) {
            a a2 = E.this.a(E.this.f27238d.b(), methodDescriptor.a(), this.f27259a, this.f27260b);
            return new G(this, abstractC2407f.a(methodDescriptor, c2406e.a(a2)), a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(Supplier<Stopwatch> supplier, boolean z) {
        this(e.a.e.k.b(), e.a.e.k.a().a(), e.a.d.h.a(), supplier, z);
    }

    @VisibleForTesting
    a a(e.a.e.f fVar, String str, boolean z, boolean z2) {
        return new a(this, fVar, str, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC2409h a(boolean z, boolean z2) {
        return new c(z, z2);
    }

    public E(e.a.e.j jVar, io.opencensus.tags.propagation.a aVar, e.a.d.j jVar2, Supplier<Stopwatch> supplier, boolean z) {
        Preconditions.a(jVar, "tagger");
        this.f27238d = jVar;
        Preconditions.a(jVar2, "statsRecorder");
        this.f27239e = jVar2;
        Preconditions.a(aVar, "tagCtxSerializer");
        Preconditions.a(supplier, "stopwatchSupplier");
        this.f27240f = supplier;
        this.f27242h = z;
        this.f27241g = P.e.a("grpc-tags-bin", new D(this, aVar, jVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CensusStatsModule.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class a extends AbstractC2513n.a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private static final AtomicReferenceFieldUpdater<a, b> f27243a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private static final AtomicIntegerFieldUpdater<a> f27244b;

        /* renamed from: c, reason: collision with root package name */
        private final E f27245c;

        /* renamed from: d, reason: collision with root package name */
        private final String f27246d;

        /* renamed from: e, reason: collision with root package name */
        private final Stopwatch f27247e;

        /* renamed from: f, reason: collision with root package name */
        private volatile b f27248f;

        /* renamed from: g, reason: collision with root package name */
        private volatile int f27249g;

        /* renamed from: h, reason: collision with root package name */
        private final e.a.e.f f27250h;
        private final e.a.e.f i;
        private final boolean j;

        static {
            AtomicIntegerFieldUpdater<a> atomicIntegerFieldUpdater;
            AtomicReferenceFieldUpdater<a, b> atomicReferenceFieldUpdater = null;
            try {
                AtomicReferenceFieldUpdater<a, b> newUpdater = AtomicReferenceFieldUpdater.newUpdater(a.class, b.class, "f");
                atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(a.class, "g");
                atomicReferenceFieldUpdater = newUpdater;
            } catch (Throwable th) {
                E.f27235a.log(Level.SEVERE, "Creating atomic field updaters failed", th);
                atomicIntegerFieldUpdater = null;
            }
            f27243a = atomicReferenceFieldUpdater;
            f27244b = atomicIntegerFieldUpdater;
        }

        a(E e2, e.a.e.f fVar, String str, boolean z, boolean z2) {
            this.f27245c = e2;
            Preconditions.a(str, "fullMethodName");
            this.f27246d = str;
            Preconditions.a(fVar);
            this.f27250h = fVar;
            e.a.e.g a2 = e2.f27238d.a(fVar);
            a2.a(e.a.b.a.a.a.f26736b, e.a.e.i.a(str));
            this.i = a2.a();
            this.f27247e = ((Stopwatch) e2.f27240f.get()).d();
            this.j = z2;
            if (z) {
                e.a.d.e a3 = e2.f27239e.a();
                a3.a(e.a.b.a.a.a.j, 1L);
                a3.a(this.i);
            }
        }

        @Override // io.grpc.AbstractC2513n.a
        public AbstractC2513n a(C2406e c2406e, io.grpc.P p) {
            b bVar = new b(null);
            AtomicReferenceFieldUpdater<a, b> atomicReferenceFieldUpdater = f27243a;
            if (atomicReferenceFieldUpdater != null) {
                Preconditions.b(atomicReferenceFieldUpdater.compareAndSet(this, null, bVar), "Are you creating multiple streams per call? This class doesn't yet support this case");
            } else {
                Preconditions.b(this.f27248f == null, "Are you creating multiple streams per call? This class doesn't yet support this case");
                this.f27248f = bVar;
            }
            if (this.f27245c.f27242h) {
                p.a(this.f27245c.f27241g);
                if (!this.f27245c.f27238d.a().equals(this.f27250h)) {
                    p.a((P.e<P.e<e.a.e.f>>) this.f27245c.f27241g, (P.e<e.a.e.f>) this.f27250h);
                }
            }
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Status status) {
            AtomicIntegerFieldUpdater<a> atomicIntegerFieldUpdater = f27244b;
            if (atomicIntegerFieldUpdater != null) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
                    return;
                }
            } else if (this.f27249g != 0) {
                return;
            } else {
                this.f27249g = 1;
            }
            if (this.j) {
                this.f27247e.e();
                long a2 = this.f27247e.a(TimeUnit.NANOSECONDS);
                b bVar = this.f27248f;
                if (bVar == null) {
                    bVar = E.f27237c;
                }
                e.a.d.e a3 = this.f27245c.f27239e.a();
                a3.a(e.a.b.a.a.a.k, 1L);
                d.a aVar = e.a.b.a.a.a.f26740f;
                double d2 = a2;
                double d3 = E.f27236b;
                Double.isNaN(d2);
                a3.a(aVar, d2 / d3);
                a3.a(e.a.b.a.a.a.l, bVar.f27257g);
                a3.a(e.a.b.a.a.a.m, bVar.f27258h);
                a3.a(e.a.b.a.a.a.f26738d, bVar.i);
                a3.a(e.a.b.a.a.a.f26739e, bVar.j);
                a3.a(e.a.b.a.a.a.f26742h, bVar.k);
                a3.a(e.a.b.a.a.a.i, bVar.l);
                if (!status.g()) {
                    a3.a(e.a.b.a.a.a.f26737c, 1L);
                }
                e.a.e.g a4 = this.f27245c.f27238d.a(this.i);
                a4.a(e.a.b.a.a.a.f26735a, e.a.e.i.a(status.e().toString()));
                a3.a(a4.a());
            }
        }
    }
}
