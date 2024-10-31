package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzs implements Parcelable.Creator<SensorRegistrationRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) sensorRegistrationRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sensorRegistrationRequest.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) sensorRegistrationRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, sensorRegistrationRequest.l(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, sensorRegistrationRequest.f1261a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, sensorRegistrationRequest.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, sensorRegistrationRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, sensorRegistrationRequest.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) sensorRegistrationRequest.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, sensorRegistrationRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, sensorRegistrationRequest.h());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 11, sensorRegistrationRequest.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, sensorRegistrationRequest.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, sensorRegistrationRequest.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        ArrayList arrayList = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 7:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 10:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 11:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 13:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
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
        return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, arrayList, j4, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest[] newArray(int i) {
        return new SensorRegistrationRequest[i];
    }
}
