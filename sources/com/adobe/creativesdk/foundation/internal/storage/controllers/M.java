package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeShowUploadTasksActivity;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
public class M implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.c f5716a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f5717b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.EndPointType f5718c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f5719d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f5720e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity.b f5721f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(AdobeShowUploadTasksActivity.b bVar, AdobeShowUploadTasksActivity.c cVar, AdobeUploadAssetData adobeUploadAssetData, AdobeShowUploadTasksActivity.EndPointType endPointType, String str, int i) {
        this.f5721f = bVar;
        this.f5716a = cVar;
        this.f5717b = adobeUploadAssetData;
        this.f5718c = endPointType;
        this.f5719d = str;
        this.f5720e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Boolean bool;
        bool = this.f5716a.y;
        if (bool.booleanValue() || this.f5721f.a(this.f5717b)) {
            this.f5721f.a(this.f5718c, this.f5719d, this.f5717b);
            this.f5716a.x = true;
            this.f5716a.y = false;
            this.f5721f.a(this.f5717b, this.f5716a, this.f5718c, this.f5719d, this.f5720e);
        }
    }
}
