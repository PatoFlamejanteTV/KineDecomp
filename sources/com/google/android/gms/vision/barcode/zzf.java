package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzf implements Parcelable.Creator<Barcode.DriverLicense> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.DriverLicense driverLicense, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, driverLicense.f2261a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, driverLicense.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, driverLicense.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, driverLicense.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, driverLicense.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, driverLicense.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, driverLicense.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, driverLicense.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, driverLicense.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, driverLicense.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, driverLicense.k, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, driverLicense.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, driverLicense.m, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, driverLicense.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, driverLicense.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.DriverLicense createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 11:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 12:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 13:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 14:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 15:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.DriverLicense(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.DriverLicense[] newArray(int i) {
        return new Barcode.DriverLicense[i];
    }
}
