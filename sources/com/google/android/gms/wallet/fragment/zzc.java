package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<WalletFragmentStyle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, walletFragmentStyle.f2313a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, walletFragmentStyle.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, walletFragmentStyle.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentStyle createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
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
        return new WalletFragmentStyle(i2, bundle, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletFragmentStyle[] newArray(int i) {
        return new WalletFragmentStyle[i];
    }
}
