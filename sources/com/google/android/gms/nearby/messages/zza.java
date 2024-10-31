package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<Message> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Message message, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, message.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, message.f2095a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, message.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, message.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable[]) message.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Message createFromParcel(Parcel parcel) {
        NearbyDevice[] nearbyDeviceArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    nearbyDeviceArr = (NearbyDevice[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, NearbyDevice.CREATOR);
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
        return new Message(i, bArr, str2, str, nearbyDeviceArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Message[] newArray(int i) {
        return new Message[i];
    }
}
