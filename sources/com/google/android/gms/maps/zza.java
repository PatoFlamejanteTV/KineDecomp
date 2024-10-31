package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CameraPosition;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<GoogleMapOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, googleMapOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, googleMapOptions.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, googleMapOptions.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, googleMapOptions.m());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) googleMapOptions.n(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, googleMapOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, googleMapOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, googleMapOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, googleMapOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, googleMapOptions.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, googleMapOptions.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, googleMapOptions.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, googleMapOptions.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, googleMapOptions.l());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        byte b2 = -1;
        byte b3 = -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 3:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, CameraPosition.CREATOR);
                    break;
                case 6:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 7:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 8:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 9:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 10:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 11:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 12:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 13:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 14:
                    b11 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 15:
                    b12 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GoogleMapOptions(i, b2, b3, i2, cameraPosition, b4, b5, b6, b7, b8, b9, b10, b11, b12);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
