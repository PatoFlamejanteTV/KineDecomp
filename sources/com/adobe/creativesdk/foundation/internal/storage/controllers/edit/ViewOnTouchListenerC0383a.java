package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: AdobeAssetEditActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0383a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetEditActivity f6034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnTouchListenerC0383a(AdobeAssetEditActivity adobeAssetEditActivity) {
        this.f6034a = adobeAssetEditActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.f6034a.z();
        return z;
    }
}
