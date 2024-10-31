package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.j;

/* compiled from: PriorityAsyncTask.java */
/* loaded from: classes3.dex */
class i<Result> extends l<Result> {

    /* renamed from: b */
    final /* synthetic */ j.a f26955b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f26955b = aVar;
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public g a() {
        j jVar;
        jVar = this.f26955b.f26957b;
        return jVar;
    }
}
