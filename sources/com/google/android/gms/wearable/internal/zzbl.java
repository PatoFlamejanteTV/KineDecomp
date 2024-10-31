package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzbl implements Parcelable.Creator<StorageInfoResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StorageInfoResponse storageInfoResponse, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, storageInfoResponse.f2364a);
        zzb.a(parcel, 2, storageInfoResponse.b);
        zzb.a(parcel, 3, storageInfoResponse.c);
        zzb.c(parcel, 4, storageInfoResponse.d, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StorageInfoResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        long j = 0;
        ArrayList arrayList = null;
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
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, PackageStorageInfo.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new StorageInfoResponse(i2, i, j, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StorageInfoResponse[] newArray(int i) {
        return new StorageInfoResponse[i];
    }
}
