package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@zzark
/* loaded from: classes2.dex */
public final class zzaxc implements zzaxe {
    @Override // com.google.android.gms.internal.ads.zzaxe
    public final zzbcb<String> zza(String str, PackageInfo packageInfo) {
        return zzbbq.zzm(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaxe
    public final zzbcb<AdvertisingIdClient.Info> zzad(Context context) {
        zzbcl zzbclVar = new zzbcl();
        zzwu.zzpv();
        if (zzbat.zzbh(context)) {
            zzayf.zzc(new RunnableC0996md(this, context, zzbclVar));
        }
        return zzbclVar;
    }
}
