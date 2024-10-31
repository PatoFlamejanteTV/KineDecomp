package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ImageButton;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class W implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity) {
        this.f5879a = adobeUXAssetOneUpViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = this.f5879a;
        C0533a a2 = adobeUXAssetOneUpViewerActivity.E.a(adobeUXAssetOneUpViewerActivity.f6156d);
        imageButton = this.f5879a.B;
        if (!imageButton.isSelected()) {
            imageButton3 = this.f5879a.B;
            imageButton3.setSelected(true);
            this.f5879a.E.a((AdobeAssetFile) a2);
        } else {
            imageButton2 = this.f5879a.B;
            imageButton2.setSelected(false);
            this.f5879a.E.c((AdobeAssetFile) a2);
        }
    }
}
