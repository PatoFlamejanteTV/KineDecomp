package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataReadRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 1, dataReadRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, dataReadRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataReadRequest.l());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, dataReadRequest.k());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, dataReadRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 6, dataReadRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, dataReadRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, dataReadRequest.m());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) dataReadRequest.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, dataReadRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, dataReadRequest.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, dataReadRequest.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, dataReadRequest.n(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 16, dataReadRequest.o(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataReadRequest.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataReadRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        ArrayList arrayList5 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case 2:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSource.CREATOR);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case 6:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 9:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 12:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 13:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 14:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 16:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, Device.CREATOR);
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
        return new DataReadRequest(i, arrayList, arrayList2, j, j2, arrayList3, arrayList4, i2, j3, dataSource, i3, z, z2, iBinder, arrayList5);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataReadRequest[] newArray(int i) {
        return new DataReadRequest[i];
    }
}
