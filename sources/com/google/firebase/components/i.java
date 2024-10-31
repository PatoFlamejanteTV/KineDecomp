package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
class i<T> implements Provider<T> {

    /* renamed from: a */
    private static final Object f16592a = new Object();

    /* renamed from: b */
    private volatile Object f16593b = f16592a;

    /* renamed from: c */
    private volatile Provider<T> f16594c;

    public i(ComponentFactory<T> componentFactory, ComponentContainer componentContainer) {
        this.f16594c = h.a(componentFactory, componentContainer);
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t = (T) this.f16593b;
        if (t == f16592a) {
            synchronized (this) {
                t = (T) this.f16593b;
                if (t == f16592a) {
                    t = this.f16594c.get();
                    this.f16593b = t;
                    this.f16594c = null;
                }
            }
        }
        return t;
    }
}
