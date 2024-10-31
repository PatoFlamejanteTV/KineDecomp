package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzt implements Parcelable.Creator<SensorUnregistrationRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, sensorUnregistrationRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sensorUnregistrationRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) sensorUnregistrationRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, sensorUnregistrationRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SensorUnregistrationRequest createFromParcel(Parcel parcel) {
        IBinder q;
        PendingIntent pendingIntent;
        IBinder iBinder;
        int i;
        IBinder iBinder2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        PendingIntent pendingIntent2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent2;
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    q = iBinder2;
                    pendingIntent = pendingIntent3;
                    break;
                case 2:
                    iBinder = iBinder3;
                    i = i2;
                    IBinder iBinder4 = iBinder2;
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    q = iBinder4;
                    break;
                case 3:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    pendingIntent = pendingIntent2;
                    iBinder = iBinder3;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder5 = iBinder2;
                    pendingIntent = pendingIntent2;
                    iBinder = iBinder3;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder5;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder2;
                    pendingIntent = pendingIntent2;
                    iBinder = iBinder3;
                    i = i2;
                    break;
            }
            i2 = i;
            iBinder3 = iBinder;
            pendingIntent2 = pendingIntent;
            iBinder2 = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SensorUnregistrationRequest(i2, iBinder3, pendingIntent2, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SensorUnregistrationRequest[] newArray(int i) {
        return new SensorUnregistrationRequest[i];
    }
}
