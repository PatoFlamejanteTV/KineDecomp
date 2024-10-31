package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.identity.intents.model.UserAddress;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<FullWallet> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FullWallet fullWallet, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, fullWallet.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, fullWallet.f2281a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, fullWallet.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) fullWallet.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, fullWallet.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) fullWallet.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) fullWallet.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, fullWallet.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) fullWallet.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, (Parcelable) fullWallet.i, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable[]) fullWallet.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable) fullWallet.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FullWallet createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ProxyCard proxyCard = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        String[] strArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        PaymentMethodToken paymentMethodToken = null;
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
                    proxyCard = (ProxyCard) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ProxyCard.CREATOR);
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
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 9:
                    userAddress = (UserAddress) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress2 = (UserAddress) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, InstrumentInfo.CREATOR);
                    break;
                case 12:
                    paymentMethodToken = (PaymentMethodToken) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PaymentMethodToken.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FullWallet(i, str, str2, proxyCard, str3, address, address2, strArr, userAddress, userAddress2, instrumentInfoArr, paymentMethodToken);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
