package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    final String f2026a;
    final String b;
    final String c;
    final String d;
    final long e;
    final long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, String str3, String str4, long j, long j2) {
        zzx.a(str);
        zzx.b(j >= 0);
        this.f2026a = str;
        this.b = str2;
        this.c = TextUtils.isEmpty(str3) ? null : str3;
        this.d = str4;
        this.e = j;
        this.f = j2;
    }

    public b a(zzp zzpVar, long j) {
        zzx.a(zzpVar);
        long j2 = this.e + 1;
        if (j2 > 2147483647L) {
            zzpVar.o().a("Bundle index overflow");
            j2 = 0;
        }
        return new b(this.f2026a, this.b, this.c, this.d, j2, j);
    }

    public b a(String str) {
        return new b(this.f2026a, this.b, str, this.d, this.e, this.f);
    }

    public b a(String str, String str2) {
        return new b(this.f2026a, str, this.c, str2, this.e, this.f);
    }
}
