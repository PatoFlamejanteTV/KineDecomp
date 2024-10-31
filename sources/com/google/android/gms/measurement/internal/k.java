package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final zzmn f2035a;
    private long b;

    public k(zzmn zzmnVar) {
        zzx.a(zzmnVar);
        this.f2035a = zzmnVar;
    }

    public void a() {
        this.b = this.f2035a.elapsedRealtime();
    }

    public boolean a(long j) {
        return this.b == 0 || this.f2035a.elapsedRealtime() - this.b >= j;
    }

    public void b() {
        this.b = 0L;
    }
}
