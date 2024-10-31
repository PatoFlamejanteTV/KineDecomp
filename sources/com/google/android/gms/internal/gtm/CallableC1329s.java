package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.s */
/* loaded from: classes2.dex */
public final class CallableC1329s implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ zzbh f13289a;

    public CallableC1329s(zzbh zzbhVar) {
        this.f13289a = zzbhVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f13289a.zzej();
    }
}
