package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.events.Subscriber;

/* renamed from: com.google.firebase.iid.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final /* synthetic */ class C1614k implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f17360a = new C1614k();

    private C1614k() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.a(FirebaseApp.class), (Subscriber) componentContainer.a(Subscriber.class));
    }
}
