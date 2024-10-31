package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;

/* loaded from: classes.dex */
class a implements zzw {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f689a;
    final /* synthetic */ zzf b;
    final /* synthetic */ zzaf c;
    final /* synthetic */ AnalyticsService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AnalyticsService analyticsService, int i, zzf zzfVar, zzaf zzafVar) {
        this.d = analyticsService;
        this.f689a = i;
        this.b = zzfVar;
        this.c = zzafVar;
    }

    @Override // com.google.android.gms.analytics.internal.zzw
    public void a(Throwable th) {
        Handler handler;
        handler = this.d.f681a;
        handler.post(new b(this));
    }
}
