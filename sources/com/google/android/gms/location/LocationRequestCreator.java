package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class LocationRequestCreator implements Parcelable.Creator<LocationRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationRequest locationRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, locationRequest.f1844a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, locationRequest.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, locationRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, locationRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, locationRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, locationRequest.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, locationRequest.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, locationRequest.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 6:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 8:
                    j4 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
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
        return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
