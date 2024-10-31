package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzj implements Parcelable.Creator<UsageInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UsageInfo usageInfo, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) usageInfo.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, usageInfo.f766a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, usageInfo.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, usageInfo.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, usageInfo.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) usageInfo.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, usageInfo.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, usageInfo.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, usageInfo.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UsageInfo createFromParcel(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    documentId = (DocumentId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DocumentId.CREATOR);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    documentContents = (DocumentContents) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UsageInfo[] newArray(int i) {
        return new UsageInfo[i];
    }
}
