package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes2.dex */
public class zzd implements Parcelable.Creator<FilterHolder> {
    public static void a(FilterHolder filterHolder, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) filterHolder.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, filterHolder.f1161a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) filterHolder.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) filterHolder.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) filterHolder.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) filterHolder.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) filterHolder.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) filterHolder.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) filterHolder.i, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) filterHolder.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FilterHolder createFromParcel(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FullTextSearchFilter.CREATOR);
                    break;
                case 9:
                    ownedByMeFilter = (OwnedByMeFilter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, OwnedByMeFilter.CREATOR);
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
        return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
