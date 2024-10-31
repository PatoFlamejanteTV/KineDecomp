package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import java.util.Observable;
import java.util.Observer;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
class Ec implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ec(Jc jc) {
        this.f5631a = jc;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t tVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t) cVar.b().get("upload_session_key");
        if ((tVar.b() instanceof com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa) && this.f5631a.U.a((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa) tVar.b())) {
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted) {
                this.f5631a.b((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa>) tVar);
                return;
            }
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete) {
                this.f5631a.k("application/vnd.adobe.element.image+dcx");
                this.f5631a.Za();
                this.f5631a.a(tVar);
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d(true);
                this.f5631a.a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_ITEM_EDIT, (Object) null);
                return;
            }
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled) {
                this.f5631a.Za();
            }
        }
    }
}
