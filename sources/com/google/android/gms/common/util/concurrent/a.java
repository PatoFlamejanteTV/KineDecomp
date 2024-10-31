package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a */
    private final Runnable f11299a;

    /* renamed from: b */
    private final int f11300b;

    public a(Runnable runnable, int i) {
        this.f11299a = runnable;
        this.f11300b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f11300b);
        this.f11299a.run();
    }
}
