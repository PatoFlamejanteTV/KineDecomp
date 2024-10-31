package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class PlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    static final long f1874a = TimeUnit.HOURS.toMillis(1);
    final int b;
    private final PlaceFilter c;
    private final long d;
    private final int e;
    private final long f;

    public PlaceRequest(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.b = i;
        this.c = placeFilter;
        this.d = j;
        this.e = i2;
        this.f = j2;
    }

    public PlaceFilter a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public long d() {
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
        if (!(obj instanceof PlaceRequest)) {
            return false;
        }
        PlaceRequest placeRequest = (PlaceRequest) obj;
        return zzw.a(this.c, placeRequest.c) && this.d == placeRequest.d && this.e == placeRequest.e && this.f == placeRequest.f;
    }

    public int hashCode() {
        return zzw.a(this.c, Long.valueOf(this.d), Integer.valueOf(this.e), Long.valueOf(this.f));
    }

    public String toString() {
        return zzw.a(this).a("filter", this.c).a("interval", Long.valueOf(this.d)).a("priority", Integer.valueOf(this.e)).a("expireAt", Long.valueOf(this.f)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }
}
