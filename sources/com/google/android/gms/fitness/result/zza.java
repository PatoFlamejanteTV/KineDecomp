package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<BleDevicesResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 1, bleDevicesResult.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, bleDevicesResult.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) bleDevicesResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BleDevicesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
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
        return new BleDevicesResult(i, arrayList, status);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BleDevicesResult[] newArray(int i) {
        return new BleDevicesResult[i];
    }
}
