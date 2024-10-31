package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0785k implements zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f10090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0785k(CountDownLatch countDownLatch) {
        this.f10090a = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        this.f10090a.countDown();
        zzbggVar.getView().setVisibility(0);
    }
}
