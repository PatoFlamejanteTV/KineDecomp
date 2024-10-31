package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: com.google.android.gms.measurement.internal.xa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1450xa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzes f13873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1450xa(zzes zzesVar) {
        this.f13873a = zzesVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeb zzebVar = this.f13873a.f14026c;
        Context context = zzebVar.getContext();
        this.f13873a.f14026c.zzgw();
        zzebVar.a(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
