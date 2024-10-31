package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class Barcode implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f2256a;
    public int b;
    public String c;
    public String d;
    public int e;
    public Point[] f;
    public Email g;
    public Phone h;
    public Sms i;
    public WiFi j;
    public UrlBookmark k;
    public GeoPoint l;
    public CalendarEvent m;
    public ContactInfo n;
    public DriverLicense o;

    /* loaded from: classes.dex */
    public static class Address implements SafeParcelable {
        public static final zza CREATOR = new zza();

        /* renamed from: a, reason: collision with root package name */
        final int f2257a;
        public int b;
        public String[] c;

        public Address() {
            this.f2257a = 1;
        }

        public Address(int i, int i2, String[] strArr) {
            this.f2257a = i;
            this.b = i2;
            this.c = strArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zza zzaVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zza zzaVar = CREATOR;
            zza.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class CalendarDateTime implements SafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: a, reason: collision with root package name */
        final int f2258a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public String i;

        public CalendarDateTime() {
            this.f2258a = 1;
        }

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, String str) {
            this.f2258a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = z;
            this.i = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class CalendarEvent implements SafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: a, reason: collision with root package name */
        final int f2259a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public CalendarDateTime g;
        public CalendarDateTime h;

        public CalendarEvent() {
            this.f2259a = 1;
        }

        public CalendarEvent(int i, String str, String str2, String str3, String str4, String str5, CalendarDateTime calendarDateTime, CalendarDateTime calendarDateTime2) {
            this.f2259a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = calendarDateTime;
            this.h = calendarDateTime2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzd zzdVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzd zzdVar = CREATOR;
            zzd.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class ContactInfo implements SafeParcelable {
        public static final zze CREATOR = new zze();

        /* renamed from: a, reason: collision with root package name */
        final int f2260a;
        public PersonName b;
        public String c;
        public String d;
        public Phone[] e;
        public Email[] f;
        public String[] g;
        public Address[] h;

        public ContactInfo() {
            this.f2260a = 1;
        }

        public ContactInfo(int i, PersonName personName, String str, String str2, Phone[] phoneArr, Email[] emailArr, String[] strArr, Address[] addressArr) {
            this.f2260a = i;
            this.b = personName;
            this.c = str;
            this.d = str2;
            this.e = phoneArr;
            this.f = emailArr;
            this.g = strArr;
            this.h = addressArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zze zzeVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zze zzeVar = CREATOR;
            zze.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class DriverLicense implements SafeParcelable {
        public static final zzf CREATOR = new zzf();

        /* renamed from: a, reason: collision with root package name */
        final int f2261a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;

        public DriverLicense() {
            this.f2261a = 1;
        }

        public DriverLicense(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.f2261a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            this.k = str10;
            this.l = str11;
            this.m = str12;
            this.n = str13;
            this.o = str14;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzf zzfVar = CREATOR;
            zzf.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class Email implements SafeParcelable {
        public static final zzg CREATOR = new zzg();

        /* renamed from: a, reason: collision with root package name */
        final int f2262a;
        public int b;
        public String c;
        public String d;
        public String e;

        public Email() {
            this.f2262a = 1;
        }

        public Email(int i, int i2, String str, String str2, String str3) {
            this.f2262a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzg zzgVar = CREATOR;
            zzg.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class GeoPoint implements SafeParcelable {
        public static final zzh CREATOR = new zzh();

        /* renamed from: a, reason: collision with root package name */
        final int f2263a;
        public double b;
        public double c;

        public GeoPoint() {
            this.f2263a = 1;
        }

        public GeoPoint(int i, double d, double d2) {
            this.f2263a = i;
            this.b = d;
            this.c = d2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzh zzhVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzh zzhVar = CREATOR;
            zzh.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class PersonName implements SafeParcelable {
        public static final zzi CREATOR = new zzi();

        /* renamed from: a, reason: collision with root package name */
        final int f2264a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public PersonName() {
            this.f2264a = 1;
        }

        public PersonName(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f2264a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzi zziVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzi zziVar = CREATOR;
            zzi.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class Phone implements SafeParcelable {
        public static final zzj CREATOR = new zzj();

        /* renamed from: a, reason: collision with root package name */
        final int f2265a;
        public int b;
        public String c;

        public Phone() {
            this.f2265a = 1;
        }

        public Phone(int i, int i2, String str) {
            this.f2265a = i;
            this.b = i2;
            this.c = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzj zzjVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzj zzjVar = CREATOR;
            zzj.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class Sms implements SafeParcelable {
        public static final zzk CREATOR = new zzk();

        /* renamed from: a, reason: collision with root package name */
        final int f2266a;
        public String b;
        public String c;

        public Sms() {
            this.f2266a = 1;
        }

        public Sms(int i, String str, String str2) {
            this.f2266a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzk zzkVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzk zzkVar = CREATOR;
            zzk.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class UrlBookmark implements SafeParcelable {
        public static final zzl CREATOR = new zzl();

        /* renamed from: a, reason: collision with root package name */
        final int f2267a;
        public String b;
        public String c;

        public UrlBookmark() {
            this.f2267a = 1;
        }

        public UrlBookmark(int i, String str, String str2) {
            this.f2267a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzl zzlVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzl zzlVar = CREATOR;
            zzl.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public static class WiFi implements SafeParcelable {
        public static final zzm CREATOR = new zzm();

        /* renamed from: a, reason: collision with root package name */
        final int f2268a;
        public String b;
        public String c;
        public int d;

        public WiFi() {
            this.f2268a = 1;
        }

        public WiFi(int i, String str, String str2, int i2) {
            this.f2268a = i;
            this.b = str;
            this.c = str2;
            this.d = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzm zzmVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzm zzmVar = CREATOR;
            zzm.a(this, parcel, i);
        }
    }

    public Barcode() {
        this.f2256a = 1;
    }

    public Barcode(int i, int i2, String str, String str2, int i3, Point[] pointArr, Email email, Phone phone, Sms sms, WiFi wiFi, UrlBookmark urlBookmark, GeoPoint geoPoint, CalendarEvent calendarEvent, ContactInfo contactInfo, DriverLicense driverLicense) {
        this.f2256a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = i3;
        this.f = pointArr;
        this.g = email;
        this.h = phone;
        this.i = sms;
        this.j = wiFi;
        this.k = urlBookmark;
        this.l = geoPoint;
        this.m = calendarEvent;
        this.n = contactInfo;
        this.o = driverLicense;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.a(this, parcel, i);
    }
}
