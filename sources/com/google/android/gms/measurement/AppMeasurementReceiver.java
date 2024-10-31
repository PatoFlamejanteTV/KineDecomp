package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzbm;
import com.google.android.gms.measurement.internal.zzbp;

/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzbp {

    /* renamed from: c */
    private zzbm f13602c;

    @Override // com.google.android.gms.measurement.internal.zzbp
    public final void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f13602c == null) {
            this.f13602c = new zzbm(this);
        }
        this.f13602c.a(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzbp
    public final BroadcastReceiver.PendingResult a() {
        return goAsync();
    }
}
