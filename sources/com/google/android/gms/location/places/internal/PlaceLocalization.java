package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class PlaceLocalization implements SafeParcelable {
    public static final zzo CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    public final int f1885a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List<String> f;

    public PlaceLocalization(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.f1885a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = list;
    }

    public static PlaceLocalization a(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzo zzoVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) obj;
        return zzw.a(this.b, placeLocalization.b) && zzw.a(this.c, placeLocalization.c) && zzw.a(this.d, placeLocalization.d) && zzw.a(this.e, placeLocalization.e) && zzw.a(this.f, placeLocalization.f);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, this.d, this.e);
    }

    public String toString() {
        return zzw.a(this).a("name", this.b).a("address", this.c).a("internationalPhoneNumber", this.d).a("regularOpenHours", this.e).a("attributions", this.f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo zzoVar = CREATOR;
        zzo.a(this, parcel, i);
    }
}
