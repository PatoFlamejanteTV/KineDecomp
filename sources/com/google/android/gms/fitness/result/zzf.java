package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataStatsResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataStatsResult dataStatsResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataStatsResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataStatsResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, dataStatsResult.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataStatsResult createFromParcel(Parcel parcel) {
        ArrayList c;
        Status status;
        int i;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i = i2;
                    c = arrayList;
                    status = status3;
                    break;
                case 2:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSourceStatsResult.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    ArrayList arrayList2 = arrayList;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = arrayList2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = arrayList;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DataStatsResult(i2, status2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataStatsResult[] newArray(int i) {
        return new DataStatsResult[i];
    }
}
