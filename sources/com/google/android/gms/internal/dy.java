package com.google.android.gms.internal;

import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzm;

/* loaded from: classes.dex */
class dy implements zzm.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1517a;
    final /* synthetic */ zzih.b b;
    final /* synthetic */ zzih c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(zzih zzihVar, String str, zzih.b bVar) {
        this.c = zzihVar;
        this.f1517a = str;
        this.b = bVar;
    }

    @Override // com.google.android.gms.internal.zzm.zza
    public void zze(zzr zzrVar) {
        com.google.android.gms.ads.internal.util.client.zzb.e("Failed to load URL: " + this.f1517a + "\n" + zzrVar.toString());
        this.b.zzb(null);
    }
}
