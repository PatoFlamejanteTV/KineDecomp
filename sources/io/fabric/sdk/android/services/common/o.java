package io.fabric.sdk.android.services.common;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes3.dex */
class o extends j {

    /* renamed from: a */
    final /* synthetic */ Runnable f26898a;

    /* renamed from: b */
    final /* synthetic */ p f26899b;

    public o(p pVar, Runnable runnable) {
        this.f26899b = pVar;
        this.f26898a = runnable;
    }

    @Override // io.fabric.sdk.android.services.common.j
    public void onRun() {
        this.f26898a.run();
    }
}
