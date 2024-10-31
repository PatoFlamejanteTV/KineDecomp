package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<Barcode.CalendarDateTime> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.CalendarDateTime calendarDateTime, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, calendarDateTime.f2258a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, calendarDateTime.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, calendarDateTime.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, calendarDateTime.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, calendarDateTime.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, calendarDateTime.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, calendarDateTime.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, calendarDateTime.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, calendarDateTime.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarDateTime createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i7 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.CalendarDateTime(i7, i6, i5, i4, i3, i2, i, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarDateTime[] newArray(int i) {
        return new Barcode.CalendarDateTime[i];
    }
}
