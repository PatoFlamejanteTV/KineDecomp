package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Mj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f11691a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f11692b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzdl f11693c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mj(zzdl zzdlVar, int i, boolean z) {
        this.f11693c = zzdlVar;
        this.f11691a = i;
        this.f11692b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzbl zzb = this.f11693c.zzb(this.f11691a, this.f11692b);
        this.f11693c.zzsx = zzb;
        zza = zzdl.zza(this.f11691a, zzb);
        if (zza) {
            this.f11693c.zza(this.f11691a + 1, this.f11692b);
        }
    }
}
