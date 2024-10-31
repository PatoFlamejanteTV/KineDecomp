package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AncsNotificationParcelable implements SafeParcelable, com.google.android.gms.wearable.zzd {
    public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f2333a;
    private int b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private String h;
    private byte i;
    private byte j;
    private byte k;
    private byte l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.b = i2;
        this.f2333a = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = b;
        this.j = b2;
        this.k = b3;
        this.l = b4;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        if (this.l == ancsNotificationParcelable.l && this.k == ancsNotificationParcelable.k && this.j == ancsNotificationParcelable.j && this.i == ancsNotificationParcelable.i && this.b == ancsNotificationParcelable.b && this.f2333a == ancsNotificationParcelable.f2333a && this.c.equals(ancsNotificationParcelable.c)) {
            if (this.d == null ? ancsNotificationParcelable.d != null : !this.d.equals(ancsNotificationParcelable.d)) {
                return false;
            }
            return this.h.equals(ancsNotificationParcelable.h) && this.e.equals(ancsNotificationParcelable.e) && this.g.equals(ancsNotificationParcelable.g) && this.f.equals(ancsNotificationParcelable.f);
        }
        return false;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h == null ? this.c : this.h;
    }

    public byte h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((this.d != null ? this.d.hashCode() : 0) + (((((this.f2333a * 31) + this.b) * 31) + this.c.hashCode()) * 31)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l;
    }

    public byte i() {
        return this.j;
    }

    public byte j() {
        return this.k;
    }

    public byte k() {
        return this.l;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.f2333a + ", mId=" + this.b + ", mAppId='" + this.c + "', mDateTime='" + this.d + "', mNotificationText='" + this.e + "', mTitle='" + this.f + "', mSubtitle='" + this.g + "', mDisplayName='" + this.h + "', mEventId=" + ((int) this.i) + ", mEventFlags=" + ((int) this.j) + ", mCategoryId=" + ((int) this.k) + ", mCategoryCount=" + ((int) this.l) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
