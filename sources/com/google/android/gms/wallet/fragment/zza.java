package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<WalletFragmentInitParams> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, walletFragmentInitParams.f2311a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, walletFragmentInitParams.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) walletFragmentInitParams.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, walletFragmentInitParams.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) walletFragmentInitParams.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentInitParams createFromParcel(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
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
                    maskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MaskedWallet.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentInitParams[] newArray(int i) {
        return new WalletFragmentInitParams[i];
    }
}
