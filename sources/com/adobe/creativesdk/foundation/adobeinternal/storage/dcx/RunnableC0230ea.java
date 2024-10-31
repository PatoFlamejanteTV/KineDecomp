package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ea, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0230ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4351a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4352b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4353c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4354d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0230ea(Aa aa, nb nbVar, String str, Aa aa2) {
        this.f4354d = aa;
        this.f4351a = nbVar;
        this.f4352b = str;
        this.f4353c = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4351a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsDeleteOfCompositeWithID for compositeID= " + this.f4352b);
        Za.a("csdk_android_dcx", "AdobeDCXController.dispatchRequestForCompositeWithControllerState", "controllerRequestsDeleteOfCompositeWithID", this.f4352b);
        this.f4351a.d(this.f4353c, this.f4352b);
    }
}
