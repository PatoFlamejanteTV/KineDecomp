package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<WalletObjectMessage> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, walletObjectMessage.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, walletObjectMessage.f2323a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, walletObjectMessage.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) walletObjectMessage.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) walletObjectMessage.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) walletObjectMessage.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage createFromParcel(Parcel parcel) {
        UriData uriData = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
        String str = null;
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData2 = (UriData) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UriData.CREATOR);
                    break;
                case 6:
                    uriData = (UriData) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new WalletObjectMessage(i, str2, str, timeInterval, uriData2, uriData);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage[] newArray(int i) {
        return new WalletObjectMessage[i];
    }
}
