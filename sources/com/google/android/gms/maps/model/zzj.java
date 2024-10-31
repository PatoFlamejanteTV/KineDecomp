package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzj implements Parcelable.Creator<StreetViewPanoramaCamera> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, streetViewPanoramaCamera.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, streetViewPanoramaCamera.f1991a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, streetViewPanoramaCamera.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, streetViewPanoramaCamera.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
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
        return new StreetViewPanoramaCamera(i, f2, f3, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StreetViewPanoramaCamera[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
