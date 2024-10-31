package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzm implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, streetViewPanoramaOrientation.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, streetViewPanoramaOrientation.f1994a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, streetViewPanoramaOrientation.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaOrientation(i, f2, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaOrientation[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
