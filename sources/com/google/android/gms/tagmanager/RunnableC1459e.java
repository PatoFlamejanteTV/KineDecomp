package com.google.android.gms.tagmanager;

import java.util.List;

/* renamed from: com.google.android.gms.tagmanager.e */
/* loaded from: classes2.dex */
final class RunnableC1459e implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ List f14196a;

    /* renamed from: b */
    private final /* synthetic */ long f14197b;

    /* renamed from: c */
    private final /* synthetic */ C1458d f14198c;

    public RunnableC1459e(C1458d c1458d, List list, long j) {
        this.f14198c = c1458d;
        this.f14196a = list;
        this.f14197b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14198c.b(this.f14196a, this.f14197b);
    }
}
