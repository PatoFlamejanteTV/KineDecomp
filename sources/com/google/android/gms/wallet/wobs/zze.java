package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<LoyaltyPoints> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LoyaltyPoints loyaltyPoints, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, loyaltyPoints.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, loyaltyPoints.f2318a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) loyaltyPoints.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, loyaltyPoints.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) loyaltyPoints.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoyaltyPoints createFromParcel(Parcel parcel) {
        TimeInterval timeInterval = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        LoyaltyPointsBalance loyaltyPointsBalance = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    loyaltyPointsBalance = (LoyaltyPointsBalance) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LoyaltyPointsBalance.CREATOR);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TimeInterval.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LoyaltyPoints(i, str2, loyaltyPointsBalance, str, timeInterval);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoyaltyPoints[] newArray(int i) {
        return new LoyaltyPoints[i];
    }
}
