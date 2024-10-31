package com.google.android.gms.stats;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ WakeLock f14157a;

    public b(WakeLock wakeLock) {
        this.f14157a = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14157a.a(0);
    }
}
