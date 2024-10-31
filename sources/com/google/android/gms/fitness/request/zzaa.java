package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzaa implements Parcelable.Creator<StartBleScanRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 1, startBleScanRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, startBleScanRequest.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, startBleScanRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, startBleScanRequest.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, startBleScanRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StartBleScanRequest createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        IBinder iBinder2 = null;
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DataType.CREATOR);
                    break;
                case 2:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
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
        return new StartBleScanRequest(i2, arrayList, iBinder2, i, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StartBleScanRequest[] newArray(int i) {
        return new StartBleScanRequest[i];
    }
}
