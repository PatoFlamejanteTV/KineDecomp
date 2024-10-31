package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final c f30a;

    public SingleGeneratedAdapterObserver(c cVar) {
        this.f30a = cVar;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, Lifecycle.Event event) {
        this.f30a.a(eVar, event, false, null);
        this.f30a.a(eVar, event, true, null);
    }
}
