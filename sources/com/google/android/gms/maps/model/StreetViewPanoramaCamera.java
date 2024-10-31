package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* loaded from: classes.dex */
public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final zzj CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final float f1991a;
    public final float b;
    public final float c;
    private final int d;
    private StreetViewPanoramaOrientation e;

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaCamera(int i, float f, float f2, float f3) {
        zzx.b(-90.0f <= f2 && f2 <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.d = i;
        this.f1991a = ((double) f) <= 0.0d ? 0.0f : f;
        this.b = f2 + 0.0f;
        this.c = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        this.e = new StreetViewPanoramaOrientation.Builder().a(f2).b(f3).a();
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
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f1991a) == Float.floatToIntBits(streetViewPanoramaCamera.f1991a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(streetViewPanoramaCamera.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(streetViewPanoramaCamera.c);
    }

    public int hashCode() {
        return zzw.a(Float.valueOf(this.f1991a), Float.valueOf(this.b), Float.valueOf(this.c));
    }

    public String toString() {
        return zzw.a(this).a("zoom", Float.valueOf(this.f1991a)).a("tilt", Float.valueOf(this.b)).a("bearing", Float.valueOf(this.c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
