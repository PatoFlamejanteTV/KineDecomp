package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<RewardItemParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, rewardItemParcel.f650a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, rewardItemParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, rewardItemParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardItemParcel createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new RewardItemParcel(i2, str, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RewardItemParcel[] newArray(int i) {
        return new RewardItemParcel[i];
    }
}
