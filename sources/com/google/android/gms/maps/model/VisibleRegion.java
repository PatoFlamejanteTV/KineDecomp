package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class VisibleRegion implements SafeParcelable {
    public static final zzp CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f1999a;
    public final LatLng b;
    public final LatLng c;
    public final LatLng d;
    public final LatLngBounds e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f = i;
        this.f1999a = latLng;
        this.b = latLng2;
        this.c = latLng3;
        this.d = latLng4;
        this.e = latLngBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f1999a.equals(visibleRegion.f1999a) && this.b.equals(visibleRegion.b) && this.c.equals(visibleRegion.c) && this.d.equals(visibleRegion.d) && this.e.equals(visibleRegion.e);
    }

    public int hashCode() {
        return zzw.a(this.f1999a, this.b, this.c, this.d, this.e);
    }

    public String toString() {
        return zzw.a(this).a("nearLeft", this.f1999a).a("nearRight", this.b).a("farLeft", this.c).a("farRight", this.d).a("latLngBounds", this.e).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.a(this, parcel, i);
    }
}
