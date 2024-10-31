package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    /* renamed from: a */
    public final String f14064a;

    /* renamed from: b */
    public final String f14065b;

    /* renamed from: c */
    public final String f14066c;

    /* renamed from: d */
    public final String f14067d;

    /* renamed from: e */
    public final long f14068e;

    /* renamed from: f */
    public final long f14069f;

    /* renamed from: g */
    public final String f14070g;

    /* renamed from: h */
    public final boolean f14071h;
    public final boolean i;
    public final long j;
    public final String k;
    public final long l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;

    public zzk(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7) {
        Preconditions.b(str);
        this.f14064a = str;
        this.f14065b = TextUtils.isEmpty(str2) ? null : str2;
        this.f14066c = str3;
        this.j = j;
        this.f14067d = str4;
        this.f14068e = j2;
        this.f14069f = j3;
        this.f14070g = str5;
        this.f14071h = z;
        this.i = z2;
        this.k = str6;
        this.l = j4;
        this.m = j5;
        this.n = i;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f14064a, false);
        SafeParcelWriter.a(parcel, 3, this.f14065b, false);
        SafeParcelWriter.a(parcel, 4, this.f14066c, false);
        SafeParcelWriter.a(parcel, 5, this.f14067d, false);
        SafeParcelWriter.a(parcel, 6, this.f14068e);
        SafeParcelWriter.a(parcel, 7, this.f14069f);
        SafeParcelWriter.a(parcel, 8, this.f14070g, false);
        SafeParcelWriter.a(parcel, 9, this.f14071h);
        SafeParcelWriter.a(parcel, 10, this.i);
        SafeParcelWriter.a(parcel, 11, this.j);
        SafeParcelWriter.a(parcel, 12, this.k, false);
        SafeParcelWriter.a(parcel, 13, this.l);
        SafeParcelWriter.a(parcel, 14, this.m);
        SafeParcelWriter.a(parcel, 15, this.n);
        SafeParcelWriter.a(parcel, 16, this.o);
        SafeParcelWriter.a(parcel, 17, this.p);
        SafeParcelWriter.a(parcel, 18, this.q);
        SafeParcelWriter.a(parcel, 19, this.r, false);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j, @SafeParcelable.Param(id = 7) long j2, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) boolean z2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j4, @SafeParcelable.Param(id = 14) long j5, @SafeParcelable.Param(id = 15) int i, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) boolean z4, @SafeParcelable.Param(id = 18) boolean z5, @SafeParcelable.Param(id = 19) String str7) {
        this.f14064a = str;
        this.f14065b = str2;
        this.f14066c = str3;
        this.j = j3;
        this.f14067d = str4;
        this.f14068e = j;
        this.f14069f = j2;
        this.f14070g = str5;
        this.f14071h = z;
        this.i = z2;
        this.k = str6;
        this.l = j4;
        this.m = j5;
        this.n = i;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
    }
}
