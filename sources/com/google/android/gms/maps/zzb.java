package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<StreetViewPanoramaOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, streetViewPanoramaOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) streetViewPanoramaOptions.g(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, streetViewPanoramaOptions.j(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) streetViewPanoramaOptions.h(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, streetViewPanoramaOptions.i(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, streetViewPanoramaOptions.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, streetViewPanoramaOptions.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, streetViewPanoramaOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, streetViewPanoramaOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, streetViewPanoramaOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = 0;
        int b2 = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 5:
                    num = com.google.android.gms.common.internal.safeparcel.zza.h(parcel, a2);
                    break;
                case 6:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 7:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 8:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 9:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 10:
                    b = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b2) {
            throw new zza.C0032zza("Overread allowed size end=" + b2, parcel);
        }
        return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b6, b5, b4, b3, b);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
