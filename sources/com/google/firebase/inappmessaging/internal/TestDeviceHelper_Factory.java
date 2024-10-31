package com.google.firebase.inappmessaging.internal;

import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class TestDeviceHelper_Factory implements d.a.c<TestDeviceHelper> {

    /* renamed from: a */
    private final Provider<SharedPreferencesUtils> f17840a;

    @Override // javax.inject.Provider
    public TestDeviceHelper get() {
        return new TestDeviceHelper(this.f17840a.get());
    }
}
