package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class LocationAvailabilityCreator implements Parcelable.Creator<LocationAvailability> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, locationAvailability.f1843a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationAvailability.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, locationAvailability.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, locationAvailability.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, locationAvailability.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationAvailability createFromParcel(Parcel parcel) {
        int i = 1;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        int i3 = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LocationAvailability(i2, i3, i4, i, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
