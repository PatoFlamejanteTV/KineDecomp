package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ma, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0246ma implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f4413a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0254qa f4414b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0246ma(RunnableC0254qa runnableC0254qa, eb ebVar) {
        this.f4414b = runnableC0254qa;
        this.f4413a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4414b.f4436b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsAcceptOfCompositeWithID for compositeCtrlState.compositeId= " + this.f4413a.f4355a);
            Za.a("csdk_android_dcx", "AdobeDCXController.restartSyncCycle", "controllerRequestsAcceptOfCompositeWithID", this.f4413a.f4355a);
            RunnableC0254qa runnableC0254qa = this.f4414b;
            runnableC0254qa.f4436b.a(runnableC0254qa.f4435a, this.f4413a.f4355a);
        }
    }
}
