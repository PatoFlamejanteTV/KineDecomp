package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<NearbyAlertFilter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 1, nearbyAlertFilter.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, nearbyAlertFilter.f1867a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, nearbyAlertFilter.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, nearbyAlertFilter.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyAlertFilter createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList<Integer> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 2:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.C(parcel, a2);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UserDataType.CREATOR);
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
        return new NearbyAlertFilter(i, arrayList3, arrayList2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NearbyAlertFilter[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}
