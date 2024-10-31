package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.pb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ pb f5344a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeDCXException f5345b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(ra raVar, pb pbVar, AdobeDCXException adobeDCXException) {
        this.f5346c = raVar;
        this.f5344a = pbVar;
        this.f5345b = adobeDCXException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5344a.a(null, this.f5345b);
    }
}
