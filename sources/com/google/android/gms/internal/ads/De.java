package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class De implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11459a;

    public De(zzbcx zzbcxVar) {
        this.f11459a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11459a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11459a.zzeqt;
            zzbdhVar2.zzcg();
        }
    }
}
