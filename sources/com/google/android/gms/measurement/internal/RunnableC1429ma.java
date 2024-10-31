package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ma, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1429ma implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdx f13803a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzeb f13804b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1429ma(zzeb zzebVar, zzdx zzdxVar) {
        this.f13804b = zzebVar;
        this.f13803a = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13804b.f14019d;
        if (zzajVar == null) {
            this.f13804b.b().q().a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f13803a == null) {
                zzajVar.a(0L, (String) null, (String) null, this.f13804b.getContext().getPackageName());
            } else {
                zzajVar.a(this.f13803a.f14010c, this.f13803a.f14008a, this.f13803a.f14009b, this.f13804b.getContext().getPackageName());
            }
            this.f13804b.E();
        } catch (RemoteException e2) {
            this.f13804b.b().q().a("Failed to send current screen to the service", e2);
        }
    }
}
