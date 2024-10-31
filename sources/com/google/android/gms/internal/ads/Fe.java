package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Fe implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f11526a;

    /* renamed from: b */
    private final /* synthetic */ String f11527b;

    /* renamed from: c */
    private final /* synthetic */ zzbcx f11528c;

    public Fe(zzbcx zzbcxVar, String str, String str2) {
        this.f11528c = zzbcxVar;
        this.f11526a = str;
        this.f11527b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdh zzbdhVar;
        zzbdh zzbdhVar2;
        zzbdhVar = this.f11528c.zzeqt;
        if (zzbdhVar != null) {
            zzbdhVar2 = this.f11528c.zzeqt;
            zzbdhVar2.zzi(this.f11526a, this.f11527b);
        }
    }
}
