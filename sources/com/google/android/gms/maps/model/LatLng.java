package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LatLng implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final double f1981a;
    public final double b;
    private final int c;

    public LatLng(double d, double d2) {
        this(1, d, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLng(int i, double d, double d2) {
        this.c = i;
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.b = d2;
        }
        this.f1981a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f1981a) == Double.doubleToLongBits(latLng.f1981a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLng.b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1981a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.f1981a + "," + this.b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
