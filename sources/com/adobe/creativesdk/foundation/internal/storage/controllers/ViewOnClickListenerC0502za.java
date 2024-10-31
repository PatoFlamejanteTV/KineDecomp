package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.C0515n;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.za, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnClickListenerC0502za implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity f6554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0502za(AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity) {
        this.f6554a = adobeUXMobilePackageItemOneUpViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity = this.f6554a;
        AdobeAssetFile a2 = adobeUXMobilePackageItemOneUpViewerActivity.B.a(adobeUXMobilePackageItemOneUpViewerActivity.f6156d);
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
        C0515n.c();
        C0515n.a(this.f6554a.B.b(), a2);
        this.f6554a.setResult(-1, new Intent());
        this.f6554a.finish();
    }
}
