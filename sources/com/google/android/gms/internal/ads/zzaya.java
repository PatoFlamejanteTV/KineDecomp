package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@zzark
/* loaded from: classes2.dex */
public final class zzaya extends Handler {
    public zzaya(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzbv.e();
            zzayh.zza(com.google.android.gms.ads.internal.zzbv.i().getApplicationContext(), th);
            throw th;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdMobHandler.handleMessage");
        }
    }
}
