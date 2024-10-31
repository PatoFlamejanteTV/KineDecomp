package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* loaded from: classes2.dex */
final class Uc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Future f11871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uc(zzatq zzatqVar, Future future) {
        this.f11871a = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11871a.isDone()) {
            return;
        }
        this.f11871a.cancel(true);
    }
}
