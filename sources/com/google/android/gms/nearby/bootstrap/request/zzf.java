package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.bootstrap.Device;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<SendDataRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sendDataRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sendDataRequest.f2089a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, sendDataRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, sendDataRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SendDataRequest createFromParcel(Parcel parcel) {
        IBinder q;
        byte[] bArr;
        Device device;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        byte[] bArr2 = null;
        Device device2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    byte[] bArr3 = bArr2;
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Device.CREATOR);
                    q = iBinder;
                    bArr = bArr3;
                    break;
                case 2:
                    device = device2;
                    i = i2;
                    IBinder iBinder2 = iBinder;
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    q = iBinder2;
                    break;
                case 3:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder3 = iBinder;
                    bArr = bArr2;
                    device = device2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            bArr2 = bArr;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SendDataRequest(i2, device2, bArr2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SendDataRequest[] newArray(int i) {
        return new SendDataRequest[i];
    }
}
