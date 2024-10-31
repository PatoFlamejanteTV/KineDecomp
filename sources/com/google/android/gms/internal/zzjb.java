package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzgr
/* loaded from: classes.dex */
public class zzjb {
    public zziz zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzanVar, versionInfoParcel, null, null);
    }

    public zziz zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcg zzcgVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        ej ejVar = new ej(zzjd.a(context, adSizeParcel, z, z2, zzanVar, versionInfoParcel, zzcgVar, zzdVar));
        ejVar.setWebViewClient(com.google.android.gms.ads.internal.zzp.g().zzb(ejVar, z2));
        ejVar.setWebChromeClient(com.google.android.gms.ads.internal.zzp.g().zzf(ejVar));
        return ejVar;
    }
}
