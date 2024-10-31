package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<StreetViewPanoramaLocation> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, streetViewPanoramaLocation.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable[]) streetViewPanoramaLocation.f1993a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) streetViewPanoramaLocation.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, streetViewPanoramaLocation.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String p;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng3 = latLng2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, StreetViewPanoramaLink.CREATOR);
                    p = str;
                    latLng = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    String str3 = str;
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    p = str3;
                    break;
                case 4:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
