package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DataLayer.zzc.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataLayer f2223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DataLayer dataLayer) {
        this.f2223a = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc.zza
    public void a(List<DataLayer.a> list) {
        CountDownLatch countDownLatch;
        for (DataLayer.a aVar : list) {
            this.f2223a.b((Map<String, Object>) this.f2223a.a(aVar.f2204a, aVar.b));
        }
        countDownLatch = this.f2223a.i;
        countDownLatch.countDown();
    }
}
