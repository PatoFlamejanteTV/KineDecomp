package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1343z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractC1341y f13328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1343z(AbstractC1341y abstractC1341y) {
        this.f13328a = abstractC1341y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzap zzapVar;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            boolean d2 = this.f13328a.d();
            AbstractC1341y.a(this.f13328a, 0L);
            if (d2) {
                this.f13328a.b();
                return;
            }
            return;
        }
        zzapVar = this.f13328a.f13322b;
        zzapVar.zzcq().a(this);
    }
}
