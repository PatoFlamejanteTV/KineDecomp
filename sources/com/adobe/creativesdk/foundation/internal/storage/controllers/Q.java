package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* compiled from: AdobeStorageSettingsFragment.java */
/* loaded from: classes.dex */
class Q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ U f5789a;

    public Q(U u) {
        this.f5789a = u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.setEnabled(false);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ASSET_BROWSER_USER_SIGNOUT);
    }
}
