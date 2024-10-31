package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzas implements Parcelable.Creator<GetFdForAssetResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetFdForAssetResponse getFdForAssetResponse, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, getFdForAssetResponse.f2354a);
        zzb.a(parcel, 2, getFdForAssetResponse.b);
        zzb.a(parcel, 3, (Parcelable) getFdForAssetResponse.c, i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetFdForAssetResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetFdForAssetResponse(i2, i, parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetFdForAssetResponse[] newArray(int i) {
        return new GetFdForAssetResponse[i];
    }
}
