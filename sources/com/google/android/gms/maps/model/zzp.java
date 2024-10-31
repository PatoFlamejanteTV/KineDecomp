package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzp implements Parcelable.Creator<VisibleRegion> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, visibleRegion.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) visibleRegion.f1999a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) visibleRegion.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) visibleRegion.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) visibleRegion.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) visibleRegion.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    latLng4 = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLngBounds.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
