package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataDeleteRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, dataDeleteRequest.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataDeleteRequest.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, dataDeleteRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, dataDeleteRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, dataDeleteRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, dataDeleteRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, dataDeleteRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, dataDeleteRequest.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, dataDeleteRequest.i(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataDeleteRequest createFromParcel(Parcel parcel) {
        long j = 0;
        boolean z = false;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSource.CREATOR);
                    break;
                case 4:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, Session.CREATOR);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
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
        return new DataDeleteRequest(i, j2, j, arrayList3, arrayList2, arrayList, z2, z, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataDeleteRequest[] newArray(int i) {
        return new DataDeleteRequest[i];
    }
}
