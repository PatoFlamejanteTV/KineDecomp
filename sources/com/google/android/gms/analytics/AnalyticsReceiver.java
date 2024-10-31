package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzcp;

/* loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private zzcp f10319a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f10319a == null) {
            this.f10319a = new zzcp();
        }
        zzcp.onReceive(context, intent);
    }
}
