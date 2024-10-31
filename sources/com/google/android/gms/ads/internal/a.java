package com.google.android.gms.ads.internal;

import android.content.Intent;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f530a;
    final /* synthetic */ zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzb zzbVar, Intent intent) {
        this.b = zzbVar;
        this.f530a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2 = zzp.o().a(this.f530a);
        zzp.o();
        if (a2 == 0 && this.b.zzot.j != null && this.b.zzot.j.zzBD != null && this.b.zzot.j.zzBD.zzhc() != null) {
            this.b.zzot.j.zzBD.zzhc().a();
        }
        this.b.zzot.D = false;
    }
}
