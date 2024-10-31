package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty f13718a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzda f13719b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(zzda zzdaVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f13719b = zzdaVar;
        this.f13718a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13719b.e(this.f13718a);
    }
}
