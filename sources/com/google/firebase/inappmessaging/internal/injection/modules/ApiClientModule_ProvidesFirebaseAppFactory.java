package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import d.a.f;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class ApiClientModule_ProvidesFirebaseAppFactory implements d.a.c<FirebaseApp> {

    /* renamed from: a, reason: collision with root package name */
    private final ApiClientModule f17923a;

    @Override // javax.inject.Provider
    public FirebaseApp get() {
        FirebaseApp a2 = this.f17923a.a();
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
