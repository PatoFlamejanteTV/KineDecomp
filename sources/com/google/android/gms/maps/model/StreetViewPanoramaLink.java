package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class StreetViewPanoramaLink implements SafeParcelable {
    public static final zzk CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    public final String f1992a;
    public final float b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaLink(int i, String str, float f) {
        this.c = i;
        this.f1992a = str;
        this.b = (((double) f) <= 0.0d ? (f % 360.0f) + 360.0f : f) % 360.0f;
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
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f1992a.equals(streetViewPanoramaLink.f1992a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(streetViewPanoramaLink.b);
    }

    public int hashCode() {
        return zzw.a(this.f1992a, Float.valueOf(this.b));
    }

    public String toString() {
        return zzw.a(this).a("panoId", this.f1992a).a("bearing", Float.valueOf(this.b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
