package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationResult implements SafeParcelable {
    private final int b;
    private final List<Location> c;

    /* renamed from: a, reason: collision with root package name */
    static final List<Location> f1845a = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zze();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(int i, List<Location> list) {
        this.b = i;
        this.c = list;
    }

    public List<Location> a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.c.size() != this.c.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.c.iterator();
        Iterator<Location> it2 = this.c.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 17;
        Iterator<Location> it = this.c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = it.next().getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public String toString() {
        return "LocationResult[locations: " + this.c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
