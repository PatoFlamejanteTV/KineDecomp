package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@zzgr
/* loaded from: classes.dex */
public class zzia extends Handler {
    public zzia(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzp.h().zzc(e, false);
            throw e;
        }
    }
}
