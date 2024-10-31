package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GiftCardWalletObject> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GiftCardWalletObject giftCardWalletObject, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, giftCardWalletObject.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) giftCardWalletObject.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, giftCardWalletObject.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, giftCardWalletObject.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, giftCardWalletObject.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, giftCardWalletObject.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, giftCardWalletObject.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, giftCardWalletObject.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, giftCardWalletObject.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject createFromParcel(Parcel parcel) {
        long j = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        CommonWalletObject commonWalletObject = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    commonWalletObject = (CommonWalletObject) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, CommonWalletObject.CREATOR);
                    break;
                case 3:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 9:
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
        return new GiftCardWalletObject(i, commonWalletObject, str5, str4, str3, j2, str2, j, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject[] newArray(int i) {
        return new GiftCardWalletObject[i];
    }
}
