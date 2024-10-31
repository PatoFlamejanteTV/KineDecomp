package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<LocationSettingsStates> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, locationSettingsStates.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationSettingsStates.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, locationSettingsStates.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, locationSettingsStates.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, locationSettingsStates.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, locationSettingsStates.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, locationSettingsStates.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, locationSettingsStates.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationSettingsStates createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    z7 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 2:
                    z6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
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
        return new LocationSettingsStates(i, z7, z6, z5, z4, z3, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationSettingsStates[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
