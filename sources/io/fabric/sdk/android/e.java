package io.fabric.sdk.android;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric.java */
/* loaded from: classes3.dex */
public class e implements j {

    /* renamed from: a */
    final CountDownLatch f26839a;

    /* renamed from: b */
    final /* synthetic */ int f26840b;

    /* renamed from: c */
    final /* synthetic */ f f26841c;

    public e(f fVar, int i) {
        this.f26841c = fVar;
        this.f26840b = i;
        this.f26839a = new CountDownLatch(this.f26840b);
    }

    @Override // io.fabric.sdk.android.j
    public void a(Object obj) {
        AtomicBoolean atomicBoolean;
        j jVar;
        this.f26839a.countDown();
        if (this.f26839a.getCount() == 0) {
            atomicBoolean = this.f26841c.l;
            atomicBoolean.set(true);
            jVar = this.f26841c.f26848g;
            jVar.a((j) this.f26841c);
        }
    }

    @Override // io.fabric.sdk.android.j
    public void a(Exception exc) {
        j jVar;
        jVar = this.f26841c.f26848g;
        jVar.a(exc);
    }
}
