package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.Registrar;

/* renamed from: com.google.firebase.iid.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final /* synthetic */ class C1615l implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f17361a = new C1615l();

    private C1615l() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return new Registrar.a((FirebaseInstanceId) componentContainer.a(FirebaseInstanceId.class));
    }
}
