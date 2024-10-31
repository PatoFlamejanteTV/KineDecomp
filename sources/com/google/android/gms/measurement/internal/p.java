package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    final String f2041a;
    final String b;
    final long c;
    final long d;
    final long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, String str2, long j, long j2, long j3) {
        zzx.a(str);
        zzx.a(str2);
        zzx.b(j >= 0);
        zzx.b(j2 >= 0);
        this.f2041a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p a(long j) {
        return new p(this.f2041a, this.b, this.c + 1, this.d + 1, j);
    }
}
