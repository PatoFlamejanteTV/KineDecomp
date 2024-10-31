package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class StreetViewPanoramaOrientation implements SafeParcelable {
    public static final zzm CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final float f1994a;
    public final float b;
    private final int c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public float f1995a;
        public float b;

        public Builder a(float f) {
            this.b = f;
            return this;
        }

        public StreetViewPanoramaOrientation a() {
            return new StreetViewPanoramaOrientation(this.b, this.f1995a);
        }

        public Builder b(float f) {
            this.f1995a = f;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        this(1, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaOrientation(int i, float f, float f2) {
        zzx.b(-90.0f <= f && f <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.c = i;
        this.f1994a = 0.0f + f;
        this.b = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
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
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f1994a) == Float.floatToIntBits(streetViewPanoramaOrientation.f1994a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(streetViewPanoramaOrientation.b);
    }

    public int hashCode() {
        return zzw.a(Float.valueOf(this.f1994a), Float.valueOf(this.b));
    }

    public String toString() {
        return zzw.a(this).a("tilt", Float.valueOf(this.f1994a)).a("bearing", Float.valueOf(this.b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
