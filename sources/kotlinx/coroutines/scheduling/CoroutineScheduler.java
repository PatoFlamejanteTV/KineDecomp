package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.ActivityChooserView;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.C2553w;
import kotlinx.coroutines.ia;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.r;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f28678a;

    /* renamed from: b, reason: collision with root package name */
    static final AtomicLongFieldUpdater f28679b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f28680c;

    /* renamed from: g, reason: collision with root package name */
    private static final int f28684g;

    /* renamed from: h, reason: collision with root package name */
    private static final q f28685h;
    private volatile int _isTerminated;
    volatile long controlState;
    private final d j;
    private final Semaphore k;
    private final b[] l;
    private final Random m;
    private final int n;
    private final int o;
    private final long p;
    private volatile long parkedWorkersStack;
    private final String q;
    public static final a i = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final int f28681d = r.a("kotlinx.coroutines.scheduler.spins", 1000, 1, 0, 8, (Object) null);

    /* renamed from: e, reason: collision with root package name */
    private static final int f28682e = f28681d + r.a("kotlinx.coroutines.scheduler.yields", 0, 0, 0, 8, (Object) null);

    /* renamed from: f, reason: collision with root package name */
    private static final int f28683f = (int) TimeUnit.SECONDS.toNanos(1);

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public final class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f28686a = AtomicIntegerFieldUpdater.newUpdater(b.class, "terminationState");

        /* renamed from: b, reason: collision with root package name */
        private final m f28687b;

        /* renamed from: c, reason: collision with root package name */
        private long f28688c;

        /* renamed from: d, reason: collision with root package name */
        private long f28689d;

        /* renamed from: e, reason: collision with root package name */
        private int f28690e;

        /* renamed from: f, reason: collision with root package name */
        private int f28691f;

        /* renamed from: g, reason: collision with root package name */
        private int f28692g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int spins;
        private volatile WorkerState state;
        private volatile int terminationState;

        private b() {
            setDaemon(true);
            this.f28687b = new m();
            this.state = WorkerState.RETIRING;
            this.terminationState = 0;
            this.nextParkedWorker = CoroutineScheduler.f28685h;
            this.f28690e = CoroutineScheduler.f28684g;
            this.f28691f = CoroutineScheduler.this.m.nextInt();
        }

        private final boolean l() {
            h a2 = CoroutineScheduler.this.j.a(TaskMode.PROBABLY_BLOCKING);
            if (a2 == null) {
                return true;
            }
            this.f28687b.a(a2, CoroutineScheduler.this.j);
            return false;
        }

        private final void m() {
            a(WorkerState.PARKING);
            if (l()) {
                this.terminationState = 0;
                if (this.f28688c == 0) {
                    this.f28688c = System.nanoTime() + CoroutineScheduler.this.p;
                }
                if (a(CoroutineScheduler.this.p) && System.nanoTime() - this.f28688c >= 0) {
                    this.f28688c = 0L;
                    q();
                }
            }
        }

        private final void n() {
            int b2;
            int i = this.spins;
            if (i > CoroutineScheduler.f28682e) {
                if (this.f28690e < CoroutineScheduler.f28683f) {
                    b2 = kotlin.c.h.b((this.f28690e * 3) >>> 1, CoroutineScheduler.f28683f);
                    this.f28690e = b2;
                }
                a(WorkerState.PARKING);
                a(this.f28690e);
                return;
            }
            this.spins = i + 1;
            if (i >= CoroutineScheduler.f28681d) {
                Thread.yield();
            }
        }

        private final h o() {
            h c2;
            h a2;
            boolean z = a(CoroutineScheduler.this.n * 2) == 0;
            if (z && (a2 = CoroutineScheduler.this.j.a(TaskMode.NON_BLOCKING)) != null) {
                return a2;
            }
            h b2 = this.f28687b.b();
            return b2 != null ? b2 : (z || (c2 = CoroutineScheduler.this.j.c()) == null) ? p() : c2;
        }

        private final h p() {
            int v = CoroutineScheduler.this.v();
            if (v < 2) {
                return null;
            }
            int i = this.f28692g;
            if (i == 0) {
                i = a(v);
            }
            int i2 = i + 1;
            if (i2 > v) {
                i2 = 1;
            }
            this.f28692g = i2;
            b bVar = CoroutineScheduler.this.l[i2];
            if (bVar == null || bVar == this || !this.f28687b.a(bVar.f28687b, CoroutineScheduler.this.j)) {
                return null;
            }
            return this.f28687b.b();
        }

        private final void q() {
            synchronized (CoroutineScheduler.this.l) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.v() <= CoroutineScheduler.this.n) {
                    return;
                }
                if (l()) {
                    if (f28686a.compareAndSet(this, 0, 1)) {
                        int i = this.indexInArray;
                        b(0);
                        CoroutineScheduler.this.a(this, i, 0);
                        int andDecrement = (int) (CoroutineScheduler.f28679b.getAndDecrement(CoroutineScheduler.this) & 2097151);
                        if (andDecrement != i) {
                            b bVar = CoroutineScheduler.this.l[andDecrement];
                            if (bVar != null) {
                                CoroutineScheduler.this.l[i] = bVar;
                                bVar.b(i);
                                CoroutineScheduler.this.a(bVar, andDecrement, i);
                            } else {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                        }
                        CoroutineScheduler.this.l[andDecrement] = null;
                        kotlin.k kVar = kotlin.k.f28545a;
                        this.state = WorkerState.TERMINATED;
                    }
                }
            }
        }

        public final void a(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final void b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.q);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final int c() {
            return this.indexInArray;
        }

        public final m d() {
            return this.f28687b;
        }

        public final Object e() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler f() {
            return CoroutineScheduler.this;
        }

        public final void g() {
            this.f28690e = CoroutineScheduler.f28684g;
            this.spins = 0;
        }

        @Override // java.lang.Thread
        public final WorkerState getState() {
            return this.state;
        }

        public final boolean h() {
            return this.state == WorkerState.BLOCKING;
        }

        public final boolean i() {
            return this.state == WorkerState.PARKING;
        }

        public final boolean j() {
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            if (!CoroutineScheduler.this.k.tryAcquire()) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean k() {
            int i = this.terminationState;
            if (i == -1) {
                return false;
            }
            if (i == 0) {
                return f28686a.compareAndSet(this, 0, -1);
            }
            if (i == 1) {
                return false;
            }
            throw new IllegalStateException(("Invalid terminationState = " + i).toString());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                h b2 = b();
                if (b2 == null) {
                    if (this.state == WorkerState.CPU_ACQUIRED) {
                        n();
                    } else {
                        m();
                    }
                    z = true;
                } else {
                    TaskMode b3 = b2.b();
                    if (z) {
                        b(b3);
                        z = false;
                    }
                    a(b3, b2.f28710a);
                    CoroutineScheduler.this.a(b2);
                    a(b3);
                }
            }
            a(WorkerState.TERMINATED);
        }

        public final boolean a(WorkerState workerState) {
            kotlin.jvm.internal.h.b(workerState, "newState");
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.this.k.release();
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        private final void b(TaskMode taskMode) {
            this.f28688c = 0L;
            this.f28692g = 0;
            if (this.state == WorkerState.PARKING) {
                boolean z = taskMode == TaskMode.PROBABLY_BLOCKING;
                if (kotlin.l.f28546a && !z) {
                    throw new AssertionError("Assertion failed");
                }
                this.state = WorkerState.BLOCKING;
                this.f28690e = CoroutineScheduler.f28684g;
            }
            this.spins = 0;
        }

        private final void a(TaskMode taskMode, long j) {
            if (taskMode == TaskMode.NON_BLOCKING) {
                if (CoroutineScheduler.this.k.availablePermits() == 0) {
                    return;
                }
                long a2 = k.f28719g.a();
                long j2 = a2 - j;
                long j3 = k.f28713a;
                if (j2 < j3 || a2 - this.f28689d < j3 * 5) {
                    return;
                }
                this.f28689d = a2;
                CoroutineScheduler.this.x();
                return;
            }
            CoroutineScheduler.f28679b.addAndGet(CoroutineScheduler.this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
            if (a(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.x();
            }
        }

        public b(CoroutineScheduler coroutineScheduler, int i) {
            this();
            b(i);
        }

        public final h b() {
            if (j()) {
                return o();
            }
            h b2 = this.f28687b.b();
            return b2 != null ? b2 : CoroutineScheduler.this.j.a(TaskMode.PROBABLY_BLOCKING);
        }

        private final void a(TaskMode taskMode) {
            if (taskMode != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.f28679b.addAndGet(CoroutineScheduler.this, -2097152L);
                WorkerState workerState = this.state;
                if (workerState != WorkerState.TERMINATED) {
                    boolean z = workerState == WorkerState.BLOCKING;
                    if (!kotlin.l.f28546a || z) {
                        this.state = WorkerState.RETIRING;
                        return;
                    }
                    throw new AssertionError("Expected BLOCKING state, but has " + workerState);
                }
            }
        }

        public final int a(int i) {
            int i2 = this.f28691f;
            this.f28691f = i2 ^ (i2 << 13);
            int i3 = this.f28691f;
            this.f28691f = i3 ^ (i3 >> 17);
            int i4 = this.f28691f;
            this.f28691f = i4 ^ (i4 << 5);
            int i5 = i - 1;
            if ((i5 & i) == 0) {
                return this.f28691f & i5;
            }
            return (this.f28691f & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i;
        }

        private final boolean a(long j) {
            CoroutineScheduler.this.b(this);
            if (!l()) {
                return false;
            }
            LockSupport.parkNanos(j);
            return true;
        }
    }

    static {
        long a2;
        long b2;
        a2 = kotlin.c.h.a(k.f28713a / 4, 10L);
        b2 = kotlin.c.h.b(a2, f28683f);
        f28684g = (int) b2;
        f28685h = new q("NOT_IN_STACK");
        f28678a = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        f28679b = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        f28680c = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    }

    public CoroutineScheduler(int i2, int i3, long j, String str) {
        kotlin.jvm.internal.h.b(str, "schedulerName");
        this.n = i2;
        this.o = i3;
        this.p = j;
        this.q = str;
        if (this.n >= 1) {
            if (this.o >= this.n) {
                if (!(this.o <= 2097150)) {
                    throw new IllegalArgumentException(("Max pool size " + this.o + " should not exceed maximal supported number of threads 2097150").toString());
                }
                if (this.p > 0) {
                    this.j = new d();
                    this.k = new Semaphore(this.n, false);
                    this.parkedWorkersStack = 0L;
                    this.l = new b[this.o + 1];
                    this.controlState = 0L;
                    this.m = new Random();
                    this._isTerminated = 0;
                    return;
                }
                throw new IllegalArgumentException(("Idle worker keep alive time " + this.p + " must be positive").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.o + " should be greater than or equals to core pool size " + this.n).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.n + " should be at least 1").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTerminated() {
        return this._isTerminated != 0;
    }

    private final int u() {
        synchronized (this.l) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i2 = (int) (j & 2097151);
            int i3 = i2 - ((int) ((j & 4398044413952L) >> 21));
            if (i3 >= this.n) {
                return 0;
            }
            if (i2 < this.o && this.k.availablePermits() != 0) {
                int i4 = ((int) (this.controlState & 2097151)) + 1;
                if (i4 > 0 && this.l[i4] == null) {
                    b bVar = new b(this, i4);
                    bVar.start();
                    if (i4 == ((int) (2097151 & f28679b.incrementAndGet(this)))) {
                        this.l[i4] = bVar;
                        return i3 + 1;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v() {
        return (int) (this.controlState & 2097151);
    }

    private final b w() {
        while (true) {
            long j = this.parkedWorkersStack;
            b bVar = this.l[(int) (2097151 & j)];
            if (bVar == null) {
                return null;
            }
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
            int a2 = a(bVar);
            if (a2 >= 0 && f28678a.compareAndSet(this, j, a2 | j2)) {
                bVar.a(f28685h);
                return bVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        if (this.k.availablePermits() == 0) {
            y();
            return;
        }
        if (y()) {
            return;
        }
        long j = this.controlState;
        if (((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)) < this.n) {
            int u = u();
            if (u == 1 && this.n > 1) {
                u();
            }
            if (u > 0) {
                return;
            }
        }
        y();
    }

    private final boolean y() {
        while (true) {
            b w = w();
            if (w == null) {
                return false;
            }
            w.g();
            boolean i2 = w.i();
            LockSupport.unpark(w);
            if (i2 && w.k()) {
                return true;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        kotlin.jvm.internal.h.b(runnable, "command");
        a(this, runnable, null, false, 6, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (b bVar : this.l) {
            if (bVar != null) {
                int c2 = bVar.d().c();
                int i7 = kotlinx.coroutines.scheduling.a.f28694a[bVar.getState().ordinal()];
                if (i7 == 1) {
                    i4++;
                } else if (i7 == 2) {
                    i3++;
                    arrayList.add(String.valueOf(c2) + "b");
                } else if (i7 == 3) {
                    i2++;
                    arrayList.add(String.valueOf(c2) + "c");
                } else if (i7 == 4) {
                    i5++;
                    if (c2 > 0) {
                        arrayList.add(String.valueOf(c2) + "r");
                    }
                } else if (i7 == 5) {
                    i6++;
                }
            }
        }
        long j = this.controlState;
        return this.q + '@' + C2553w.b(this) + "[Pool Size {core = " + this.n + ", max = " + this.o + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", retired = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global queue size = " + this.j.b() + ", Control State Workers {created = " + ((int) (2097151 & j)) + ", blocking = " + ((int) ((j & 4398044413952L) >> 21)) + "}]";
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:            if (r10 != null) goto L39;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(long r10) {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f28680c
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.b
            r4 = 0
            if (r3 != 0) goto L15
            r0 = r4
        L15:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.b) r0
            kotlinx.coroutines.scheduling.CoroutineScheduler$b[] r3 = r9.l
            monitor-enter(r3)
            long r5 = r9.controlState     // Catch: java.lang.Throwable -> Lb9
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r6 = (int) r5
            monitor-exit(r3)
            if (r2 > r6) goto L75
            r3 = 1
        L25:
            kotlinx.coroutines.scheduling.CoroutineScheduler$b[] r5 = r9.l
            r5 = r5[r3]
            if (r5 == 0) goto L71
            if (r5 == r0) goto L6c
        L2d:
            boolean r7 = r5.isAlive()
            if (r7 == 0) goto L3a
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r5.join(r10)
            goto L2d
        L3a:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = r5.getState()
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r7 != r8) goto L44
            r8 = 1
            goto L45
        L44:
            r8 = 0
        L45:
            if (r8 == 0) goto L51
            kotlinx.coroutines.scheduling.m r5 = r5.d()
            kotlinx.coroutines.scheduling.d r7 = r9.j
            r5.a(r7)
            goto L6c
        L51:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Expected TERMINATED state, but found "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        L6c:
            if (r3 == r6) goto L75
            int r3 = r3 + 1
            goto L25
        L71:
            kotlin.jvm.internal.h.a()
            throw r4
        L75:
            kotlinx.coroutines.scheduling.d r10 = r9.j
            r10.a()
        L7a:
            if (r0 == 0) goto L83
            kotlinx.coroutines.scheduling.h r10 = r0.b()
            if (r10 == 0) goto L83
            goto L8b
        L83:
            kotlinx.coroutines.scheduling.d r10 = r9.j
            java.lang.Object r10 = r10.c()
            kotlinx.coroutines.scheduling.h r10 = (kotlinx.coroutines.scheduling.h) r10
        L8b:
            if (r10 == 0) goto L91
            r9.a(r10)
            goto L7a
        L91:
            if (r0 == 0) goto L98
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r10 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.a(r10)
        L98:
            java.util.concurrent.Semaphore r10 = r9.k
            int r10 = r10.availablePermits()
            int r11 = r9.n
            if (r10 != r11) goto La3
            r1 = 1
        La3:
            boolean r10 = kotlin.l.f28546a
            if (r10 == 0) goto Lb2
            if (r1 == 0) goto Laa
            goto Lb2
        Laa:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            java.lang.String r11 = "Assertion failed"
            r10.<init>(r11)
            throw r10
        Lb2:
            r10 = 0
            r9.parkedWorkersStack = r10
            r9.controlState = r10
            return
        Lb9:
            r10 = move-exception
            monitor-exit(r3)
            goto Lbd
        Lbc:
            throw r10
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.g(long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(b bVar) {
        long j;
        long j2;
        int c2;
        if (bVar.e() != f28685h) {
            return;
        }
        do {
            j = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j);
            j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
            c2 = bVar.c();
            boolean z = c2 != 0;
            if (kotlin.l.f28546a && !z) {
                throw new AssertionError("Assertion failed");
            }
            bVar.a(this.l[i2]);
        } while (!f28678a.compareAndSet(this, j, c2 | j2));
    }

    private final int a(b bVar) {
        Object e2 = bVar.e();
        while (e2 != f28685h) {
            if (e2 == null) {
                return 0;
            }
            b bVar2 = (b) e2;
            int c2 = bVar2.c();
            if (c2 != 0) {
                return c2;
            }
            e2 = bVar2.e();
        }
        return -1;
    }

    public static /* synthetic */ void a(CoroutineScheduler coroutineScheduler, Runnable runnable, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iVar = g.f28709b;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.a(runnable, iVar, z);
    }

    public final void a(Runnable runnable, i iVar, boolean z) {
        kotlin.jvm.internal.h.b(runnable, "block");
        kotlin.jvm.internal.h.b(iVar, "taskContext");
        ia.a().d();
        h a2 = a(runnable, iVar);
        int a3 = a(a2, z);
        if (a3 != -1) {
            if (a3 != 1) {
                x();
            } else {
                if (this.j.a((d) a2)) {
                    x();
                    return;
                }
                throw new RejectedExecutionException(this.q + " was terminated");
            }
        }
    }

    public final h a(Runnable runnable, i iVar) {
        kotlin.jvm.internal.h.b(runnable, "block");
        kotlin.jvm.internal.h.b(iVar, "taskContext");
        long a2 = k.f28719g.a();
        if (runnable instanceof h) {
            h hVar = (h) runnable;
            hVar.f28710a = a2;
            hVar.f28711b = iVar;
            return hVar;
        }
        return new j(runnable, a2, iVar);
    }

    private final int a(h hVar, boolean z) {
        boolean a2;
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof b)) {
            currentThread = null;
        }
        b bVar = (b) currentThread;
        if (bVar == null || bVar.f() != this || bVar.getState() == WorkerState.TERMINATED) {
            return 1;
        }
        int i2 = -1;
        if (hVar.b() == TaskMode.NON_BLOCKING) {
            if (bVar.h()) {
                i2 = 0;
            } else if (!bVar.j()) {
                return 1;
            }
        }
        if (z) {
            a2 = bVar.d().b(hVar, this.j);
        } else {
            a2 = bVar.d().a(hVar, this.j);
        }
        if (!a2 || bVar.d().a() > k.f28714b) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(h hVar) {
        try {
            try {
                hVar.run();
            } catch (Throwable th) {
                Thread currentThread = Thread.currentThread();
                kotlin.jvm.internal.h.a((Object) currentThread, "thread");
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
            }
        } finally {
            ia.a().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar, int i2, int i3) {
        int i4;
        while (true) {
            long j = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & (-2097152);
            if (i5 == i2) {
                i4 = i3 == 0 ? a(bVar) : i3;
            } else {
                i4 = i5;
            }
            if (i4 >= 0 && f28678a.compareAndSet(this, j, j2 | i4)) {
                return;
            }
        }
    }
}
