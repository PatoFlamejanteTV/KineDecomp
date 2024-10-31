package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class PlaceAlias implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public static final PlaceAlias f1900a = new PlaceAlias(0, "Home");
    public static final PlaceAlias b = new PlaceAlias(0, "Work");
    final int c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceAlias(int i, String str) {
        this.c = i;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceAlias) {
            return zzw.a(this.d, ((PlaceAlias) obj).d);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.d);
    }

    public String toString() {
        return zzw.a(this).a("alias", this.d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.a(this, parcel, i);
    }
}
