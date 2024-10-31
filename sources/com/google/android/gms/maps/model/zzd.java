package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<LatLngBounds> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, latLngBounds.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) latLngBounds.f1982a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) latLngBounds.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    latLng = latLng5;
                    break;
                case 2:
                    LatLng latLng6 = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    i = i2;
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LatLngBounds(i2, latLng4, latLng3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
