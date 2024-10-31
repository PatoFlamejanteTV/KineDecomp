package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzi;

/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzac f710a;
    final /* synthetic */ zzi.zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(zzi.zza zzaVar, zzac zzacVar) {
        this.b = zzaVar;
        this.f710a = zzacVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (zzi.this.b()) {
            return;
        }
        zzi.this.c("Connected to service after a timeout");
        zzi.this.a(this.f710a);
    }
}
