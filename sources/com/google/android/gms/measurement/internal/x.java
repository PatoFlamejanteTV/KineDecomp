package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class X implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty f13711a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzda f13712b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(zzda zzdaVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f13712b = zzdaVar;
        this.f13711a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13712b.d(this.f13711a);
    }
}
