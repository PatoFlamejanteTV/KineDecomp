package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final class DataCollectionHelper_Factory implements d.a.c<DataCollectionHelper> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<FirebaseApp> f17729a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<SharedPreferencesUtils> f17730b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<FirebaseInstanceId> f17731c;

    /* renamed from: d, reason: collision with root package name */
    private final Provider<Subscriber> f17732d;

    @Override // javax.inject.Provider
    public DataCollectionHelper get() {
        return new DataCollectionHelper(this.f17729a.get(), this.f17730b.get(), this.f17731c.get(), this.f17732d.get());
    }
}
