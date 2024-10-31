package com.google.android.gms.analytics.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class u implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzn f720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(zzn zznVar) {
        this.f720a = zznVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Exception {
        return this.f720a.d();
    }
}
