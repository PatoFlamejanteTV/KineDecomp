package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<RawBucket> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RawBucket rawBucket, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, rawBucket.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, rawBucket.f1227a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, rawBucket.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) rawBucket.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, rawBucket.e);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, rawBucket.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, rawBucket.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, rawBucket.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RawBucket createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList arrayList = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    session = (Session) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Session.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new RawBucket(i3, j2, j, session, i2, arrayList, i, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}
