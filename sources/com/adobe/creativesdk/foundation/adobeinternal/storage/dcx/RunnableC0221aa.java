package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.aa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0221aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4306a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4307b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4308c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Aa f4309d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0221aa(Aa aa, nb nbVar, String str, Aa aa2) {
        this.f4309d = aa;
        this.f4306a = nbVar;
        this.f4307b = str;
        this.f4308c = aa2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4306a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsPushOfCompositeWithID for compositeID= " + this.f4307b);
        Za.a("csdk_android_dcx", "AdobeDCXController.dispatchRequestForCompositeWithControllerState", "controllerRequestsPushOfCompositeWithID", this.f4307b);
        this.f4306a.b(this.f4308c, this.f4307b);
    }
}
