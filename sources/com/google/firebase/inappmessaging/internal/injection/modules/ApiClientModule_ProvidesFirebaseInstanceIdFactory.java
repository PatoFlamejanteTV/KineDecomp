package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.iid.FirebaseInstanceId;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesFirebaseInstanceIdFactory implements d.a.c<FirebaseInstanceId> {

    /* renamed from: a, reason: collision with root package name */
    private final ApiClientModule f17924a;

    public ApiClientModule_ProvidesFirebaseInstanceIdFactory(ApiClientModule apiClientModule) {
        this.f17924a = apiClientModule;
    }

    public static d.a.c<FirebaseInstanceId> a(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseInstanceIdFactory(apiClientModule);
    }

    @Override // javax.inject.Provider
    public FirebaseInstanceId get() {
        FirebaseInstanceId b2 = this.f17924a.b();
        f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }
}
