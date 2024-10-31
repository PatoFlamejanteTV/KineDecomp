package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ie implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11595a;

    public Ie(zzbcx zzbcxVar) {
        this.f11595a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdh zzbdhVar3;
        zzbdhVar = this.f11595a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11595a.zzeqt;
            zzbdhVar2.onPaused();
            zzbdhVar3 = this.f11595a.zzeqt;
            zzbdhVar3.zzabh();
        }
    }
}
