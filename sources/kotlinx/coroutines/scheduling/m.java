package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: WorkQueue.kt */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f28720a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: b, reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f28721b = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: c, reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f28722c = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReferenceArray<h> f28723d = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    volatile int producerIndex = 0;
    volatile int consumerIndex = 0;

    public final h b() {
        h hVar = (h) f28720a.getAndSet(this, null);
        if (hVar != null) {
            return hVar;
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (((h) this.f28723d.get(i2)) != null && f28722c.compareAndSet(this, i, i + 1)) {
                return (h) this.f28723d.getAndSet(i2, null);
            }
        }
    }

    public final int c() {
        return this.lastScheduledTask != null ? a() + 1 : a();
    }

    public final int a() {
        return this.producerIndex - this.consumerIndex;
    }

    public final boolean a(h hVar, d dVar) {
        kotlin.jvm.internal.h.b(hVar, "task");
        kotlin.jvm.internal.h.b(dVar, "globalQueue");
        h hVar2 = (h) f28720a.getAndSet(this, hVar);
        if (hVar2 != null) {
            return b(hVar2, dVar);
        }
        return true;
    }

    public final boolean a(m mVar, d dVar) {
        int a2;
        h hVar;
        kotlin.jvm.internal.h.b(mVar, "victim");
        kotlin.jvm.internal.h.b(dVar, "globalQueue");
        long a3 = k.f28719g.a();
        int a4 = mVar.a();
        if (a4 == 0) {
            return a(a3, mVar, dVar);
        }
        a2 = kotlin.c.h.a(a4 / 2, 1);
        int i = 0;
        boolean z = false;
        while (i < a2) {
            while (true) {
                int i2 = mVar.consumerIndex;
                hVar = null;
                if (i2 - mVar.producerIndex != 0) {
                    int i3 = i2 & 127;
                    h hVar2 = (h) mVar.f28723d.get(i3);
                    if (hVar2 != null) {
                        if (!(a3 - hVar2.f28710a >= k.f28713a || mVar.a() > k.f28714b)) {
                            break;
                        }
                        if (f28722c.compareAndSet(mVar, i2, i2 + 1)) {
                            hVar = (h) mVar.f28723d.getAndSet(i3, null);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (hVar == null) {
                break;
            }
            a(hVar, dVar);
            i++;
            z = true;
        }
        return z;
    }

    public final boolean b(h hVar, d dVar) {
        kotlin.jvm.internal.h.b(hVar, "task");
        kotlin.jvm.internal.h.b(dVar, "globalQueue");
        boolean z = true;
        while (!a(hVar)) {
            b(dVar);
            z = false;
        }
        return z;
    }

    private final void b(d dVar) {
        int a2;
        h hVar;
        a2 = kotlin.c.h.a(a() / 2, 1);
        for (int i = 0; i < a2; i++) {
            while (true) {
                int i2 = this.consumerIndex;
                hVar = null;
                if (i2 - this.producerIndex == 0) {
                    break;
                }
                int i3 = i2 & 127;
                if (((h) this.f28723d.get(i3)) != null && f28722c.compareAndSet(this, i2, i2 + 1)) {
                    hVar = (h) this.f28723d.getAndSet(i3, null);
                    break;
                }
            }
            if (hVar == null) {
                return;
            }
            a(dVar, hVar);
        }
    }

    private final boolean a(long j, m mVar, d dVar) {
        h hVar = (h) mVar.lastScheduledTask;
        if (hVar == null || j - hVar.f28710a < k.f28713a || !f28720a.compareAndSet(mVar, hVar, null)) {
            return false;
        }
        a(hVar, dVar);
        return true;
    }

    private final void a(d dVar, h hVar) {
        if (!dVar.a((d) hVar)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet");
        }
    }

    public final void a(d dVar) {
        h hVar;
        kotlin.jvm.internal.h.b(dVar, "globalQueue");
        h hVar2 = (h) f28720a.getAndSet(this, null);
        if (hVar2 != null) {
            a(dVar, hVar2);
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                hVar = null;
            } else {
                int i2 = i & 127;
                if (((h) this.f28723d.get(i2)) != null && f28722c.compareAndSet(this, i, i + 1)) {
                    hVar = (h) this.f28723d.getAndSet(i2, null);
                }
            }
            if (hVar == null) {
                return;
            } else {
                a(dVar, hVar);
            }
        }
    }

    private final boolean a(h hVar) {
        if (a() == 127) {
            return false;
        }
        int i = this.producerIndex & 127;
        if (this.f28723d.get(i) != null) {
            return false;
        }
        this.f28723d.lazySet(i, hVar);
        f28721b.incrementAndGet(this);
        return true;
    }
}
