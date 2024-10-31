package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    private final int f1868a;
    private final int b;
    private final int c;

    @Deprecated
    private final PlaceFilter d;
    private final NearbyAlertFilter e;
    private final boolean f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyAlertRequest(int i, int i2, int i3, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean z, int i4) {
        this.f1868a = i;
        this.b = i2;
        this.c = i3;
        this.f = z;
        if (nearbyAlertFilter != null) {
            this.e = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.e = null;
        } else if (a(placeFilter)) {
            this.e = NearbyAlertFilter.a(placeFilter.a(), placeFilter.b(), placeFilter.c());
        } else {
            this.e = null;
        }
        this.d = null;
        this.g = i4;
    }

    @Deprecated
    private static boolean a(PlaceFilter placeFilter) {
        return ((placeFilter.b() == null || placeFilter.b().isEmpty()) && (placeFilter.a() == null || placeFilter.a().isEmpty()) && (placeFilter.c() == null || placeFilter.c().isEmpty())) ? false : true;
    }

    public int a() {
        return this.f1868a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Deprecated
    public PlaceFilter d() {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
        return 0;
    }

    public NearbyAlertFilter e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) obj;
        return this.b == nearbyAlertRequest.b && this.c == nearbyAlertRequest.c && zzw.a(this.d, nearbyAlertRequest.d) && zzw.a(this.e, nearbyAlertRequest.e);
    }

    public boolean f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public String toString() {
        return zzw.a(this).a("transitionTypes", Integer.valueOf(this.b)).a("loiteringTimeMillis", Integer.valueOf(this.c)).a("nearbyAlertFilter", this.e).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.a(this, parcel, i);
    }
}
