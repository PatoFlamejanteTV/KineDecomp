package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<ClaimBleDeviceRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ClaimBleDeviceRequest claimBleDeviceRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, claimBleDeviceRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, claimBleDeviceRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) claimBleDeviceRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, claimBleDeviceRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClaimBleDeviceRequest createFromParcel(Parcel parcel) {
        IBinder q;
        BleDevice bleDevice;
        String str;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        BleDevice bleDevice2 = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    BleDevice bleDevice3 = bleDevice2;
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    q = iBinder;
                    bleDevice = bleDevice3;
                    break;
                case 2:
                    str = str2;
                    i = i2;
                    IBinder iBinder2 = iBinder;
                    bleDevice = (BleDevice) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, BleDevice.CREATOR);
                    q = iBinder2;
                    break;
                case 3:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    bleDevice = bleDevice2;
                    str = str2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder3 = iBinder;
                    bleDevice = bleDevice2;
                    str = str2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    bleDevice = bleDevice2;
                    str = str2;
                    i = i2;
                    break;
            }
            i2 = i;
            str2 = str;
            bleDevice2 = bleDevice;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ClaimBleDeviceRequest(i2, str2, bleDevice2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClaimBleDeviceRequest[] newArray(int i) {
        return new ClaimBleDeviceRequest[i];
    }
}
