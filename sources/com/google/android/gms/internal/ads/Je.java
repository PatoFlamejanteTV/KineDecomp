package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Je implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzbcx f11626a;

    public Je(zzbcx zzbcxVar) {
        this.f11626a = zzbcxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11626a.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11626a.zzeqt;
            zzbdhVar2.zzabf();
        }
    }
}
