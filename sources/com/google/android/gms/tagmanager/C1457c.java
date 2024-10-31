package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.tagmanager.c */
/* loaded from: classes2.dex */
public final class C1457c implements zzaq {

    /* renamed from: a */
    private final /* synthetic */ DataLayer f14189a;

    public C1457c(DataLayer dataLayer) {
        this.f14189a = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzaq
    public final void a(List<DataLayer.a> list) {
        CountDownLatch countDownLatch;
        for (DataLayer.a aVar : list) {
            this.f14189a.a((Map<String, Object>) DataLayer.a(aVar.f14171a, aVar.f14172b));
        }
        countDownLatch = this.f14189a.i;
        countDownLatch.countDown();
    }
}
