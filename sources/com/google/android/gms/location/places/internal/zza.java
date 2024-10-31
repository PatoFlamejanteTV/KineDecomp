package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, autocompletePredictionEntity.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, autocompletePredictionEntity.f1880a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, autocompletePredictionEntity.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, autocompletePredictionEntity.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, autocompletePredictionEntity.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, autocompletePredictionEntity.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, autocompletePredictionEntity.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 7, autocompletePredictionEntity.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, autocompletePredictionEntity.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 9, autocompletePredictionEntity.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        ArrayList arrayList2 = null;
        String str2 = null;
        ArrayList arrayList3 = null;
        String str3 = null;
        ArrayList<Integer> arrayList4 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case 4:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AutocompletePredictionEntity(i2, str4, arrayList4, i, str3, arrayList3, str2, arrayList2, str, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
