package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0399q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.dc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0376dc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0399q f6010a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0415hc f6011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0376dc(C0415hc c0415hc, C0399q c0399q) {
        this.f6011b = c0415hc;
        this.f6010a = c0399q;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6011b.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_SHOW_ERROR_DETAILS, this.f6010a.a());
    }
}
