package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<PlaceLikelihoodEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) placeLikelihoodEntity.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, placeLikelihoodEntity.f1884a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, placeLikelihoodEntity.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        float l;
        PlaceImpl placeImpl;
        int i;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        PlaceImpl placeImpl2 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    PlaceImpl placeImpl3 = (PlaceImpl) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PlaceImpl.CREATOR);
                    i = i2;
                    l = f;
                    placeImpl = placeImpl3;
                    break;
                case 2:
                    l = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    float f2 = f;
                    placeImpl = placeImpl2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    l = f2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    l = f;
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
            }
            i2 = i;
            placeImpl2 = placeImpl;
            f = l;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlaceLikelihoodEntity(i2, placeImpl2, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
