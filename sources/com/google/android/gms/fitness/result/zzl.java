package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<SyncInfoResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) syncInfoResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, syncInfoResult.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, syncInfoResult.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SyncInfoResult createFromParcel(Parcel parcel) {
        long i;
        Status status;
        int i2;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i3 = 0;
        Status status2 = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    long j2 = j;
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    i2 = i3;
                    i = j2;
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    status = status2;
                    i2 = i3;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    long j3 = j;
                    status = status2;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    i = j3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    i = j;
                    status = status2;
                    i2 = i3;
                    break;
            }
            status2 = status;
            i3 = i2;
            j = i;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SyncInfoResult(i3, status2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SyncInfoResult[] newArray(int i) {
        return new SyncInfoResult[i];
    }
}
