package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzab;

/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzm f2031a;
    final /* synthetic */ zzab.zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzab.zza zzaVar, zzm zzmVar) {
        this.b = zzaVar;
        this.f2031a = zzmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (zzab.this.b()) {
            return;
        }
        zzab.this.l().s().a("Connected to service");
        zzab.this.a(this.f2031a);
    }
}
