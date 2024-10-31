package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.bootstrap.Device;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DisconnectRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) disconnectRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, disconnectRequest.f2087a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, disconnectRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        IBinder q;
        Device device;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Device device2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Device device3 = (Device) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Device.CREATOR);
                    i = i2;
                    q = iBinder;
                    device = device3;
                    break;
                case 2:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    device = device2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder2 = iBinder;
                    device = device2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DisconnectRequest(i2, device2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
