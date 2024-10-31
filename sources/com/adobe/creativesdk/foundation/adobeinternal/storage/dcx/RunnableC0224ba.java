package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ba, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0224ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4315a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4316b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4317c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4318d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Aa f4319e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0224ba(Aa aa, nb nbVar, String str, Aa aa2, String str2) {
        this.f4319e = aa;
        this.f4315a = nbVar;
        this.f4316b = str;
        this.f4317c = aa2;
        this.f4318d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4315a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsPullOfCompositeWithID for compositeID= " + this.f4316b);
        Za.a("csdk_android_dcx", "AdobeDCXController.dispatchRequestForCompositeWithControllerState", "controllerRequestsPullOfCompositeWithID", this.f4316b);
        this.f4315a.a(this.f4317c, this.f4316b, this.f4318d);
    }
}
