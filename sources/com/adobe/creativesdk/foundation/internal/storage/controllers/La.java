package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXPhotoAssetOneUpViewerActivity;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class La implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity.c f5712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(AdobeUXPhotoAssetOneUpViewerActivity.c cVar) {
        this.f5712a = cVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Intent v = ((AdobeUXPhotoAssetOneUpViewerActivity) this.f5712a.getActivity()).v();
        if (v == null) {
            return true;
        }
        this.f5712a.startActivity(v);
        return true;
    }
}
