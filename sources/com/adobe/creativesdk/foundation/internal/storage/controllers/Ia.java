package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ia implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Menu f5664a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f5665b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f5666c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity f5667d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity, Menu menu, int i, Activity activity) {
        this.f5667d = adobeUXPhotoAssetOneUpViewerActivity;
        this.f5664a = menu;
        this.f5665b = i;
        this.f5666c = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5667d.B.a() != null) {
            AdobePhotoAsset b2 = this.f5667d.A.b(this.f5667d.f6156d);
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(b2);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_PHOTOS);
            this.f5667d.B.a().a(this.f5664a.getItem(this.f5665b).getItemId(), aVar, this.f5666c, (AdobeCloud) null);
        }
    }
}
