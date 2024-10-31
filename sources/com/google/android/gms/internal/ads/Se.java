package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes2.dex */
public final class Se implements Runnable {
    public Se(Re re) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
