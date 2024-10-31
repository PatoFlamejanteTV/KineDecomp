package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.a */
/* loaded from: classes2.dex */
public final class C1404a {

    /* renamed from: a */
    final String f13730a;

    /* renamed from: b */
    final String f13731b;

    /* renamed from: c */
    final long f13732c;

    /* renamed from: d */
    final long f13733d;

    /* renamed from: e */
    final long f13734e;

    /* renamed from: f */
    final long f13735f;

    /* renamed from: g */
    final Long f13736g;

    /* renamed from: h */
    final Long f13737h;
    final Long i;
    final Boolean j;

    public C1404a(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        Preconditions.b(str);
        Preconditions.b(str2);
        Preconditions.a(j >= 0);
        Preconditions.a(j2 >= 0);
        Preconditions.a(j4 >= 0);
        this.f13730a = str;
        this.f13731b = str2;
        this.f13732c = j;
        this.f13733d = j2;
        this.f13734e = j3;
        this.f13735f = j4;
        this.f13736g = l;
        this.f13737h = l2;
        this.i = l3;
        this.j = bool;
    }

    public final C1404a a(long j) {
        return new C1404a(this.f13730a, this.f13731b, this.f13732c, this.f13733d, j, this.f13735f, this.f13736g, this.f13737h, this.i, this.j);
    }

    public final C1404a a(long j, long j2) {
        return new C1404a(this.f13730a, this.f13731b, this.f13732c, this.f13733d, this.f13734e, j, Long.valueOf(j2), this.f13737h, this.i, this.j);
    }

    public final C1404a a(Long l, Long l2, Boolean bool) {
        return new C1404a(this.f13730a, this.f13731b, this.f13732c, this.f13733d, this.f13734e, this.f13735f, this.f13736g, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
