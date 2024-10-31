package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<Device> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Device device, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, device.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, device.f2083a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, device.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, device.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, device.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Device createFromParcel(Parcel parcel) {
        byte b = 0;
        String str = null;
        int b2 = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    b = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b2) {
            throw new zza.C0032zza("Overread allowed size end=" + b2, parcel);
        }
        return new Device(i, str3, str2, str, b);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Device[] newArray(int i) {
        return new Device[i];
    }
}
