package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask;

/* compiled from: AsyncTask.java */
/* loaded from: classes3.dex */
class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f26953a;

    /* renamed from: b */
    final /* synthetic */ AsyncTask.c f26954b;

    public e(AsyncTask.c cVar, Runnable runnable) {
        this.f26954b = cVar;
        this.f26953a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f26953a.run();
        } finally {
            this.f26954b.a();
        }
    }
}
