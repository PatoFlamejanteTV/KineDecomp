package com.google.android.gms.internal;

import com.google.android.gms.internal.zzja;

/* loaded from: classes.dex */
final class cz implements zzja.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcg f1492a;
    final /* synthetic */ zzce b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(zzcg zzcgVar, zzce zzceVar, String str) {
        this.f1492a = zzcgVar;
        this.b = zzceVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.zzja.zza
    public void zza(zziz zzizVar, boolean z) {
        this.f1492a.zza(this.b, "jsf");
        this.f1492a.zzdo();
        zzizVar.zza("AFMA_buildAdURL", this.c);
    }
}
