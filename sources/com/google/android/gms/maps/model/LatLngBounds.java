package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f1982a;
    public final LatLng b;
    private final int c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private double f1983a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzx.a(latLng, "null southwest");
        zzx.a(latLng2, "null northeast");
        zzx.b(latLng2.f1981a >= latLng.f1981a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.f1981a), Double.valueOf(latLng2.f1981a));
        this.c = i;
        this.f1982a = latLng;
        this.b = latLng2;
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
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f1982a.equals(latLngBounds.f1982a) && this.b.equals(latLngBounds.b);
    }

    public int hashCode() {
        return zzw.a(this.f1982a, this.b);
    }

    public String toString() {
        return zzw.a(this).a("southwest", this.f1982a).a("northeast", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
