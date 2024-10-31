package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0252pa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f4430a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0254qa f4431b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0252pa(RunnableC0254qa runnableC0254qa, eb ebVar) {
        this.f4431b = runnableC0254qa;
        this.f4430a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4431b.f4436b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsDeleteOfCompositeWithID for compositeCtrlState.compositeId= " + this.f4430a.f4355a);
            Za.a("csdk_android_dcx", "AdobeDCXController.restartSyncCycle", "controllerRequestsDeleteOfCompositeWithID", this.f4430a.f4355a);
            RunnableC0254qa runnableC0254qa = this.f4431b;
            runnableC0254qa.f4436b.d(runnableC0254qa.f4435a, this.f4430a.f4355a);
        }
    }
}
