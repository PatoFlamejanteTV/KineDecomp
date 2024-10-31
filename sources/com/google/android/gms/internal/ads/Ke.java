package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ke implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11641a;

    public Ke(zzbcx zzbcxVar) {
        this.f11641a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11641a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11641a.zzeqt;
            zzbdhVar2.onPaused();
        }
    }
}
