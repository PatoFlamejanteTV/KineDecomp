package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<DailyTotalResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dailyTotalResult.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) dailyTotalResult.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DailyTotalResult createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Status status;
        int i;
        DataSet dataSet2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i = i2;
                    dataSet = dataSet2;
                    status = status3;
                    break;
                case 2:
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSet.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    DataSet dataSet3 = dataSet2;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    dataSet = dataSet3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    dataSet = dataSet2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DailyTotalResult(i2, status2, dataSet2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DailyTotalResult[] newArray(int i) {
        return new DailyTotalResult[i];
    }
}
