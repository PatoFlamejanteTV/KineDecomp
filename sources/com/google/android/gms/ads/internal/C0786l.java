package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.ads.internal.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0786l implements zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f10091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0786l(CountDownLatch countDownLatch) {
        this.f10091a = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbbd.zzeo("Adapter returned an ad, but assets substitution failed");
        this.f10091a.countDown();
        zzbggVar.destroy();
    }
}
