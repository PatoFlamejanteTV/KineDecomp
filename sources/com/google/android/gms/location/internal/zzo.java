package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzo implements Parcelable.Creator<ParcelableGeofence> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, parcelableGeofence.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, parcelableGeofence.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, parcelableGeofence.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, parcelableGeofence.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, parcelableGeofence.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, parcelableGeofence.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, parcelableGeofence.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, parcelableGeofence.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, parcelableGeofence.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, parcelableGeofence.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableGeofence createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    s = com.google.android.gms.common.internal.safeparcel.zza.f(parcel, a2);
                    break;
                case 4:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 5:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 6:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 9:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
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
        return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableGeofence[] newArray(int i) {
        return new ParcelableGeofence[i];
    }
}
