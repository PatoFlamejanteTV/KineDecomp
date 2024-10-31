package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<GetBuyFlowInitializationTokenRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getBuyFlowInitializationTokenRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, getBuyFlowInitializationTokenRequest.f2298a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getBuyFlowInitializationTokenRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetBuyFlowInitializationTokenRequest createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        byte[] bArr2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    bArr2 = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 3:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetBuyFlowInitializationTokenRequest(i, bArr2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetBuyFlowInitializationTokenRequest[] newArray(int i) {
        return new GetBuyFlowInitializationTokenRequest[i];
    }
}
