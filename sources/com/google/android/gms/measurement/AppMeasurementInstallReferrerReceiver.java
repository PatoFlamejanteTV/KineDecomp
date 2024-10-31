package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzbm;
import com.google.android.gms.measurement.internal.zzbp;

/* loaded from: classes2.dex */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzbp {

    /* renamed from: a */
    private zzbm f13600a;

    @Override // com.google.android.gms.measurement.internal.zzbp
    public final BroadcastReceiver.PendingResult a() {
        return goAsync();
    }

    @Override // com.google.android.gms.measurement.internal.zzbp
    public final void a(Context context, Intent intent) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f13600a == null) {
            this.f13600a = new zzbm(this);
        }
        this.f13600a.a(context, intent);
    }
}
