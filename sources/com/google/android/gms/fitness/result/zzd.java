package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataSourceStatsResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataSourceStatsResult.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataSourceStatsResult.f1285a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, dataSourceStatsResult.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataSourceStatsResult.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataSourceStatsResult.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, dataSourceStatsResult.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSourceStatsResult createFromParcel(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
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
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
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
        return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSourceStatsResult[] newArray(int i) {
        return new DataSourceStatsResult[i];
    }
}
