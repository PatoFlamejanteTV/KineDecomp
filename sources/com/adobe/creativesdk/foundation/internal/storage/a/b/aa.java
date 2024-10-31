package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f5374a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeDCXException f5375b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5376c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ra raVar, ib ibVar, AdobeDCXException adobeDCXException) {
        this.f5376c = raVar;
        this.f5374a = ibVar;
        this.f5375b = adobeDCXException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5374a.a(null, this.f5375b);
    }
}
