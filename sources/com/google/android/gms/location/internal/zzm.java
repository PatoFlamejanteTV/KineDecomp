package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.LocationRequest;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.List;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<LocationRequestInternal> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) locationRequestInternal.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationRequestInternal.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, locationRequestInternal.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, locationRequestInternal.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, locationRequestInternal.e);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, locationRequestInternal.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, locationRequestInternal.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, locationRequestInternal.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequestInternal createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        List<ClientIdentity> list = LocationRequestInternal.f1853a;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    locationRequest = (LocationRequest) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LocationRequest.CREATOR);
                    break;
                case 2:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
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
        return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequestInternal[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}
