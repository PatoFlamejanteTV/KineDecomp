package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* renamed from: a */
    private final FullLifecycleObserver f12a;

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f12a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, Lifecycle.Event event) {
        switch (b.f38a[event.ordinal()]) {
            case 1:
                this.f12a.b(eVar);
                return;
            case 2:
                this.f12a.c(eVar);
                return;
            case 3:
                this.f12a.e(eVar);
                return;
            case 4:
                this.f12a.d(eVar);
                return;
            case 5:
                this.f12a.f(eVar);
                return;
            case 6:
                this.f12a.a(eVar);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
