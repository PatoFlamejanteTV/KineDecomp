package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzaf;

/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f693a;
    final /* synthetic */ zzaf b;
    final /* synthetic */ CampaignTrackingService c;

    public e(CampaignTrackingService campaignTrackingService, int i, zzaf zzafVar) {
        this.c = campaignTrackingService;
        this.f693a = i;
        this.b = zzafVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean stopSelfResult = this.c.stopSelfResult(this.f693a);
        if (stopSelfResult) {
            this.b.a("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
        }
    }
}
