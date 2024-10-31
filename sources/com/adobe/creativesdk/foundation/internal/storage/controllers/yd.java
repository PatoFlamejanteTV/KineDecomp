package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.storage.controllers.xd;

/* compiled from: PhotosAssetListView.java */
/* loaded from: classes.dex */
class yd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z f6550a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f6551b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ xd.b f6552c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yd(xd.b bVar, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar, AdobeUploadAssetData adobeUploadAssetData) {
        this.f6552c = bVar;
        this.f6550a = zVar;
        this.f6551b = adobeUploadAssetData;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6550a.a(this.f6551b.c());
    }
}
