package com.google.android.gms.internal;

import java.util.concurrent.Future;

/* loaded from: classes.dex */
final class ds implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzin f1512a;
    final /* synthetic */ Future b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(zzin zzinVar, Future future) {
        this.f1512a = zzinVar;
        this.b = future;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1512a.isCancelled()) {
            this.b.cancel(true);
        }
    }
}
