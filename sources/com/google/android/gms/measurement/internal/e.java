package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzab f2029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzab zzabVar) {
        this.f2029a = zzabVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzm zzmVar;
        zzmVar = this.f2029a.b;
        if (zzmVar == null) {
            this.f2029a.l().b().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzmVar.a(this.f2029a.f().b());
            this.f2029a.q();
        } catch (RemoteException e) {
            this.f2029a.l().b().a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
