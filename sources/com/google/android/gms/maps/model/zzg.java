package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<PointOfInterest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, pointOfInterest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) pointOfInterest.f1986a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, pointOfInterest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, pointOfInterest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointOfInterest createFromParcel(Parcel parcel) {
        String p;
        String str;
        LatLng latLng;
        int i;
        String str2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        String str3 = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str4 = str2;
                    str = str3;
                    latLng = latLng2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str4;
                    break;
                case 2:
                    i = i2;
                    String str5 = str3;
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    p = str2;
                    str = str5;
                    break;
                case 3:
                    latLng = latLng2;
                    i = i2;
                    String str6 = str2;
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    p = str6;
                    break;
                case 4:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str2;
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng2 = latLng;
            str3 = str;
            str2 = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PointOfInterest(i2, latLng2, str3, str2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointOfInterest[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
