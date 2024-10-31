package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class zzfv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();

    /* renamed from: a */
    private final int f14051a;

    /* renamed from: b */
    public final String f14052b;

    /* renamed from: c */
    public final long f14053c;

    /* renamed from: d */
    public final Long f14054d;

    /* renamed from: e */
    private final Float f14055e;

    /* renamed from: f */
    public final String f14056f;

    /* renamed from: g */
    public final String f14057g;

    /* renamed from: h */
    public final Double f14058h;

    public zzfv(Qa qa) {
        this(qa.f13679c, qa.f13680d, qa.f13681e, qa.f13678b);
    }

    public final Object getValue() {
        Long l = this.f14054d;
        if (l != null) {
            return l;
        }
        Double d2 = this.f14058h;
        if (d2 != null) {
            return d2;
        }
        String str = this.f14056f;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f14051a);
        SafeParcelWriter.a(parcel, 2, this.f14052b, false);
        SafeParcelWriter.a(parcel, 3, this.f14053c);
        SafeParcelWriter.a(parcel, 4, this.f14054d, false);
        SafeParcelWriter.a(parcel, 5, (Float) null, false);
        SafeParcelWriter.a(parcel, 6, this.f14056f, false);
        SafeParcelWriter.a(parcel, 7, this.f14057g, false);
        SafeParcelWriter.a(parcel, 8, this.f14058h, false);
        SafeParcelWriter.a(parcel, a2);
    }

    public zzfv(String str, long j, Object obj, String str2) {
        Preconditions.b(str);
        this.f14051a = 2;
        this.f14052b = str;
        this.f14053c = j;
        this.f14057g = str2;
        if (obj == null) {
            this.f14054d = null;
            this.f14055e = null;
            this.f14058h = null;
            this.f14056f = null;
            return;
        }
        if (obj instanceof Long) {
            this.f14054d = (Long) obj;
            this.f14055e = null;
            this.f14058h = null;
            this.f14056f = null;
            return;
        }
        if (obj instanceof String) {
            this.f14054d = null;
            this.f14055e = null;
            this.f14058h = null;
            this.f14056f = (String) obj;
            return;
        }
        if (obj instanceof Double) {
            this.f14054d = null;
            this.f14055e = null;
            this.f14058h = (Double) obj;
            this.f14056f = null;
            return;
        }
        throw new IllegalArgumentException("User attribute given of un-supported type");
    }

    @SafeParcelable.Constructor
    public zzfv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f2, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d2) {
        this.f14051a = i;
        this.f14052b = str;
        this.f14053c = j;
        this.f14054d = l;
        this.f14055e = null;
        if (i == 1) {
            this.f14058h = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.f14058h = d2;
        }
        this.f14056f = str2;
        this.f14057g = str3;
    }
}
