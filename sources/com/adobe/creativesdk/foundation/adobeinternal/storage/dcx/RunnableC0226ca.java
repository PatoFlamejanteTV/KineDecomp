package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ca, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0226ca implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4330a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4331b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4332c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4333d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0226ca(Aa aa, nb nbVar, String str, Aa aa2) {
        this.f4333d = aa;
        this.f4330a = nbVar;
        this.f4331b = str;
        this.f4332c = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4330a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsAcceptOfCompositeWithID for compositeID= " + this.f4331b);
        Za.a("csdk_android_dcx", "AdobeDCXController.dispatchRequestForCompositeWithControllerState", "controllerRequestsAcceptOfCompositeWithID", this.f4331b);
        this.f4330a.a(this.f4332c, this.f4331b);
    }
}
