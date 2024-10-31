package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<DataReadResult> {
    public static void a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.d(parcel, 1, dataReadResult.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataReadResult.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) dataReadResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.d(parcel, 3, dataReadResult.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, dataReadResult.c());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 6, dataReadResult.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 7, dataReadResult.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DataReadResult createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, arrayList2, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    break;
                case 3:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, arrayList3, getClass().getClassLoader());
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSource.CREATOR);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DataReadResult(i2, arrayList2, status, arrayList3, i, arrayList4, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DataReadResult[] newArray(int i) {
        return new DataReadResult[i];
    }
}
