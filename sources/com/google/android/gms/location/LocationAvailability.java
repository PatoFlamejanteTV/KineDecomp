package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();

    /* renamed from: a, reason: collision with root package name */
    int f1843a;
    int b;
    long c;
    int d;
    private final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.e = i;
        this.d = i2;
        this.f1843a = i3;
        this.b = i4;
        this.c = j;
    }

    public boolean a() {
        return this.d < 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.d == locationAvailability.d && this.f1843a == locationAvailability.f1843a && this.b == locationAvailability.b && this.c == locationAvailability.c;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.d), Integer.valueOf(this.f1843a), Integer.valueOf(this.b), Long.valueOf(this.c));
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + a() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationAvailabilityCreator.a(this, parcel, i);
    }
}
