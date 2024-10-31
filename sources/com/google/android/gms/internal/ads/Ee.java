package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ee implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11486a;

    public Ee(zzbcx zzbcxVar) {
        this.f11486a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11486a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11486a.zzeqt;
            zzbdhVar2.zzabg();
        }
    }
}
