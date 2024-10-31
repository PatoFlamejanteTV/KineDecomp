package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<CircleOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, circleOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) circleOptions.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, circleOptions.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, circleOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, circleOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, circleOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, circleOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, circleOptions.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
