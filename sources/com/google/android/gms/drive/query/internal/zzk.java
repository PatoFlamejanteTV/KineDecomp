package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzk implements Parcelable.Creator<LogicalFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, logicalFilter.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) logicalFilter.f1165a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, logicalFilter.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LogicalFilter createFromParcel(Parcel parcel) {
        ArrayList c;
        Operator operator;
        int i;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Operator.CREATOR);
                    i = i2;
                    c = arrayList;
                    operator = operator3;
                    break;
                case 2:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, FilterHolder.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    ArrayList arrayList2 = arrayList;
                    operator = operator2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = arrayList2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = arrayList;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            arrayList = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LogicalFilter(i2, operator2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }
}
