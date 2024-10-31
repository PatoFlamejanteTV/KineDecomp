package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

/* loaded from: classes.dex */
public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected Class<? extends CampaignTrackingService> a() {
        return InstallReferrerService.class;
    }

    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected void a(String str) {
        zzax.a(str);
    }
}
