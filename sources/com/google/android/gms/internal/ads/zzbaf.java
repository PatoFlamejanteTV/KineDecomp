package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

@zzark
/* loaded from: classes2.dex */
public final class zzbaf {
    private HandlerThread zzenj = null;
    private Handler mHandler = null;
    private int zzenk = 0;
    private final Object mLock = new Object();

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final Looper zzaak() {
        Looper looper;
        synchronized (this.mLock) {
            if (this.zzenk == 0) {
                if (this.zzenj == null) {
                    zzaxz.v("Starting the looper thread.");
                    this.zzenj = new HandlerThread("LooperProvider");
                    this.zzenj.start();
                    this.mHandler = new Handler(this.zzenj.getLooper());
                    zzaxz.v("Looper thread started.");
                } else {
                    zzaxz.v("Resuming the looper thread");
                    this.mLock.notifyAll();
                }
            } else {
                Preconditions.a(this.zzenj, "Invalid state: mHandlerThread should already been initialized.");
            }
            this.zzenk++;
            looper = this.zzenj.getLooper();
        }
        return looper;
    }
}
