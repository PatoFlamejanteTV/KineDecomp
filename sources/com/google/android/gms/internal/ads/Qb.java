package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class Qb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapf f11784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qb(zzapf zzapfVar) {
        this.f11784a = zzapfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f11784a.zzdso;
        if (atomicBoolean.get()) {
            zzbbd.e("Timed out waiting for WebView to finish loading.");
            this.f11784a.cancel();
        }
    }
}
