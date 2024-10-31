package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zza implements Parcelable.Creator<Query> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Query query, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, query.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) query.f1152a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, query.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) query.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 5, query.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, query.e);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 7, query.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, query.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Query createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        ArrayList<String> arrayList2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, SortOrder.CREATOR);
                    break;
                case 5:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveSpace.CREATOR);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
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
        return new Query(i, logicalFilter, str, sortOrder, arrayList2, z2, arrayList, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
