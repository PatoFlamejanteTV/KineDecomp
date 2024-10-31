package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<ReadRawResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ReadRawResult readRawResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) readRawResult.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, readRawResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, readRawResult.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReadRawResult createFromParcel(Parcel parcel) {
        ArrayList c;
        DataHolder dataHolder;
        int i;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        DataHolder dataHolder2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    i = i2;
                    c = arrayList;
                    dataHolder = dataHolder3;
                    break;
                case 2:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataHolder.CREATOR);
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    ArrayList arrayList2 = arrayList;
                    dataHolder = dataHolder2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = arrayList2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = arrayList;
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataHolder2 = dataHolder;
            arrayList = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ReadRawResult(i2, dataHolder2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ReadRawResult[] newArray(int i) {
        return new ReadRawResult[i];
    }
}
