package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<FusedLocationProviderResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FusedLocationProviderResult fusedLocationProviderResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) fusedLocationProviderResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, fusedLocationProviderResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FusedLocationProviderResult createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
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
        return new FusedLocationProviderResult(i, status);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FusedLocationProviderResult[] newArray(int i) {
        return new FusedLocationProviderResult[i];
    }
}
