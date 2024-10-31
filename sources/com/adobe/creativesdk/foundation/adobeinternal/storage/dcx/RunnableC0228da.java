package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.da, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0228da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4342a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4343b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4344c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4345d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0228da(Aa aa, nb nbVar, String str, Aa aa2) {
        this.f4345d = aa;
        this.f4342a = nbVar;
        this.f4343b = str;
        this.f4344c = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4342a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsResolveOfCompositeWithID for compositeID= " + this.f4343b);
        Za.a("csdk_android_dcx", "AdobeDCXController.dispatchRequestForCompositeWithControllerState", "controllerRequestsResolveOfCompositeWithID", this.f4343b);
        this.f4342a.c(this.f4344c, this.f4343b);
    }
}
