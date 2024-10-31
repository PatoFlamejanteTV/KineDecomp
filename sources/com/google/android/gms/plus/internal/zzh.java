package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PlusSession> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlusSession plusSession, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, plusSession.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, plusSession.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, plusSession.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, plusSession.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, plusSession.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, plusSession.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, plusSession.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, plusSession.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, plusSession.i(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) plusSession.j(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlusSession createFromParcel(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    strArr3 = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 3:
                    strArr2 = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 4:
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PlusCommonExtras.CREATOR);
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
        return new PlusSession(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlusSession[] newArray(int i) {
        return new PlusSession[i];
    }
}
