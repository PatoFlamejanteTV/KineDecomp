package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ BroadcastReceiver.PendingResult f10340a;

    public a(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.f10340a = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.f10340a;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
