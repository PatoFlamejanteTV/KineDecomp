package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzn implements Parcelable.Creator<LocationRequestUpdateData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, locationRequestUpdateData.f1854a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, locationRequestUpdateData.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) locationRequestUpdateData.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, locationRequestUpdateData.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) locationRequestUpdateData.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, locationRequestUpdateData.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, locationRequestUpdateData.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
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
        return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
