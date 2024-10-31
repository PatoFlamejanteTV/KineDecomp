package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<PlaceFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlaceFilter placeFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, placeFilter.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placeFilter.f1869a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, placeFilter.c);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, placeFilter.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 6, placeFilter.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList<String> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UserDataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
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
        return new PlaceFilter(i, arrayList3, z, arrayList2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceFilter[] newArray(int i) {
        return new PlaceFilter[i];
    }
}
