package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();

    /* renamed from: a, reason: collision with root package name */
    int f1844a;
    long b;
    long c;
    boolean d;
    long e;
    int f;
    float g;
    long h;
    private final int i;

    public LocationRequest() {
        this.i = 1;
        this.f1844a = 102;
        this.b = 3600000L;
        this.c = 600000L;
        this.d = false;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0f;
        this.h = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.i = i;
        this.f1844a = i2;
        this.b = j;
        this.c = j2;
        this.d = z;
        this.e = j3;
        this.f = i3;
        this.g = f;
        this.h = j4;
    }

    public static String a(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 101:
            case 103:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f1844a == locationRequest.f1844a && this.b == locationRequest.b && this.c == locationRequest.c && this.d == locationRequest.d && this.e == locationRequest.e && this.f == locationRequest.f && this.g == locationRequest.g;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.f1844a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Float.valueOf(this.g));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(a(this.f1844a));
        if (this.f1844a != 105) {
            sb.append(" requested=");
            sb.append(this.b).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.c).append("ms");
        if (this.h > this.b) {
            sb.append(" maxWait=");
            sb.append(this.h).append("ms");
        }
        if (this.e != Long.MAX_VALUE) {
            long elapsedRealtime = this.e - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime).append("ms");
        }
        if (this.f != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.a(this, parcel, i);
    }
}
