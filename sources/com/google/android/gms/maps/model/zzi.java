package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<PolylineOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, polylineOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, polylineOptions.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, polylineOptions.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, polylineOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, polylineOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, polylineOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, polylineOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
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
        return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
