package com.google.android.gms.internal.firebase_messaging;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public class zza extends Handler {
    private static volatile zzb zza;

    public zza() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public zza(Looper looper) {
        super(looper);
    }

    public zza(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
