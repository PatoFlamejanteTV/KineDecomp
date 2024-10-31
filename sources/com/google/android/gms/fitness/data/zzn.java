package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzn implements Parcelable.Creator<RawDataPoint> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, rawDataPoint.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, rawDataPoint.f1228a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, rawDataPoint.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable[]) rawDataPoint.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, rawDataPoint.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, rawDataPoint.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, rawDataPoint.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, rawDataPoint.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    valueArr = (Value[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Value.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 7:
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
        return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
