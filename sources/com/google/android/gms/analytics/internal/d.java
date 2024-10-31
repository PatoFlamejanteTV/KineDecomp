package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzmn;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final zzmn f702a;
    private long b;

    public d(zzmn zzmnVar) {
        com.google.android.gms.common.internal.zzx.a(zzmnVar);
        this.f702a = zzmnVar;
    }

    public d(zzmn zzmnVar, long j) {
        com.google.android.gms.common.internal.zzx.a(zzmnVar);
        this.f702a = zzmnVar;
        this.b = j;
    }

    public void a() {
        this.b = this.f702a.elapsedRealtime();
    }

    public boolean a(long j) {
        return this.b == 0 || this.f702a.elapsedRealtime() - this.b > j;
    }

    public void b() {
        this.b = 0L;
    }
}
