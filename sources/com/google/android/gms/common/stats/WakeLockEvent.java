package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    /* renamed from: a */
    private final int f11251a;

    /* renamed from: b */
    private final long f11252b;

    /* renamed from: c */
    private int f11253c;

    /* renamed from: d */
    private final String f11254d;

    /* renamed from: e */
    private final String f11255e;

    /* renamed from: f */
    private final String f11256f;

    /* renamed from: g */
    private final int f11257g;

    /* renamed from: h */
    private final List<String> f11258h;
    private final String i;
    private final long j;
    private int k;
    private final String l;
    private final float m;
    private final long n;
    private final boolean o;
    private long p;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 14) int i4, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f2, @SafeParcelable.Param(id = 16) long j3, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        this.f11251a = i;
        this.f11252b = j;
        this.f11253c = i2;
        this.f11254d = str;
        this.f11255e = str3;
        this.f11256f = str5;
        this.f11257g = i3;
        this.p = -1L;
        this.f11258h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.l = str4;
        this.m = f2;
        this.n = j3;
        this.o = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long O() {
        return this.f11252b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int a() {
        return this.f11253c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11251a);
        SafeParcelWriter.a(parcel, 2, O());
        SafeParcelWriter.a(parcel, 4, this.f11254d, false);
        SafeParcelWriter.a(parcel, 5, this.f11257g);
        SafeParcelWriter.c(parcel, 6, this.f11258h, false);
        SafeParcelWriter.a(parcel, 8, this.j);
        SafeParcelWriter.a(parcel, 10, this.f11255e, false);
        SafeParcelWriter.a(parcel, 11, a());
        SafeParcelWriter.a(parcel, 12, this.i, false);
        SafeParcelWriter.a(parcel, 13, this.l, false);
        SafeParcelWriter.a(parcel, 14, this.k);
        SafeParcelWriter.a(parcel, 15, this.m);
        SafeParcelWriter.a(parcel, 16, this.n);
        SafeParcelWriter.a(parcel, 17, this.f11256f, false);
        SafeParcelWriter.a(parcel, 18, this.o);
        SafeParcelWriter.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzu() {
        return this.p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzv() {
        String str = this.f11254d;
        int i = this.f11257g;
        List<String> list = this.f11258h;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.k;
        String str2 = this.f11255e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.l;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.m;
        String str4 = this.f11256f;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f2, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f2, j3, str5, z);
    }
}
