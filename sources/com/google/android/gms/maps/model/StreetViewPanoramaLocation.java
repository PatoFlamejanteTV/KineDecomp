package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzl CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public final StreetViewPanoramaLink[] f1993a;
    public final LatLng b;
    public final String c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.d = i;
        this.f1993a = streetViewPanoramaLinkArr;
        this.b = latLng;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.c.equals(streetViewPanoramaLocation.c) && this.b.equals(streetViewPanoramaLocation.b);
    }

    public int hashCode() {
        return zzw.a(this.b, this.c);
    }

    public String toString() {
        return zzw.a(this).a("panoId", this.c).a("position", this.b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.a(this, parcel, i);
    }
}
