package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.a;

/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final Object f28a;

    /* renamed from: b */
    private final a.C0000a f29b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f28a = obj;
        this.f29b = a.f31a.a(this.f28a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void a(e eVar, Lifecycle.Event event) {
        this.f29b.a(eVar, event, this.f28a);
    }
}
