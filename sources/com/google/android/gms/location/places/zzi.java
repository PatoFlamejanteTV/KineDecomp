package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<PlacePhotoResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) placePhotoResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placePhotoResult.f1872a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) placePhotoResult.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacePhotoResult createFromParcel(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter;
        Status status;
        int i;
        BitmapTeleporter bitmapTeleporter2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i = i2;
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status3;
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, BitmapTeleporter.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    BitmapTeleporter bitmapTeleporter3 = bitmapTeleporter2;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    bitmapTeleporter = bitmapTeleporter3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            bitmapTeleporter2 = bitmapTeleporter;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlacePhotoResult(i2, status2, bitmapTeleporter2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
