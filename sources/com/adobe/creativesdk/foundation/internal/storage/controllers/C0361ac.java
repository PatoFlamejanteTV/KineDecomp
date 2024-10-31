package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ac, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0361ac implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc f5942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0361ac(C0415hc c0415hc) {
        this.f5942a = c0415hc;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t) cVar.b().get("upload_session_key");
        if ((tVar.b() instanceof C0578la) && this.f5942a.Ga().p(tVar.b())) {
            if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted) {
                this.f5942a.d(tVar);
            } else if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete) {
                this.f5942a.c(tVar);
            } else if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled) {
                this.f5942a.b(tVar);
            }
        }
    }
}
