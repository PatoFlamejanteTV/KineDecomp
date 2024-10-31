package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeShowUploadTasksActivity;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
class N implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.c f5727a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.e f5728b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5729c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.b f5730d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(AdobeShowUploadTasksActivity.b bVar, AdobeShowUploadTasksActivity.c cVar, AdobeShowUploadTasksActivity.e eVar, int i) {
        this.f5730d = bVar;
        this.f5727a = cVar;
        this.f5728b = eVar;
        this.f5729c = i;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeShowUploadTasksActivity.b bVar = this.f5730d;
        AdobeShowUploadTasksActivity.c cVar = this.f5727a;
        AdobeShowUploadTasksActivity.e eVar = this.f5728b;
        bVar.a((AdobeUploadAssetData) obj, cVar, eVar.f5525a, eVar.f5527c, this.f5729c);
    }
}
