package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzv implements Parcelable.Creator<SessionReadRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, sessionReadRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, sessionReadRequest.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, sessionReadRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, sessionReadRequest.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, sessionReadRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, sessionReadRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 6, sessionReadRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, sessionReadRequest.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, sessionReadRequest.f());
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 9, sessionReadRequest.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, sessionReadRequest.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionReadRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        ArrayList<String> arrayList3 = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataSource.CREATOR);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 10:
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
        return new SessionReadRequest(i, str, str2, j, j2, arrayList, arrayList2, z, z2, arrayList3, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionReadRequest[] newArray(int i) {
        return new SessionReadRequest[i];
    }
}
