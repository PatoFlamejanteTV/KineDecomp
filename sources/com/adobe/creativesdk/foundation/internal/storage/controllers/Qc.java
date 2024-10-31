package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Qc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z f5792a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f5793b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Sc.a f5794c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qc(Sc.a aVar, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar, AdobeUploadAssetData adobeUploadAssetData) {
        this.f5794c = aVar;
        this.f5792a = zVar;
        this.f5793b = adobeUploadAssetData;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5792a.a(this.f5793b.d());
        this.f5792a.a(this.f5793b.c());
    }
}
