package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzt implements Parcelable.Creator<PlacesParams> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlacesParams placesParams, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, placesParams.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placesParams.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, placesParams.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, placesParams.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, placesParams.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, placesParams.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, placesParams.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacesParams createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
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
        return new PlacesParams(i2, str5, str4, str3, str2, str, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlacesParams[] newArray(int i) {
        return new PlacesParams[i];
    }
}
