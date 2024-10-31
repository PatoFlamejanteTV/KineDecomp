package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.m;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public class l<E> {

    /* renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f28644a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public l(boolean z) {
        this._cur$internal = new m(8, z);
    }

    public final void a() {
        while (true) {
            m mVar = (m) this._cur$internal;
            if (mVar.a()) {
                return;
            } else {
                f28644a.compareAndSet(this, mVar, mVar.d());
            }
        }
    }

    public final int b() {
        return ((m) this._cur$internal).b();
    }

    public final E c() {
        E e2;
        Object obj;
        while (true) {
            m mVar = (m) this._cur$internal;
            while (true) {
                long j = mVar._state$internal;
                e2 = null;
                if ((1152921504606846976L & j) != 0) {
                    e2 = (E) m.f28647c;
                    break;
                }
                m.a aVar = m.f28648d;
                int i = (int) ((1073741823 & j) >> 0);
                if ((mVar.f28649e & ((int) ((1152921503533105152L & j) >> 30))) == (mVar.f28649e & i)) {
                    break;
                }
                obj = mVar.f28650f.get(mVar.f28649e & i);
                if (obj == null) {
                    if (mVar.f28652h) {
                        break;
                    }
                } else {
                    if (obj instanceof m.b) {
                        break;
                    }
                    int i2 = (i + 1) & 1073741823;
                    if (m.f28646b.compareAndSet(mVar, j, m.f28648d.a(j, i2))) {
                        mVar.f28650f.set(mVar.f28649e & i, null);
                        break;
                    }
                    if (mVar.f28652h) {
                        m mVar2 = mVar;
                        do {
                            mVar2 = mVar2.a(i, i2);
                        } while (mVar2 != null);
                    }
                }
            }
            e2 = (E) obj;
            if (e2 != m.f28647c) {
                return e2;
            }
            f28644a.compareAndSet(this, mVar, mVar.d());
        }
    }

    public final boolean a(E e2) {
        kotlin.jvm.internal.h.b(e2, "element");
        while (true) {
            m mVar = (m) this._cur$internal;
            int a2 = mVar.a((m) e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                f28644a.compareAndSet(this, mVar, mVar.d());
            } else if (a2 == 2) {
                return false;
            }
        }
    }
}
