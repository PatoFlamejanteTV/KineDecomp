package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* loaded from: classes.dex */
public class Z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4287a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ nb f4288b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4289c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f4290d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeDCXSyncPhase f4291e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f4292f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Aa f4293g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(Aa aa, String str, nb nbVar, Aa aa2, AdobeCSDKException adobeCSDKException, AdobeDCXSyncPhase adobeDCXSyncPhase, boolean z) {
        this.f4293g = aa;
        this.f4287a = str;
        this.f4288b = nbVar;
        this.f4289c = aa2;
        this.f4290d = adobeCSDKException;
        this.f4291e = adobeDCXSyncPhase;
        this.f4292f = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "CSDK::Release::DCX", "calling controllerRequestsClientHandleError for compositeID= " + this.f4287a);
        this.f4288b.a(this.f4289c, this.f4290d, this.f4287a, this.f4291e, this.f4292f);
    }
}
