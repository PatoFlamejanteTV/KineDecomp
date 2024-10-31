package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.zzab;

/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzab.zza f2034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzab.zza zzaVar) {
        this.f2034a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzab.this.a(new ComponentName(zzab.this.i(), (Class<?>) AppMeasurementService.class));
    }
}
