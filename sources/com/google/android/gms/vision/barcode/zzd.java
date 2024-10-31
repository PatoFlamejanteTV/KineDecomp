package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<Barcode.CalendarEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Barcode.CalendarEvent calendarEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, calendarEvent.f2259a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, calendarEvent.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, calendarEvent.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, calendarEvent.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, calendarEvent.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, calendarEvent.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) calendarEvent.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) calendarEvent.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarEvent createFromParcel(Parcel parcel) {
        Barcode.CalendarDateTime calendarDateTime = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        Barcode.CalendarDateTime calendarDateTime2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    calendarDateTime2 = (Barcode.CalendarDateTime) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.CalendarDateTime.CREATOR);
                    break;
                case 8:
                    calendarDateTime = (Barcode.CalendarDateTime) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.CalendarDateTime.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode.CalendarEvent(i, str5, str4, str3, str2, str, calendarDateTime2, calendarDateTime);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarEvent[] newArray(int i) {
        return new Barcode.CalendarEvent[i];
    }
}
