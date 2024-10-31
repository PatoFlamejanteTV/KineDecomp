package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class CallableC1306g implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzae f13232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC1306g(zzae zzaeVar) {
        this.f13232a = zzaeVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        C1320n c1320n;
        c1320n = this.f13232a.zzvu;
        c1320n.b();
        return null;
    }
}
