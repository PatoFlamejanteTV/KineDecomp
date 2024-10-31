package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f5389a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeDCXException f5390b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5391c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(ra raVar, ib ibVar, AdobeDCXException adobeDCXException) {
        this.f5391c = raVar;
        this.f5389a = ibVar;
        this.f5390b = adobeDCXException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5389a.a(null, this.f5390b);
    }
}
