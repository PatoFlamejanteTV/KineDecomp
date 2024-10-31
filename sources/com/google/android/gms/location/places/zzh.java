package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PlacePhotoMetadataResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) placePhotoMetadataResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placePhotoMetadataResult.f1871a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) placePhotoMetadataResult.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadataResult createFromParcel(Parcel parcel) {
        DataHolder dataHolder;
        Status status;
        int i;
        DataHolder dataHolder2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i = i2;
                    dataHolder = dataHolder2;
                    status = status3;
                    break;
                case 2:
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    DataHolder dataHolder3 = dataHolder2;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    dataHolder = dataHolder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    dataHolder = dataHolder2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataHolder2 = dataHolder;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlacePhotoMetadataResult(i2, status2, dataHolder2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadataResult[] newArray(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
