package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.va, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0263va implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC0265wa f4467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0263va(RunnableC0265wa runnableC0265wa) {
        this.f4467a = runnableC0265wa;
    }

    @Override // java.lang.Runnable
    public void run() {
        RunnableC0265wa runnableC0265wa = this.f4467a;
        nb nbVar = runnableC0265wa.f4471a;
        if (nbVar != null) {
            runnableC0265wa.f4472b.f4401a = nbVar.e(runnableC0265wa.f4473c, runnableC0265wa.f4474d);
        }
        this.f4467a.f4475e.lock();
        try {
            this.f4467a.f4472b.f4402b = true;
            this.f4467a.f4476f.signal();
        } finally {
            this.f4467a.f4475e.unlock();
        }
    }
}
