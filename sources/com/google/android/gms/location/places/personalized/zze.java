package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<PlaceUserData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlaceUserData placeUserData, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, placeUserData.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placeUserData.f1901a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, placeUserData.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, placeUserData.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 6, placeUserData.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 7, placeUserData.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceUserData createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, TestDataImpl.CREATOR);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, PlaceAlias.CREATOR);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, HereContent.CREATOR);
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
        return new PlaceUserData(i, str2, str, arrayList3, arrayList2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceUserData[] newArray(int i) {
        return new PlaceUserData[i];
    }
}
