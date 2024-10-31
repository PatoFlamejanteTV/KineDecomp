package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Provider {

    /* renamed from: a */
    private final ComponentFactory f16590a;

    /* renamed from: b */
    private final ComponentContainer f16591b;

    private h(ComponentFactory componentFactory, ComponentContainer componentContainer) {
        this.f16590a = componentFactory;
        this.f16591b = componentContainer;
    }

    public static Provider a(ComponentFactory componentFactory, ComponentContainer componentContainer) {
        return new h(componentFactory, componentContainer);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        Object a2;
        a2 = this.f16590a.a(this.f16591b);
        return a2;
    }
}
