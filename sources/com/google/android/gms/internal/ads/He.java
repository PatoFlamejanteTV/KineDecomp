package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class He implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f11563a;

    /* renamed from: b */
    private final /* synthetic */ int f11564b;

    /* renamed from: c */
    private final /* synthetic */ zzbcx f11565c;

    public He(zzbcx zzbcxVar, int i, int i2) {
        this.f11565c = zzbcxVar;
        this.f11563a = i;
        this.f11564b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11565c.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11565c.zzeqt;
            zzbdhVar2.zzm(this.f11563a, this.f11564b);
        }
    }
}
