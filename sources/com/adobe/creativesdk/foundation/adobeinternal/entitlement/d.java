package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f3974a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f3975b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f3976c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h hVar, c.a.a.a.c cVar, AdobeCSDKException adobeCSDKException) {
        this.f3976c = hVar;
        this.f3974a = cVar;
        this.f3975b = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3974a.a(this.f3975b);
    }
}
