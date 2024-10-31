package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class g implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f16492a = new g();

    private g() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.a(FirebaseApp.class);
        zzj zzjVar = new zzj(firebaseApp);
        firebaseApp.a(zzjVar);
        return zzjVar;
    }
}
