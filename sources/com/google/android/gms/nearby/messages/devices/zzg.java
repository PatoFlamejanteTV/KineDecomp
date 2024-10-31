package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<NearbyDeviceFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(NearbyDeviceFilter nearbyDeviceFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, nearbyDeviceFilter.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, nearbyDeviceFilter.f2106a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, nearbyDeviceFilter.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyDeviceFilter createFromParcel(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    bArr = zza.s(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new NearbyDeviceFilter(i2, i, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyDeviceFilter[] newArray(int i) {
        return new NearbyDeviceFilter[i];
    }
}
