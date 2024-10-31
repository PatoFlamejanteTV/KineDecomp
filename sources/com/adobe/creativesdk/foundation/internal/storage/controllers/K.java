package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeShowUploadTasksActivity.java */
/* loaded from: classes.dex */
public class K implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeShowUploadTasksActivity f5699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(AdobeShowUploadTasksActivity adobeShowUploadTasksActivity) {
        this.f5699a = adobeShowUploadTasksActivity;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean z;
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.a() == AdobeInternalNotificationID.AdobeNoUploadSessions) {
            AdobeShowUploadTasksActivity adobeShowUploadTasksActivity = this.f5699a;
            adobeShowUploadTasksActivity.c(adobeShowUploadTasksActivity.getString(c.a.a.a.b.i.upload_activity_title_finished));
            z = AdobeShowUploadTasksActivity.f5512a;
            if (z) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a = false;
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.q.a();
                return;
            }
            return;
        }
        if (cVar.a() == AdobeInternalNotificationID.AdobeUploadSessionsActive) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a = true;
            AdobeShowUploadTasksActivity adobeShowUploadTasksActivity2 = this.f5699a;
            adobeShowUploadTasksActivity2.c(adobeShowUploadTasksActivity2.getString(c.a.a.a.b.i.upload_activity_title_running));
        }
    }
}
