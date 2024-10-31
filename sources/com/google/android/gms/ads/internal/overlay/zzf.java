package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<AdOverlayInfoParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adOverlayInfoParcel.f589a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) adOverlayInfoParcel.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, adOverlayInfoParcel.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, adOverlayInfoParcel.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, adOverlayInfoParcel.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, adOverlayInfoParcel.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, adOverlayInfoParcel.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, adOverlayInfoParcel.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, adOverlayInfoParcel.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, adOverlayInfoParcel.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, adOverlayInfoParcel.k);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, adOverlayInfoParcel.l);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, adOverlayInfoParcel.m, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, (Parcelable) adOverlayInfoParcel.n, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, adOverlayInfoParcel.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, (Parcelable) adOverlayInfoParcel.q, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, adOverlayInfoParcel.p, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    iBinder5 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 11:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 13:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 16:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
