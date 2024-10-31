package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.la, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0244la implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f4409a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0254qa f4410b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0244la(RunnableC0254qa runnableC0254qa, eb ebVar) {
        this.f4410b = runnableC0254qa;
        this.f4409a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4410b.f4436b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsPushOfCompositeWithID for compositeCtrlState.compositeId= " + this.f4409a.f4355a);
            Za.a("csdk_android_dcx", "AdobeDCXController.restartSyncCycle", "controllerRequestsPushOfCompositeWithID", this.f4409a.f4355a);
            RunnableC0254qa runnableC0254qa = this.f4410b;
            runnableC0254qa.f4436b.b(runnableC0254qa.f4435a, this.f4409a.f4355a);
        }
    }
}
