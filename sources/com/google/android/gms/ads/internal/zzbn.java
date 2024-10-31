package com.google.android.gms.ads.internal;

import android.os.Handler;

/* loaded from: classes.dex */
public final class zzbn {

    /* renamed from: a */
    private final Handler f10232a;

    public zzbn(Handler handler) {
        this.f10232a = handler;
    }

    public final void a(Runnable runnable) {
        this.f10232a.removeCallbacks(runnable);
    }

    public final boolean a(Runnable runnable, long j) {
        return this.f10232a.postDelayed(runnable, j);
    }
}
