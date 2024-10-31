package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<LoyaltyPointsBalance> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, loyaltyPointsBalance.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, loyaltyPointsBalance.f2319a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, loyaltyPointsBalance.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, loyaltyPointsBalance.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, loyaltyPointsBalance.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, loyaltyPointsBalance.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, loyaltyPointsBalance.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoyaltyPointsBalance createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LoyaltyPointsBalance(i3, i, str2, d, str, j, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoyaltyPointsBalance[] newArray(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
