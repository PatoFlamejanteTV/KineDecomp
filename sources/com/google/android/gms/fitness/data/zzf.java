package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataSource> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataSource dataSource, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) dataSource.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, dataSource.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, dataSource.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, dataSource.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) dataSource.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) dataSource.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, dataSource.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSource createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataType.CREATOR);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Application.CREATOR);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
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
        return new DataSource(i2, dataType, str2, i, device, application, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataSource[] newArray(int i) {
        return new DataSource[i];
    }
}
