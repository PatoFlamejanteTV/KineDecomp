package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final c[] f11a;

    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f11a = cVarArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, Lifecycle.Event event) {
        k kVar = new k();
        for (c cVar : this.f11a) {
            cVar.a(eVar, event, false, kVar);
        }
        for (c cVar2 : this.f11a) {
            cVar2.a(eVar, event, true, kVar);
        }
    }
}
