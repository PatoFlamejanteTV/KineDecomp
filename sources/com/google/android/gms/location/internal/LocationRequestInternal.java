package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class LocationRequestInternal implements SafeParcelable {
    LocationRequest b;
    boolean c;
    boolean d;
    boolean e;
    List<ClientIdentity> f;
    String g;
    boolean h;
    private final int i;

    /* renamed from: a, reason: collision with root package name */
    static final List<ClientIdentity> f1853a = Collections.emptyList();
    public static final zzm CREATOR = new zzm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<ClientIdentity> list, String str, boolean z4) {
        this.i = i;
        this.b = locationRequest;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = list;
        this.g = str;
        this.h = z4;
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
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return zzw.a(this.b, locationRequestInternal.b) && this.c == locationRequestInternal.c && this.d == locationRequestInternal.d && this.e == locationRequestInternal.e && this.h == locationRequestInternal.h && zzw.a(this.f, locationRequestInternal.f);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.toString());
        if (this.g != null) {
            sb.append(" tag=").append(this.g);
        }
        sb.append(" nlpDebug=").append(this.c);
        sb.append(" trigger=").append(this.e);
        sb.append(" restorePIListeners=").append(this.d);
        sb.append(" hideAppOps=").append(this.h);
        sb.append(" clients=").append(this.f);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
