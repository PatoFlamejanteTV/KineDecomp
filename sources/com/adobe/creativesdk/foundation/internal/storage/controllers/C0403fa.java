package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.MediaController;

/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.fa */
/* loaded from: classes.dex */
class C0403fa extends MediaController {

    /* renamed from: a */
    final /* synthetic */ AdobeUXAssetVideoActivity f6093a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0403fa(AdobeUXAssetVideoActivity adobeUXAssetVideoActivity, Context context) {
        super(context);
        this.f6093a = adobeUXAssetVideoActivity;
    }

    @Override // android.widget.MediaController, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            ((Activity) getContext()).finish();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
