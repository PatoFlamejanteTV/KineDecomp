package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class SharedPreferencesUtils_Factory implements d.a.c<SharedPreferencesUtils> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<FirebaseApp> f17834a;

    @Override // javax.inject.Provider
    public SharedPreferencesUtils get() {
        return new SharedPreferencesUtils(this.f17834a.get());
    }
}
