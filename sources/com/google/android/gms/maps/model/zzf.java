package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<MarkerOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, markerOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) markerOptions.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, markerOptions.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, markerOptions.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, markerOptions.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, markerOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, markerOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, markerOptions.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, markerOptions.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, markerOptions.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, markerOptions.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, markerOptions.l());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, markerOptions.m());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, markerOptions.n());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MarkerOptions createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 7:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 11:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 12:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 13:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 14:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
