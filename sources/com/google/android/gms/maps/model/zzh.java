package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PolygonOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, polygonOptions.a());
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, polygonOptions.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.d(parcel, 3, polygonOptions.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, polygonOptions.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, polygonOptions.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, polygonOptions.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, polygonOptions.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, polygonOptions.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, polygonOptions.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
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
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LatLng.CREATOR);
                    break;
                case 3:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, arrayList2, getClass().getClassLoader());
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
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
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
        return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
