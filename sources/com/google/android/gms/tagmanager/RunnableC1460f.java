package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;

/* renamed from: com.google.android.gms.tagmanager.f */
/* loaded from: classes2.dex */
final class RunnableC1460f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaq f14199a;

    /* renamed from: b */
    private final /* synthetic */ C1458d f14200b;

    public RunnableC1460f(C1458d c1458d, zzaq zzaqVar) {
        this.f14200b = c1458d;
        this.f14199a = zzaqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<DataLayer.a> b2;
        zzaq zzaqVar = this.f14199a;
        b2 = this.f14200b.b();
        zzaqVar.a(b2);
    }
}
