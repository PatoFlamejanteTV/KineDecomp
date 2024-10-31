package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity;

/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ca implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity.b f5605a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(AdobeUXMobilePackageItemOneUpViewerActivity.b bVar) {
        this.f5605a = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Intent v = ((AdobeUXMobilePackageItemOneUpViewerActivity) this.f5605a.getActivity()).v();
        if (v == null) {
            return true;
        }
        this.f5605a.startActivity(v);
        return true;
    }
}
