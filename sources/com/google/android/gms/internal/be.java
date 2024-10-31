package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
class be implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1445a;
    final /* synthetic */ zzil b;
    final /* synthetic */ az c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar, zzbb zzbbVar, zzil zzilVar) {
        this.c = azVar;
        this.f1445a = zzbbVar;
        this.b = zzilVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        Object obj;
        int i;
        obj = this.c.b.zzpd;
        synchronized (obj) {
            com.google.android.gms.ads.internal.util.client.zzb.c("JS Engine is requesting an update");
            i = this.c.b.zzys;
            if (i == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.c("Starting reload.");
                this.c.b.zzys = 2;
                this.c.b.zzdN();
            }
            this.f1445a.zzb("/requestReload", (zzdk) this.b.get());
        }
    }
}
