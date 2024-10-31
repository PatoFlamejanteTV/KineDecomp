package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<GroundOverlayOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, groundOverlayOptions.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, groundOverlayOptions.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) groundOverlayOptions.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, groundOverlayOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, groundOverlayOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) groundOverlayOptions.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, groundOverlayOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, groundOverlayOptions.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, groundOverlayOptions.l());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, groundOverlayOptions.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, groundOverlayOptions.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, groundOverlayOptions.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 4:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 5:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 8:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 9:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 11:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 12:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
