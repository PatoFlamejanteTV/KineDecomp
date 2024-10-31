package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class V implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity) {
        this.f5871a = adobeUXAssetOneUpViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = this.f5871a;
        C0533a a2 = adobeUXAssetOneUpViewerActivity.E.a(adobeUXAssetOneUpViewerActivity.f6156d);
        if (this.f5871a.E.g()) {
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) a2;
            if (!this.f5871a.E.b(adobeAssetFile)) {
                this.f5871a.E.a(adobeAssetFile);
            }
        } else if (this.f5871a.E.d() == 0) {
            this.f5871a.E.a((AdobeAssetFile) a2);
        }
        this.f5871a.setResult(-1, new Intent());
        this.f5871a.finish();
    }
}
