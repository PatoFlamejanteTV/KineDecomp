package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class O implements Q {

    /* renamed from: a, reason: collision with root package name */
    protected final zzbw f13672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(zzbw zzbwVar) {
        Preconditions.a(zzbwVar);
        this.f13672a = zzbwVar;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public Clock a() {
        return this.f13672a.a();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public zzas b() {
        return this.f13672a.b();
    }

    public void c() {
        this.f13672a.zzgs().c();
    }

    public void d() {
        this.f13672a.f();
    }

    public void e() {
        this.f13672a.zzgs().e();
    }

    public zzaa f() {
        return this.f13672a.n();
    }

    public zzaq g() {
        return this.f13672a.o();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public Context getContext() {
        return this.f13672a.getContext();
    }

    public zzfy h() {
        return this.f13672a.p();
    }

    public C1428m i() {
        return this.f13672a.q();
    }

    public zzq j() {
        return this.f13672a.r();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public zzbr zzgs() {
        return this.f13672a.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public zzn zzgw() {
        return this.f13672a.zzgw();
    }
}
