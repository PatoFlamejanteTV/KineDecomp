package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeShowUploadTasksActivity;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
public class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f5706a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.c f5707b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.EndPointType f5708c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f5709d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f5710e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.b f5711f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(AdobeShowUploadTasksActivity.b bVar, AdobeUploadAssetData adobeUploadAssetData, AdobeShowUploadTasksActivity.c cVar, AdobeShowUploadTasksActivity.EndPointType endPointType, String str, int i) {
        this.f5711f = bVar;
        this.f5706a = adobeUploadAssetData;
        this.f5707b = cVar;
        this.f5708c = endPointType;
        this.f5709d = str;
        this.f5710e = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5711f.b(this.f5706a, this.f5707b, this.f5708c, this.f5709d, this.f5710e);
    }
}
