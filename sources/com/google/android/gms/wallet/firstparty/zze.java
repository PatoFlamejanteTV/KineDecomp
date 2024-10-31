package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<GetInstrumentsResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getInstrumentsResponse.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, getInstrumentsResponse.f2301a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getInstrumentsResponse.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetInstrumentsResponse createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 3:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.t(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetInstrumentsResponse(i, strArr, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetInstrumentsResponse[] newArray(int i) {
        return new GetInstrumentsResponse[i];
    }
}
