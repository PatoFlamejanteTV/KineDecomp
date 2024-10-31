package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;

@zzark
/* loaded from: classes.dex */
final class d extends zzaxv {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzd f10110a;

    private d(zzd zzdVar) {
        this.f10110a = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        Bitmap zza = zzbv.z().zza(Integer.valueOf(this.f10110a.f10128c.o.f10209f));
        if (zza != null) {
            zzayp g2 = zzbv.g();
            zzd zzdVar = this.f10110a;
            Activity activity = zzdVar.f10127b;
            zzaq zzaqVar = zzdVar.f10128c.o;
            zzayh.zzelc.post(new e(this, g2.zza(activity, zza, zzaqVar.f10207d, zzaqVar.f10208e)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(zzd zzdVar, b bVar) {
        this(zzdVar);
    }
}
