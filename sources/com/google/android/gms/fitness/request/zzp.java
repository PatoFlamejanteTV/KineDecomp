package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzp implements Parcelable.Creator<ListSubscriptionsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) listSubscriptionsRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, listSubscriptionsRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, listSubscriptionsRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListSubscriptionsRequest createFromParcel(Parcel parcel) {
        IBinder q;
        DataType dataType;
        int i;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        DataType dataType2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    DataType dataType3 = (DataType) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataType.CREATOR);
                    i = i2;
                    q = iBinder;
                    dataType = dataType3;
                    break;
                case 2:
                    q = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    dataType = dataType2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    IBinder iBinder2 = iBinder;
                    dataType = dataType2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    q = iBinder2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    q = iBinder;
                    dataType = dataType2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataType2 = dataType;
            iBinder = q;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ListSubscriptionsRequest(i2, dataType2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListSubscriptionsRequest[] newArray(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
