package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.zzaf;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaf f692a;
    final /* synthetic */ Handler b;
    final /* synthetic */ int c;
    final /* synthetic */ CampaignTrackingService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CampaignTrackingService campaignTrackingService, zzaf zzafVar, Handler handler, int i) {
        this.d = campaignTrackingService;
        this.f692a = zzafVar;
        this.b = handler;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.a(this.f692a, this.b, this.c);
    }
}
