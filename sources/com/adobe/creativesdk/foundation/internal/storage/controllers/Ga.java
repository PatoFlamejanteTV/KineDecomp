package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ga implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity f5649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity) {
        this.f5649a = adobeUXPhotoAssetOneUpViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdobePhotoAsset b2 = this.f5649a.A.b(this.f5649a.f6156d);
        if (!this.f5649a.A.i()) {
            if (!this.f5649a.A.b(b2)) {
                this.f5649a.A.a(b2);
            }
        } else if (this.f5649a.A.e() == 0) {
            this.f5649a.A.a(b2);
        }
        this.f5649a.setResult(-1, new Intent());
        this.f5649a.finish();
    }
}
