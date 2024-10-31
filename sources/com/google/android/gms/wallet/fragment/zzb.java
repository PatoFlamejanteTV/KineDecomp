package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<WalletFragmentOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, walletFragmentOptions.f2312a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, walletFragmentOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, walletFragmentOptions.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) walletFragmentOptions.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, walletFragmentOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentOptions createFromParcel(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
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
        return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentOptions[] newArray(int i) {
        return new WalletFragmentOptions[i];
    }
}
