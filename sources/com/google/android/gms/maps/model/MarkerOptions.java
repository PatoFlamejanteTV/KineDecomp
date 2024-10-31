package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f1985a;
    private LatLng b;
    private String c;
    private String d;
    private BitmapDescriptor e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;

    public MarkerOptions() {
        this.f = 0.5f;
        this.g = 1.0f;
        this.i = true;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.f1985a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.f = 0.5f;
        this.g = 1.0f;
        this.i = true;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.f1985a = i;
        this.b = latLng;
        this.c = str;
        this.d = str2;
        this.e = iBinder == null ? null : new BitmapDescriptor(zzd.zza.a(iBinder));
        this.f = f;
        this.g = f2;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = f3;
        this.l = f4;
        this.m = f5;
        this.n = f6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f1985a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder b() {
        if (this.e == null) {
            return null;
        }
        return this.e.a().asBinder();
    }

    public LatLng c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.d;
    }

    public float f() {
        return this.f;
    }

    public float g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public float k() {
        return this.k;
    }

    public float l() {
        return this.l;
    }

    public float m() {
        return this.m;
    }

    public float n() {
        return this.n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
