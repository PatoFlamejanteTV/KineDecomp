package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.la, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1427la implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzk f13795a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzeb f13796b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1427la(zzeb zzebVar, zzk zzkVar) {
        this.f13796b = zzebVar;
        this.f13795a = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        zzajVar = this.f13796b.f14019d;
        if (zzajVar == null) {
            this.f13796b.b().q().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzajVar.a(this.f13795a);
            this.f13796b.a(zzajVar, null, this.f13795a);
            this.f13796b.E();
        } catch (RemoteException e2) {
            this.f13796b.b().q().a("Failed to send app launch to the service", e2);
        }
    }
}
