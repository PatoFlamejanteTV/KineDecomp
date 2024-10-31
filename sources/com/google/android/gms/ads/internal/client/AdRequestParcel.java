package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public final class AdRequestParcel implements SafeParcelable {
    public static final zzg CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public final int f533a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List<String> e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final SearchAdRequestParcel j;
    public final Location k;
    public final String l;
    public final Bundle m;
    public final Bundle n;
    public final List<String> o;
    public final String p;
    public final String q;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4) {
        this.f533a = i;
        this.b = j;
        this.c = bundle == null ? new Bundle() : bundle;
        this.d = i2;
        this.e = list;
        this.f = z;
        this.g = i3;
        this.h = z2;
        this.i = str;
        this.j = searchAdRequestParcel;
        this.k = location;
        this.l = str2;
        this.m = bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.f533a == adRequestParcel.f533a && this.b == adRequestParcel.b && com.google.android.gms.common.internal.zzw.a(this.c, adRequestParcel.c) && this.d == adRequestParcel.d && com.google.android.gms.common.internal.zzw.a(this.e, adRequestParcel.e) && this.f == adRequestParcel.f && this.g == adRequestParcel.g && this.h == adRequestParcel.h && com.google.android.gms.common.internal.zzw.a(this.i, adRequestParcel.i) && com.google.android.gms.common.internal.zzw.a(this.j, adRequestParcel.j) && com.google.android.gms.common.internal.zzw.a(this.k, adRequestParcel.k) && com.google.android.gms.common.internal.zzw.a(this.l, adRequestParcel.l) && com.google.android.gms.common.internal.zzw.a(this.m, adRequestParcel.m) && com.google.android.gms.common.internal.zzw.a(this.n, adRequestParcel.n) && com.google.android.gms.common.internal.zzw.a(this.o, adRequestParcel.o) && com.google.android.gms.common.internal.zzw.a(this.p, adRequestParcel.p) && com.google.android.gms.common.internal.zzw.a(this.q, adRequestParcel.q);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.a(Integer.valueOf(this.f533a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), this.e, Boolean.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.a(this, parcel, i);
    }
}
