package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<Barcode> {
    public static void a(Barcode barcode, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, barcode.f2256a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, barcode.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, barcode.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, barcode.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, barcode.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable[]) barcode.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) barcode.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) barcode.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) barcode.i, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, (Parcelable) barcode.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) barcode.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable) barcode.l, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, (Parcelable) barcode.m, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, (Parcelable) barcode.n, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, (Parcelable) barcode.o, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Barcode createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        int i3 = 0;
        Point[] pointArr = null;
        Barcode.Email email = null;
        Barcode.Phone phone = null;
        Barcode.Sms sms = null;
        Barcode.WiFi wiFi = null;
        Barcode.UrlBookmark urlBookmark = null;
        Barcode.GeoPoint geoPoint = null;
        Barcode.CalendarEvent calendarEvent = null;
        Barcode.ContactInfo contactInfo = null;
        Barcode.DriverLicense driverLicense = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    pointArr = (Point[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Point.CREATOR);
                    break;
                case 7:
                    email = (Barcode.Email) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.Email.CREATOR);
                    break;
                case 8:
                    phone = (Barcode.Phone) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.Phone.CREATOR);
                    break;
                case 9:
                    sms = (Barcode.Sms) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.Sms.CREATOR);
                    break;
                case 10:
                    wiFi = (Barcode.WiFi) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.WiFi.CREATOR);
                    break;
                case 11:
                    urlBookmark = (Barcode.UrlBookmark) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.UrlBookmark.CREATOR);
                    break;
                case 12:
                    geoPoint = (Barcode.GeoPoint) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.GeoPoint.CREATOR);
                    break;
                case 13:
                    calendarEvent = (Barcode.CalendarEvent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.CalendarEvent.CREATOR);
                    break;
                case 14:
                    contactInfo = (Barcode.ContactInfo) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.ContactInfo.CREATOR);
                    break;
                case 15:
                    driverLicense = (Barcode.DriverLicense) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Barcode.DriverLicense.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Barcode(i, i2, str, str2, i3, pointArr, email, phone, sms, wiFi, urlBookmark, geoPoint, calendarEvent, contactInfo, driverLicense);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Barcode[] newArray(int i) {
        return new Barcode[i];
    }
}
