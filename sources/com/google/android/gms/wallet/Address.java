package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    String f2277a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    boolean j;
    String k;
    private final int l;

    Address() {
        this.l = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Address(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.l = i;
        this.f2277a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = z;
        this.k = str10;
    }

    public int a() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
