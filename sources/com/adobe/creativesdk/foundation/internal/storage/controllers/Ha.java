package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ImageButton;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ha implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity f5656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity) {
        this.f5656a = adobeUXPhotoAssetOneUpViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        AdobePhotoAsset b2 = this.f5656a.A.b(this.f5656a.f6156d);
        imageButton = this.f5656a.z;
        if (!imageButton.isSelected()) {
            imageButton3 = this.f5656a.z;
            imageButton3.setSelected(true);
            this.f5656a.A.a(b2);
        } else {
            imageButton2 = this.f5656a.z;
            imageButton2.setSelected(false);
            this.f5656a.A.c(b2);
        }
    }
}
