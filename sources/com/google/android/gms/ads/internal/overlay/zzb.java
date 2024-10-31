package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<AdLauncherIntentInfoParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adLauncherIntentInfoParcel.f588a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, adLauncherIntentInfoParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, adLauncherIntentInfoParcel.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, adLauncherIntentInfoParcel.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, adLauncherIntentInfoParcel.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, adLauncherIntentInfoParcel.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, adLauncherIntentInfoParcel.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, adLauncherIntentInfoParcel.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdLauncherIntentInfoParcel createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdLauncherIntentInfoParcel[] newArray(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }
}
