package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataPoint> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataPoint dataPoint, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataPoint.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataPoint.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataPoint.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataPoint.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable[]) dataPoint.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) dataPoint.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, dataPoint.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, dataPoint.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataPoint createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    valueArr = (Value[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 8:
                    j4 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
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
        return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
