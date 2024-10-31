package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1976a;
    private LatLng b;
    private double c;
    private float d;
    private int e;
    private int f;
    private float g;
    private boolean h;

    public CircleOptions() {
        this.b = null;
        this.c = 0.0d;
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.f1976a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.b = null;
        this.c = 0.0d;
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.f1976a = i;
        this.b = latLng;
        this.c = d;
        this.d = f;
        this.e = i2;
        this.f = i3;
        this.g = f2;
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1976a;
    }

    public LatLng b() {
        return this.b;
    }

    public double c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public float g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
