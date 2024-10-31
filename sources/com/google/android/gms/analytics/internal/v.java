package com.google.android.gms.analytics.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzn f721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(zzn zznVar) {
        this.f721a = zznVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Exception {
        String f;
        f = this.f721a.f();
        return f;
    }
}
