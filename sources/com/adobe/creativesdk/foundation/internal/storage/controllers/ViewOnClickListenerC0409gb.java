package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.gb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0409gb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.a f6098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0409gb(AbstractC0414hb.a aVar) {
        this.f6098a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC0414hb.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_NOTIFICATION, (Object) null);
    }
}
