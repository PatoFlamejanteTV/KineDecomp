package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<RewardedVideoAdRequestParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, rewardedVideoAdRequestParcel.f643a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) rewardedVideoAdRequestParcel.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, rewardedVideoAdRequestParcel.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        String p;
        AdRequestParcel adRequestParcel;
        int i;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    adRequestParcel = adRequestParcel2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, AdRequestParcel.CREATOR);
                    i = i2;
                    p = str;
                    adRequestParcel = adRequestParcel3;
                    break;
                case 3:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }
}
