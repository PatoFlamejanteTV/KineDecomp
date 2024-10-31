package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes2.dex */
public class zza implements Parcelable.Creator<ComparisonFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, comparisonFilter.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) comparisonFilter.f1158a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) comparisonFilter.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        Operator operator;
        int i;
        MetadataBundle metadataBundle2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Operator.CREATOR);
                    i = i2;
                    metadataBundle = metadataBundle2;
                    operator = operator3;
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MetadataBundle.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    operator = operator2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    metadataBundle = metadataBundle3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    metadataBundle = metadataBundle2;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ComparisonFilter(i2, operator2, metadataBundle2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }
}
