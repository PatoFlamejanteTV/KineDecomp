package com.google.firebase.crash.component;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.events.Subscriber;

/* loaded from: classes2.dex */
final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    static final ComponentFactory f16618a = new a();

    private a() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return new FirebaseCrash((FirebaseApp) componentContainer.a(FirebaseApp.class), (Subscriber) componentContainer.a(Subscriber.class));
    }
}
