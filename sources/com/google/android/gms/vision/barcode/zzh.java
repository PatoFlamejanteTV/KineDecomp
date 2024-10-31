package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<Barcode.GeoPoint> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.GeoPoint geoPoint, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, geoPoint.f2263a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, geoPoint.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, geoPoint.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.GeoPoint createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 3:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.GeoPoint(i, d2, d);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.GeoPoint[] newArray(int i) {
        return new Barcode.GeoPoint[i];
    }
}
