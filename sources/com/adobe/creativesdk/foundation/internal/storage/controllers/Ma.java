package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXPhotoAssetOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.photoview.g;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ma implements g.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity f5722a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity.c f5723b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(AdobeUXPhotoAssetOneUpViewerActivity.c cVar, AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity) {
        this.f5723b = cVar;
        this.f5722a = adobeUXPhotoAssetOneUpViewerActivity;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.g.e
    public void a(View view, float f2, float f3) {
        if (this.f5722a.A.d() != null) {
            this.f5722a.A.d().e();
        }
    }
}
