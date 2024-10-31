package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.bootstrap.Device;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ConnectRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConnectRequest connectRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) connectRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, connectRequest.f2084a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, connectRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, connectRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, connectRequest.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, connectRequest.i(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, connectRequest.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, connectRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, connectRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, connectRequest.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, connectRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        Device device = null;
        String str = null;
        String str2 = null;
        byte b2 = 0;
        long j = 0;
        String str3 = null;
        byte b3 = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Device.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 7:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
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
        return new ConnectRequest(i, device, str, str2, b2, j, str3, b3, iBinder, iBinder2, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectRequest[] newArray(int i) {
        return new ConnectRequest[i];
    }
}
