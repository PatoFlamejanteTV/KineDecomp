package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ba, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnClickListenerC0364ba implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Menu f5955a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f5956b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f5957c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5958d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0364ba(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity, Menu menu, int i, Activity activity) {
        this.f5958d = adobeUXAssetOneUpViewerActivity;
        this.f5955a = menu;
        this.f5956b = i;
        this.f5957c = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5958d.F.a() != null) {
            AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = this.f5958d;
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) adobeUXAssetOneUpViewerActivity.E.a(adobeUXAssetOneUpViewerActivity.f6156d);
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(adobeAssetFile);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.f5958d.F.a().a(this.f5955a.getItem(this.f5956b).getItemId(), aVar, this.f5957c, this.f5958d.D);
        }
    }
}
