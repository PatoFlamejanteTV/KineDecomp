package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeShowUploadTasksActivity;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
class O implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.c f5739a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.e f5740b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5741c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.b f5742d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(AdobeShowUploadTasksActivity.b bVar, AdobeShowUploadTasksActivity.c cVar, AdobeShowUploadTasksActivity.e eVar, int i) {
        this.f5742d = bVar;
        this.f5739a = cVar;
        this.f5740b = eVar;
        this.f5741c = i;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeShowUploadTasksActivity.b bVar = this.f5742d;
        AdobeShowUploadTasksActivity.c cVar = this.f5739a;
        AdobeShowUploadTasksActivity.e eVar = this.f5740b;
        bVar.a((AdobeUploadAssetData) obj, cVar, eVar.f5525a, eVar.f5527c, this.f5741c);
    }
}
