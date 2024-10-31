package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<DataSourceQueryParams> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataSourceQueryParams.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataSourceQueryParams.f1248a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, dataSourceQueryParams.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataSourceQueryParams.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataSourceQueryParams.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, dataSourceQueryParams.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, dataSourceQueryParams.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSourceQueryParams createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DataSourceQueryParams(i3, dataSource, j3, j2, j, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSourceQueryParams[] newArray(int i) {
        return new DataSourceQueryParams[i];
    }
}
