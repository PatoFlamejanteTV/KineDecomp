package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Tc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzasi f11841a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzast f11842b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzatq f11843c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tc(zzatq zzatqVar, zzasi zzasiVar, zzast zzastVar) {
        this.f11843c = zzatqVar;
        this.f11841a = zzasiVar;
        this.f11842b = zzastVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasm zzasmVar;
        try {
            zzasmVar = this.f11843c.zzb(this.f11841a);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdRequestServiceImpl.loadAdAsync");
            zzbbd.zzc("Could not fetch ad response due to an Exception.", e2);
            zzasmVar = null;
        }
        if (zzasmVar == null) {
            zzasmVar = new zzasm(0);
        }
        try {
            this.f11842b.zza(zzasmVar);
        } catch (RemoteException e3) {
            zzbbd.zzc("Fail to forward ad response.", e3);
        }
    }
}
