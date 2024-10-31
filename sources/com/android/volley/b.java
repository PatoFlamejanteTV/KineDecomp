package com.android.volley;

/* compiled from: CacheDispatcher.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Request f8041a;

    /* renamed from: b */
    final /* synthetic */ c f8042b;

    public b(c cVar, Request request) {
        this.f8042b = cVar;
        this.f8041a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f8042b.f8045c.put(this.f8041a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
