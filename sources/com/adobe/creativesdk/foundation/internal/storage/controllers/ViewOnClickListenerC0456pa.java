package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.storage.C0622wb;

/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.pa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnClickListenerC0456pa implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Menu f6368a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6369b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f6370c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity f6371d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0456pa(AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity, Menu menu, int i, Activity activity) {
        this.f6371d = adobeUXLibraryItemCollectionOneUpViewerActivity;
        this.f6368a = menu;
        this.f6369b = i;
        this.f6370c = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6371d.C.a() != null) {
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = this.f6371d;
            C0622wb a2 = adobeUXLibraryItemCollectionOneUpViewerActivity.B.a(adobeUXLibraryItemCollectionOneUpViewerActivity.f6156d);
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(a2);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_LIBRARY);
            this.f6371d.C.a().a(this.f6368a.getItem(this.f6369b).getItemId(), aVar, this.f6370c, (AdobeCloud) null);
        }
    }
}
