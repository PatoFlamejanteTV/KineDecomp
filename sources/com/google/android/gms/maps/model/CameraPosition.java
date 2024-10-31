package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class CameraPosition implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f1973a;
    public final float b;
    public final float c;
    public final float d;
    private final int e;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private LatLng f1974a;
        private float b;
        private float c;
        private float d;

        public Builder a(float f) {
            this.b = f;
            return this;
        }

        public Builder a(LatLng latLng) {
            this.f1974a = latLng;
            return this;
        }

        public CameraPosition a() {
            return new CameraPosition(this.f1974a, this.b, this.c, this.d);
        }

        public Builder b(float f) {
            this.c = f;
            return this;
        }

        public Builder c(float f) {
            this.d = f;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        zzx.a(latLng, "null camera target");
        zzx.b(0.0f <= f2 && f2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.e = i;
        this.f1973a = latLng;
        this.b = f;
        this.c = f2 + 0.0f;
        this.d = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static CameraPosition a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f, obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f);
        Builder b = b();
        b.a(latLng);
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            b.a(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            b.c(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            b.b(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        return b.a();
    }

    public static Builder b() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f1973a.equals(cameraPosition.f1973a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(cameraPosition.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(cameraPosition.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(cameraPosition.d);
    }

    public int hashCode() {
        return zzw.a(this.f1973a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d));
    }

    public String toString() {
        return zzw.a(this).a("target", this.f1973a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
