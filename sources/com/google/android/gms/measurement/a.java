package com.google.android.gms.measurement;

import android.os.Handler;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzv;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzv f2013a;
    final /* synthetic */ int b;
    final /* synthetic */ zzp c;
    final /* synthetic */ AppMeasurementService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppMeasurementService appMeasurementService, zzv zzvVar, int i, zzp zzpVar) {
        this.d = appMeasurementService;
        this.f2013a = zzvVar;
        this.b = i;
        this.c = zzpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        this.f2013a.w();
        handler = this.d.f2012a;
        handler.post(new b(this));
    }
}
