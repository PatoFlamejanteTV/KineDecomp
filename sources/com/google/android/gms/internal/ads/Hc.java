package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: classes2.dex */
final class Hc implements Ic {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f11561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hc(Context context) {
        this.f11561a = context;
    }

    @Override // com.google.android.gms.internal.ads.Ic
    public final boolean a(zzbbi zzbbiVar) {
        boolean zze;
        zzwu.zzpv();
        boolean zzc = zzbat.zzc(this.f11561a, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        boolean z = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcwr)).booleanValue() && zzbbiVar.zzeow;
        com.google.android.gms.ads.internal.zzbv.e();
        boolean zzec = zzayh.zzec(this.f11561a.getPackageName());
        zze = zzary.zze(this.f11561a, zzbbiVar.zzeow);
        return !zze || !zzc || z || zzec;
    }
}
