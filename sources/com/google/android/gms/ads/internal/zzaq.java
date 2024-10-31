package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzark;

@zzark
/* loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();

    /* renamed from: a */
    public final boolean f10204a;

    /* renamed from: b */
    public final boolean f10205b;

    /* renamed from: c */
    private final String f10206c;

    /* renamed from: d */
    public final boolean f10207d;

    /* renamed from: e */
    public final float f10208e;

    /* renamed from: f */
    public final int f10209f;

    /* renamed from: g */
    public final boolean f10210g;

    /* renamed from: h */
    public final boolean f10211h;
    public final boolean i;

    public zzaq(boolean z, boolean z2, boolean z3, float f2, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f2, i, z4, z5, z6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.f10204a);
        SafeParcelWriter.a(parcel, 3, this.f10205b);
        SafeParcelWriter.a(parcel, 4, this.f10206c, false);
        SafeParcelWriter.a(parcel, 5, this.f10207d);
        SafeParcelWriter.a(parcel, 6, this.f10208e);
        SafeParcelWriter.a(parcel, 7, this.f10209f);
        SafeParcelWriter.a(parcel, 8, this.f10210g);
        SafeParcelWriter.a(parcel, 9, this.f10211h);
        SafeParcelWriter.a(parcel, 10, this.i);
        SafeParcelWriter.a(parcel, a2);
    }

    @SafeParcelable.Constructor
    public zzaq(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) float f2, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) boolean z5, @SafeParcelable.Param(id = 10) boolean z6) {
        this.f10204a = z;
        this.f10205b = z2;
        this.f10206c = str;
        this.f10207d = z3;
        this.f10208e = f2;
        this.f10209f = i;
        this.f10210g = z4;
        this.f10211h = z5;
        this.i = z6;
    }
}
