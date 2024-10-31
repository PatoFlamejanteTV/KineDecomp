package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DocumentSection> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DocumentSection documentSection, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, documentSection.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, documentSection.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) documentSection.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, documentSection.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, documentSection.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DocumentSection createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
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
        return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DocumentSection[] newArray(int i) {
        return new DocumentSection[i];
    }
}
