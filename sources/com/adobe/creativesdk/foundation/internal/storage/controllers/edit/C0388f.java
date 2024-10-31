package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import java.util.HashMap;

/* compiled from: AdobeAssetEditActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0388f implements J {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeAssetEditActivity f6039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0388f(AdobeAssetEditActivity adobeAssetEditActivity) {
        this.f6039a = adobeAssetEditActivity;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.J
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.J
    public void a(double d2) {
        com.adobe.creativesdk.foundation.internal.notification.b a2 = com.adobe.creativesdk.foundation.internal.notification.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("EDIT_PROGRESS_KEY", Double.valueOf(d2));
        C0394l.a(d2);
        a2.a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAssetEditProgressChanged, hashMap));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.J
    public void onComplete() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED);
    }
}
