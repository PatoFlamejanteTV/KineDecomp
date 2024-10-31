package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<RegisterSectionInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, registerSectionInfo.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, registerSectionInfo.f764a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, registerSectionInfo.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, registerSectionInfo.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, registerSectionInfo.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, registerSectionInfo.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, registerSectionInfo.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable[]) registerSectionInfo.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, registerSectionInfo.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, registerSectionInfo.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegisterSectionInfo createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    featureArr = (Feature[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Feature.CREATOR);
                    break;
                case 8:
                    iArr = com.google.android.gms.common.internal.safeparcel.zza.v(parcel, a2);
                    break;
                case 11:
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
        return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegisterSectionInfo[] newArray(int i) {
        return new RegisterSectionInfo[i];
    }
}
