package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzk implements Parcelable.Creator<PlaceRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlaceRequest placeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placeRequest.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) placeRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, placeRequest.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, placeRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, placeRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        PlaceFilter placeFilter = null;
        long j = PlaceRequest.f1874a;
        int i2 = 102;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 2:
                    placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PlaceFilter.CREATOR);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
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
        return new PlaceRequest(i, placeFilter, j, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceRequest[] newArray(int i) {
        return new PlaceRequest[i];
    }
}
