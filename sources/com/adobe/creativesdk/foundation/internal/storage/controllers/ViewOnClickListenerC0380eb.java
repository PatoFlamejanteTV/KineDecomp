package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.eb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0380eb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t f6014a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f6015b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0380eb(AbstractC0414hb abstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t tVar) {
        this.f6015b = abstractC0414hb;
        this.f6014a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6015b.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_SHOW_ERROR_DETAILS, this.f6014a.c());
    }
}
