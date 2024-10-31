package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ pb f5341a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeDCXException f5342b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5343c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(ra raVar, pb pbVar, AdobeDCXException adobeDCXException) {
        this.f5343c = raVar;
        this.f5341a = pbVar;
        this.f5342b = adobeDCXException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5341a.a(null, this.f5342b);
    }
}
