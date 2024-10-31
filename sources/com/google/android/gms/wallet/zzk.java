package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.identity.intents.model.UserAddress;

/* loaded from: classes.dex */
public class zzk implements Parcelable.Creator<MaskedWallet> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, maskedWallet.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, maskedWallet.f2287a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, maskedWallet.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, maskedWallet.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, maskedWallet.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) maskedWallet.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) maskedWallet.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable[]) maskedWallet.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable[]) maskedWallet.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, (Parcelable) maskedWallet.i, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) maskedWallet.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable[]) maskedWallet.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MaskedWallet createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    address = (Address) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, InstrumentInfo.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
