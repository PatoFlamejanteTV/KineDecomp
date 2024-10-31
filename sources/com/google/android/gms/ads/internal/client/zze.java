package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zze extends com.google.android.gms.dynamic.zzg<zzt> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzs a(Context context, AdSizeParcel adSizeParcel, String str, zzel zzelVar, int i) {
        try {
            return zzs.zza.zzk(zzas(context).a(com.google.android.gms.dynamic.zze.a(context), adSizeParcel, str, zzelVar, 8115000, i));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Could not create remote AdManager.", e);
            return null;
        }
    }

    public zzs a(Context context, AdSizeParcel adSizeParcel, String str, zzel zzelVar) {
        zzs a2;
        if (zzl.a().b(context) && (a2 = a(context, adSizeParcel, str, zzelVar, 1)) != null) {
            return a2;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Using BannerAdManager from the client jar.");
        return new com.google.android.gms.ads.internal.zzf(context, adSizeParcel, str, zzelVar, new VersionInfoParcel(8115000, 8115000, true), com.google.android.gms.ads.internal.zzd.a());
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: a */
    public zzt zzd(IBinder iBinder) {
        return zzt.zza.a(iBinder);
    }

    public zzs b(Context context, AdSizeParcel adSizeParcel, String str, zzel zzelVar) {
        zzs a2;
        if (zzl.a().b(context) && (a2 = a(context, adSizeParcel, str, zzelVar, 2)) != null) {
            return a2;
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("Using InterstitialAdManager from the client jar.");
        return new com.google.android.gms.ads.internal.zzk(context, adSizeParcel, str, zzelVar, new VersionInfoParcel(8115000, 8115000, true), com.google.android.gms.ads.internal.zzd.a());
    }
}
