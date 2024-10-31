package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.kc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0430kc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc.c f6167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0430kc(C0415hc.c cVar) {
        this.f6167a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0415hc.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_NOTIFICATION, (Object) null);
    }
}
