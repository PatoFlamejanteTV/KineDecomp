package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ya, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnClickListenerC0498ya implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Menu f6539a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6540b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f6541c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity f6542d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0498ya(AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity, Menu menu, int i, Activity activity) {
        this.f6542d = adobeUXMobilePackageItemOneUpViewerActivity;
        this.f6539a = menu;
        this.f6540b = i;
        this.f6541c = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6542d.A.a() != null) {
            AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity = this.f6542d;
            AdobeAssetFile a2 = adobeUXMobilePackageItemOneUpViewerActivity.B.a(adobeUXMobilePackageItemOneUpViewerActivity.f6156d);
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(a2);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_MOBILE_CREATION);
            this.f6542d.A.a().a(this.f6539a.getItem(this.f6540b).getItemId(), aVar, this.f6541c, (AdobeCloud) null);
        }
    }
}
