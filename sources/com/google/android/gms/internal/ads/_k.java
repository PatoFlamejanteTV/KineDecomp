package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class _k implements Runnable {

    /* renamed from: a */
    private final zzr f12042a;

    /* renamed from: b */
    private final zzx f12043b;

    /* renamed from: c */
    private final Runnable f12044c;

    public _k(zzr zzrVar, zzx zzxVar, Runnable runnable) {
        this.f12042a = zzrVar;
        this.f12043b = zzxVar;
        this.f12044c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12042a.isCanceled();
        if (this.f12043b.zzbh == null) {
            this.f12042a.zza((zzr) this.f12043b.result);
        } else {
            this.f12042a.zzb(this.f12043b.zzbh);
        }
        if (this.f12043b.zzbi) {
            this.f12042a.zzb("intermediate-response");
        } else {
            this.f12042a.zzc("done");
        }
        Runnable runnable = this.f12044c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
