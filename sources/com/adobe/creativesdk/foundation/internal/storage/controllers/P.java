package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeShowUploadTasksActivity;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
class P implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.c f5778a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.e f5779b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5780c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.b f5781d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(AdobeShowUploadTasksActivity.b bVar, AdobeShowUploadTasksActivity.c cVar, AdobeShowUploadTasksActivity.e eVar, int i) {
        this.f5781d = bVar;
        this.f5778a = cVar;
        this.f5779b = eVar;
        this.f5780c = i;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeShowUploadTasksActivity.b bVar = this.f5781d;
        AdobeShowUploadTasksActivity.c cVar = this.f5778a;
        AdobeShowUploadTasksActivity.e eVar = this.f5779b;
        bVar.a((AdobeUploadAssetData) obj, cVar, eVar.f5525a, eVar.f5527c, this.f5780c);
    }
}
