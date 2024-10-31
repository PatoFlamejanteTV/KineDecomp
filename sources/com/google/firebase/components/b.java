package com.google.firebase.components;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a */
    private final Object f16581a;

    private b(Object obj) {
        this.f16581a = obj;
    }

    public static ComponentFactory a(Object obj) {
        return new b(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        Object obj = this.f16581a;
        Component.a(obj, componentContainer);
        return obj;
    }
}
