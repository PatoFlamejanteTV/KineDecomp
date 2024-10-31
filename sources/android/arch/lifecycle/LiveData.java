package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a */
    private static final Object f13a = new Object();

    /* renamed from: b */
    private final Object f14b = new Object();

    /* renamed from: c */
    private b.a.a.b.c<m<T>, LiveData<T>.b> f15c = new b.a.a.b.c<>();

    /* renamed from: d */
    private int f16d = 0;

    /* renamed from: e */
    private volatile Object f17e;

    /* renamed from: f */
    private volatile Object f18f;

    /* renamed from: g */
    private int f19g;

    /* renamed from: h */
    private boolean f20h;
    private boolean i;
    private final Runnable j;

    /* loaded from: classes.dex */
    private class a extends LiveData<T>.b {
        a(m<T> mVar) {
            super(mVar);
        }

        @Override // android.arch.lifecycle.LiveData.b
        boolean b() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a */
        final m<T> f24a;

        /* renamed from: b */
        boolean f25b;

        /* renamed from: c */
        int f26c = -1;

        b(m<T> mVar) {
            this.f24a = mVar;
        }

        void a() {
        }

        void a(boolean z) {
            if (z == this.f25b) {
                return;
            }
            this.f25b = z;
            boolean z2 = LiveData.this.f16d == 0;
            LiveData.this.f16d += this.f25b ? 1 : -1;
            if (z2 && this.f25b) {
                LiveData.this.b();
            }
            if (LiveData.this.f16d == 0 && !this.f25b) {
                LiveData.this.c();
            }
            if (this.f25b) {
                LiveData.this.b(this);
            }
        }

        boolean a(e eVar) {
            return false;
        }

        abstract boolean b();
    }

    public LiveData() {
        Object obj = f13a;
        this.f17e = obj;
        this.f18f = obj;
        this.f19g = -1;
        this.j = new j(this);
    }

    protected abstract void b();

    protected abstract void c();

    public T getValue() {
        T t = (T) this.f17e;
        if (t != f13a) {
            return t;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        return this.f16d > 0;
    }

    public boolean hasObservers() {
        return this.f15c.size() > 0;
    }

    public void observe(e eVar, m<T> mVar) {
        if (eVar.getLifecycle().a() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(eVar, mVar);
        LiveData<T>.b b2 = this.f15c.b(mVar, lifecycleBoundObserver);
        if (b2 != null && !b2.a(eVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        eVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void observeForever(m<T> mVar) {
        a aVar = new a(mVar);
        LiveData<T>.b b2 = this.f15c.b(mVar, aVar);
        if (b2 != null && (b2 instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        aVar.a(true);
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.f14b) {
            z = this.f18f == f13a;
            this.f18f = t;
        }
        if (z) {
            b.a.a.a.c.b().b(this.j);
        }
    }

    public void removeObserver(m<T> mVar) {
        a("removeObserver");
        LiveData<T>.b remove = this.f15c.remove(mVar);
        if (remove == null) {
            return;
        }
        remove.a();
        remove.a(false);
    }

    public void removeObservers(e eVar) {
        a("removeObservers");
        Iterator<Map.Entry<m<T>, LiveData<T>.b>> it = this.f15c.iterator();
        while (it.hasNext()) {
            Map.Entry<m<T>, LiveData<T>.b> next = it.next();
            if (next.getValue().a(eVar)) {
                removeObserver(next.getKey());
            }
        }
    }

    public void setValue(T t) {
        a("setValue");
        this.f19g++;
        this.f17e = t;
        b((b) null);
    }

    public void b(LiveData<T>.b bVar) {
        if (this.f20h) {
            this.i = true;
            return;
        }
        this.f20h = true;
        do {
            this.i = false;
            if (bVar != null) {
                a(bVar);
                bVar = null;
            } else {
                b.a.a.b.c<m<T>, LiveData<T>.b>.d d2 = this.f15c.d();
                while (d2.hasNext()) {
                    a((b) d2.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.f20h = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.b implements GenericLifecycleObserver {

        /* renamed from: e */
        final e f21e;

        LifecycleBoundObserver(e eVar, m<T> mVar) {
            super(mVar);
            this.f21e = eVar;
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        public void a(e eVar, Lifecycle.Event event) {
            if (this.f21e.getLifecycle().a() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f24a);
            } else {
                a(b());
            }
        }

        @Override // android.arch.lifecycle.LiveData.b
        boolean b() {
            return this.f21e.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.LiveData.b
        boolean a(e eVar) {
            return this.f21e == eVar;
        }

        @Override // android.arch.lifecycle.LiveData.b
        void a() {
            this.f21e.getLifecycle().b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(LiveData<T>.b bVar) {
        if (bVar.f25b) {
            if (!bVar.b()) {
                bVar.a(false);
                return;
            }
            int i = bVar.f26c;
            int i2 = this.f19g;
            if (i >= i2) {
                return;
            }
            bVar.f26c = i2;
            bVar.f24a.onChanged(this.f17e);
        }
    }

    private static void a(String str) {
        if (b.a.a.a.c.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
