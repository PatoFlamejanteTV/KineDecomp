package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<CameraPosition> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, cameraPosition.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) cameraPosition.f1973a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, cameraPosition.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, cameraPosition.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, cameraPosition.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 5:
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
        return new CameraPosition(i, latLng, f3, f2, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
