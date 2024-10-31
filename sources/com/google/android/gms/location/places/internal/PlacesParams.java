package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* loaded from: classes.dex */
public class PlacesParams implements SafeParcelable {
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;

    /* renamed from: a, reason: collision with root package name */
    public static final PlacesParams f1886a = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public static final zzt CREATOR = new zzt();

    public PlacesParams(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = i2;
    }

    public PlacesParams(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null, null, GoogleApiAvailability.f862a);
    }

    public PlacesParams(String str, Locale locale, String str2, String str3, String str4) {
        this(1, str, locale.toString(), str2, str3, str4, GoogleApiAvailability.f862a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzt zztVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) obj;
        return this.d.equals(placesParams.d) && this.c.equals(placesParams.c) && zzw.a(this.e, placesParams.e) && zzw.a(this.f, placesParams.f) && zzw.a(this.g, placesParams.g);
    }

    public int hashCode() {
        return zzw.a(this.c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        return zzw.a(this).a("clientPackageName", this.c).a("locale", this.d).a("accountName", this.e).a("gCoreClientName", this.f).a("chargedPackageName", this.g).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt zztVar = CREATOR;
        zzt.a(this, parcel, i);
    }
}
