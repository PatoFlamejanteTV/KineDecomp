package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<LocationSettingsResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) locationSettingsResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationSettingsResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) locationSettingsResult.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationSettingsResult createFromParcel(Parcel parcel) {
        LocationSettingsStates locationSettingsStates;
        Status status;
        int i;
        LocationSettingsStates locationSettingsStates2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i = i2;
                    locationSettingsStates = locationSettingsStates2;
                    status = status3;
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LocationSettingsStates.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates2;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    locationSettingsStates = locationSettingsStates3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    locationSettingsStates = locationSettingsStates2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            locationSettingsStates2 = locationSettingsStates;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LocationSettingsResult(i2, status2, locationSettingsStates2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
