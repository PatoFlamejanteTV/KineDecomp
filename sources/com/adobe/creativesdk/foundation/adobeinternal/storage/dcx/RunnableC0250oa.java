package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.oa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0250oa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f4422a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0254qa f4423b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0250oa(RunnableC0254qa runnableC0254qa, eb ebVar) {
        this.f4423b = runnableC0254qa;
        this.f4422a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4423b.f4436b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsResolveOfCompositeWithID for compositeCtrlState.compositeId= " + this.f4422a.f4355a);
            Za.a("csdk_android_dcx", "AdobeDCXController.restartSyncCycle", "controllerRequestsResolveOfCompositeWithID", this.f4422a.f4355a);
            RunnableC0254qa runnableC0254qa = this.f4423b;
            runnableC0254qa.f4436b.c(runnableC0254qa.f4435a, this.f4422a.f4355a);
        }
    }
}
