package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.oa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1433oa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13809a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzeb f13810b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1433oa(zzeb zzebVar, zzk zzkVar) {
        this.f13810b = zzebVar;
        this.f13809a = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13810b.f14019d;
        if (zzajVar == null) {
            this.f13810b.b().q().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzajVar.c(this.f13809a);
            this.f13810b.E();
        } catch (RemoteException e2) {
            this.f13810b.b().q().a("Failed to send measurementEnabled to the service", e2);
        }
    }
}
