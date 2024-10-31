package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<NearbyAlertRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, nearbyAlertRequest.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, nearbyAlertRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, nearbyAlertRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) nearbyAlertRequest.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) nearbyAlertRequest.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, nearbyAlertRequest.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, nearbyAlertRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyAlertRequest createFromParcel(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = -1;
        boolean z = false;
        PlaceFilter placeFilter = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, NearbyAlertFilter.CREATOR);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new NearbyAlertRequest(i4, i3, i2, placeFilter, nearbyAlertFilter, z, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyAlertRequest[] newArray(int i) {
        return new NearbyAlertRequest[i];
    }
}
