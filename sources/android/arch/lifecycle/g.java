package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class g extends Lifecycle {

    /* renamed from: c */
    private final WeakReference<e> f43c;

    /* renamed from: a */
    private b.a.a.b.a<d, a> f41a = new b.a.a.b.a<>();

    /* renamed from: d */
    private int f44d = 0;

    /* renamed from: e */
    private boolean f45e = false;

    /* renamed from: f */
    private boolean f46f = false;

    /* renamed from: g */
    private ArrayList<Lifecycle.State> f47g = new ArrayList<>();

    /* renamed from: b */
    private Lifecycle.State f42b = Lifecycle.State.INITIALIZED;

    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        Lifecycle.State f48a;

        /* renamed from: b */
        GenericLifecycleObserver f49b;

        a(d dVar, Lifecycle.State state) {
            this.f49b = i.a(dVar);
            this.f48a = state;
        }

        void a(e eVar, Lifecycle.Event event) {
            Lifecycle.State a2 = g.a(event);
            this.f48a = g.a(this.f48a, a2);
            this.f49b.a(eVar, event);
            this.f48a = a2;
        }
    }

    public g(e eVar) {
        this.f43c = new WeakReference<>(eVar);
    }

    private void c(Lifecycle.State state) {
        if (this.f42b == state) {
            return;
        }
        this.f42b = state;
        if (!this.f45e && this.f44d == 0) {
            this.f45e = true;
            d();
            this.f45e = false;
            return;
        }
        this.f46f = true;
    }

    private void d(Lifecycle.State state) {
        this.f47g.add(state);
    }

    private static Lifecycle.Event e(Lifecycle.State state) {
        int i = f.f40b[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Lifecycle.Event.ON_START;
            }
            if (i == 3) {
                return Lifecycle.Event.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + state);
            }
        }
        return Lifecycle.Event.ON_CREATE;
    }

    public void a(Lifecycle.State state) {
        c(state);
    }

    public void b(Lifecycle.Event event) {
        c(a(event));
    }

    private void d() {
        e eVar = this.f43c.get();
        if (eVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f46f = false;
            if (this.f42b.compareTo(this.f41a.a().getValue().f48a) < 0) {
                a(eVar);
            }
            Map.Entry<d, a> e2 = this.f41a.e();
            if (!this.f46f && e2 != null && this.f42b.compareTo(e2.getValue().f48a) > 0) {
                b(eVar);
            }
        }
        this.f46f = false;
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(d dVar) {
        e eVar;
        Lifecycle.State state = this.f42b;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(dVar, state2);
        if (this.f41a.b(dVar, aVar) == null && (eVar = this.f43c.get()) != null) {
            boolean z = this.f44d != 0 || this.f45e;
            Lifecycle.State c2 = c(dVar);
            this.f44d++;
            while (aVar.f48a.compareTo(c2) < 0 && this.f41a.contains(dVar)) {
                d(aVar.f48a);
                aVar.a(eVar, e(aVar.f48a));
                c();
                c2 = c(dVar);
            }
            if (!z) {
                d();
            }
            this.f44d--;
        }
    }

    private boolean b() {
        if (this.f41a.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f41a.a().getValue().f48a;
        Lifecycle.State state2 = this.f41a.e().getValue().f48a;
        return state == state2 && this.f42b == state2;
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(d dVar) {
        this.f41a.remove(dVar);
    }

    private static Lifecycle.Event b(Lifecycle.State state) {
        int i = f.f40b[state.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i == 3) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i == 4) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i != 5) {
            throw new IllegalArgumentException("Unexpected state value " + state);
        }
        throw new IllegalArgumentException();
    }

    private Lifecycle.State c(d dVar) {
        Map.Entry<d, a> b2 = this.f41a.b(dVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = b2 != null ? b2.getValue().f48a : null;
        if (!this.f47g.isEmpty()) {
            state = this.f47g.get(r0.size() - 1);
        }
        return a(a(this.f42b, state2), state);
    }

    private void c() {
        this.f47g.remove(r0.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(e eVar) {
        b.a.a.b.c<d, a>.d d2 = this.f41a.d();
        while (d2.hasNext() && !this.f46f) {
            Map.Entry next = d2.next();
            a aVar = (a) next.getValue();
            while (aVar.f48a.compareTo(this.f42b) < 0 && !this.f46f && this.f41a.contains(next.getKey())) {
                d(aVar.f48a);
                aVar.a(eVar, e(aVar.f48a));
                c();
            }
        }
    }

    @Override // android.arch.lifecycle.Lifecycle
    public Lifecycle.State a() {
        return this.f42b;
    }

    static Lifecycle.State a(Lifecycle.Event event) {
        switch (f.f39a[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private void a(e eVar) {
        Iterator<Map.Entry<d, a>> descendingIterator = this.f41a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f46f) {
            Map.Entry<d, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.f48a.compareTo(this.f42b) > 0 && !this.f46f && this.f41a.contains(next.getKey())) {
                Lifecycle.Event b2 = b(value.f48a);
                d(a(b2));
                value.a(eVar, b2);
                c();
            }
        }
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
