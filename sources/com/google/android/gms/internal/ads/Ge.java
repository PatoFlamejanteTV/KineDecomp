package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ge implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11546a;

    public Ge(zzbcx zzbcxVar) {
        this.f11546a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11546a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11546a.zzeqt;
            zzbdhVar2.zzabe();
        }
    }
}
