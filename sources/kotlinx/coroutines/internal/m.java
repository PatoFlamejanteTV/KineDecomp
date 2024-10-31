package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public final class m<E> {
    private volatile Object _next;
    public volatile /* synthetic */ long _state$internal;

    /* renamed from: e */
    private final int f28649e;

    /* renamed from: f */
    private final AtomicReferenceArray<Object> f28650f;

    /* renamed from: g */
    private final int f28651g;

    /* renamed from: h */
    private final boolean f28652h;

    /* renamed from: d */
    public static final a f28648d = new a(null);

    /* renamed from: c */
    public static final q f28647c = new q("REMOVE_FROZEN");

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f28645a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next");

    /* renamed from: b */
    public static final /* synthetic */ AtomicLongFieldUpdater f28646b = AtomicLongFieldUpdater.newUpdater(m.class, "_state$internal");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long a(long j, int i) {
            return a(j, 1073741823L) | (i << 0);
        }

        public final long a(long j, long j2) {
            return j & (j2 ^ (-1));
        }

        public final long b(long j, int i) {
            return a(j, 1152921503533105152L) | (i << 30);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a */
        public final int f28653a;

        public b(int i) {
            this.f28653a = i;
        }
    }

    public m(int i, boolean z) {
        this.f28651g = i;
        this.f28652h = z;
        int i2 = this.f28651g;
        this.f28649e = i2 - 1;
        this._next = null;
        this._state$internal = 0L;
        this.f28650f = new AtomicReferenceArray<>(i2);
        if (this.f28649e <= 1073741823) {
            if (!((this.f28651g & this.f28649e) == 0)) {
                throw new IllegalStateException("Check failed.");
            }
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final long f() {
        long j;
        long j2;
        do {
            j = this._state$internal;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f28646b.compareAndSet(this, j, j2));
        return j2;
    }

    public final m<E> d() {
        return b(f());
    }

    public final Object e() {
        Object obj;
        while (true) {
            long j = this._state$internal;
            if ((1152921504606846976L & j) != 0) {
                return f28647c;
            }
            a aVar = f28648d;
            int i = (int) ((1073741823 & j) >> 0);
            if ((this.f28649e & ((int) ((1152921503533105152L & j) >> 30))) == (this.f28649e & i)) {
                return null;
            }
            obj = this.f28650f.get(this.f28649e & i);
            if (obj == null) {
                if (this.f28652h) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i2 = (i + 1) & 1073741823;
                if (f28646b.compareAndSet(this, j, f28648d.a(j, i2))) {
                    this.f28650f.set(this.f28649e & i, null);
                    break;
                }
                if (this.f28652h) {
                    m<E> mVar = this;
                    do {
                        mVar = mVar.a(i, i2);
                    } while (mVar != null);
                }
            }
        }
        return obj;
    }

    public final int b() {
        a aVar = f28648d;
        long j = this._state$internal;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean c() {
        a aVar = f28648d;
        long j = this._state$internal;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    private final m<E> a(int i, E e2) {
        Object obj = this.f28650f.get(this.f28649e & i);
        if (!(obj instanceof b) || ((b) obj).f28653a != i) {
            return null;
        }
        this.f28650f.set(i & this.f28649e, e2);
        return this;
    }

    private final m<E> b(long j) {
        while (true) {
            m<E> mVar = (m) this._next;
            if (mVar != null) {
                return mVar;
            }
            f28645a.compareAndSet(this, null, a(j));
        }
    }

    private final m<E> a(long j) {
        m<E> mVar = new m<>(this.f28651g * 2, this.f28652h);
        a aVar = f28648d;
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f28649e;
            if ((i & i3) != (i2 & i3)) {
                AtomicReferenceArray<Object> atomicReferenceArray = mVar.f28650f;
                int i4 = mVar.f28649e & i;
                Object obj = this.f28650f.get(i3 & i);
                if (obj == null) {
                    obj = new b(i);
                }
                atomicReferenceArray.set(i4, obj);
                i++;
            } else {
                mVar._state$internal = f28648d.a(j, 1152921504606846976L);
                return mVar;
            }
        }
    }

    public final boolean a() {
        long j;
        do {
            j = this._state$internal;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f28646b.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:            return 1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(E r13) {
        /*
            r12 = this;
            java.lang.String r0 = "element"
            kotlin.jvm.internal.h.b(r13, r0)
        L5:
            long r3 = r12._state$internal
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r3
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L17
            kotlinx.coroutines.internal.m$a r13 = kotlinx.coroutines.internal.m.f28648d
            int r13 = r13.a(r3)
            return r13
        L17:
            kotlinx.coroutines.internal.m$a r0 = kotlinx.coroutines.internal.m.f28648d
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r3
            r9 = 0
            long r0 = r0 >> r9
            int r1 = (int) r0
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r0 = 30
            long r5 = r5 >> r0
            int r0 = (int) r5
            int r10 = r12.f28649e
            int r2 = r0 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L35
            return r6
        L35:
            boolean r2 = r12.f28652h
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> r2 = r12.f28650f
            r11 = r0 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.f28651g
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r0 = r0 - r1
            r0 = r0 & r5
            int r1 = r2 >> 1
            if (r0 <= r1) goto L5
        L52:
            return r6
        L53:
            int r1 = r0 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.m.f28646b
            kotlinx.coroutines.internal.m$a r5 = kotlinx.coroutines.internal.m.f28648d
            long r5 = r5.b(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L5
            java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> r1 = r12.f28650f
            r2 = r0 & r10
            r1.set(r2, r13)
            r1 = r12
        L6e:
            long r2 = r1._state$internal
            r4 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r2 = r2 & r4
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 != 0) goto L78
            goto L83
        L78:
            kotlinx.coroutines.internal.m r1 = r1.d()
            kotlinx.coroutines.internal.m r1 = r1.a(r0, r13)
            if (r1 == 0) goto L83
            goto L6e
        L83:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.m.a(java.lang.Object):int");
    }

    public final m<E> a(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state$internal;
            a aVar = f28648d;
            i3 = (int) ((1073741823 & j) >> 0);
            if (!(i3 == i)) {
                throw new IllegalStateException("This queue can have only one consumer");
            }
            if ((1152921504606846976L & j) != 0) {
                return d();
            }
        } while (!f28646b.compareAndSet(this, j, f28648d.a(j, i2)));
        this.f28650f.set(this.f28649e & i3, null);
        return null;
    }
}
