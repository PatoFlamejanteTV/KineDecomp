package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import java.util.Observable;
import java.util.Observer;

/* compiled from: PhotosAssetsFragment.java */
/* loaded from: classes.dex */
class Dd implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fd f5628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dd(Fd fd) {
        this.f5628a = fd;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t tVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t) cVar.b().get("upload_session_key");
        if ((tVar.b() instanceof AdobePhotoCollection) && this.f5628a.R.isSameLocation((AdobePhotoCollection) tVar.b())) {
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted) {
                this.f5628a.b((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<AdobePhotoCollection>) tVar);
                return;
            }
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete) {
                this.f5628a.Xa();
                this.f5628a.a(tVar);
            } else if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled) {
                this.f5628a.Xa();
            }
        }
    }
}
