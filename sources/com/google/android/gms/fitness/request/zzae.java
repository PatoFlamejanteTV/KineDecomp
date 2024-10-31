package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzae implements Parcelable.Creator<UnsubscribeRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) unsubscribeRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, unsubscribeRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) unsubscribeRequest.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, unsubscribeRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnsubscribeRequest createFromParcel(Parcel parcel) {
        IBinder q;
        DataSource dataSource;
        DataType dataType;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        DataSource dataSource2 = null;
        DataType dataType2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    DataSource dataSource3 = dataSource2;
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataType.CREATOR);
                    q = iBinder;
                    dataSource = dataSource3;
                    break;
                case 2:
                    dataType = dataType2;
                    i = i2;
                    IBinder iBinder2 = iBinder;
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataSource.CREATOR);
                    q = iBinder2;
                    break;
                case 3:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    dataSource = dataSource2;
                    dataType = dataType2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder3 = iBinder;
                    dataSource = dataSource2;
                    dataType = dataType2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    dataSource = dataSource2;
                    dataType = dataType2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataType2 = dataType;
            dataSource2 = dataSource;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new UnsubscribeRequest(i2, dataType2, dataSource2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UnsubscribeRequest[] newArray(int i) {
        return new UnsubscribeRequest[i];
    }
}
