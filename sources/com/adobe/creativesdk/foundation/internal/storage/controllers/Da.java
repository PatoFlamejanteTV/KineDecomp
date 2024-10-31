package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.photoview.g;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Da implements g.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity.b f5609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(AdobeUXMobilePackageItemOneUpViewerActivity.b bVar) {
        this.f5609a = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.g.e
    public void a(View view, float f2, float f3) {
        if (this.f5609a.getActivity() != null) {
            ((AdobeUXMobilePackageItemOneUpViewerActivity) this.f5609a.getActivity()).w();
        }
    }
}
