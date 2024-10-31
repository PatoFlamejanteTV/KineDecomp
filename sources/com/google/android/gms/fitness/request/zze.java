package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<DataInsertRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataInsertRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataInsertRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, dataInsertRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataInsertRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        boolean c;
        IBinder iBinder;
        DataSet dataSet;
        int i;
        IBinder iBinder2 = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataSet dataSet2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    IBinder iBinder3 = iBinder2;
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSet.CREATOR);
                    c = z;
                    iBinder = iBinder3;
                    break;
                case 2:
                    dataSet = dataSet2;
                    i = i2;
                    boolean z2 = z;
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    c = z2;
                    break;
                case 4:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    iBinder = iBinder2;
                    dataSet = dataSet2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    boolean z3 = z;
                    iBinder = iBinder2;
                    dataSet = dataSet2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = z3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = z;
                    iBinder = iBinder2;
                    dataSet = dataSet2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataSet2 = dataSet;
            iBinder2 = iBinder;
            z = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DataInsertRequest(i2, dataSet2, iBinder2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
