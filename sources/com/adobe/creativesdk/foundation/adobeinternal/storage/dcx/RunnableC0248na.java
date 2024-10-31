package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.na, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0248na implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f4418a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RunnableC0254qa f4419b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0248na(RunnableC0254qa runnableC0254qa, eb ebVar) {
        this.f4419b = runnableC0254qa;
        this.f4418a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4419b.f4436b != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsPullOfCompositeWithID for compositeCtrlState.compositeId= " + this.f4418a.f4355a);
            Za.a("csdk_android_dcx", "AdobeDCXController.restartSyncCycle", "controllerRequestsPullOfCompositeWithID", this.f4418a.f4355a);
            RunnableC0254qa runnableC0254qa = this.f4419b;
            nb nbVar = runnableC0254qa.f4436b;
            Aa aa = runnableC0254qa.f4435a;
            eb ebVar = this.f4418a;
            nbVar.a(aa, ebVar.f4355a, ebVar.f4356b);
        }
    }
}
