package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesEditFragment.java */
/* loaded from: classes.dex */
public class y implements J {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f6082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(B b2) {
        this.f6082a = b2;
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
        C0358a a2 = C0358a.a();
        C0394l.a(false);
        a2.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED);
    }
}
