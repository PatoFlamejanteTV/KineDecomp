package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import java.util.Observable;
import java.util.Observer;

/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.fc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0405fc implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc f6095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0405fc(C0415hc c0415hc) {
        this.f6095a = c0415hc;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String O;
        this.f6095a.f6104c.a();
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToCollaborator) {
            this.f6095a.jb();
            com.adobe.creativesdk.foundation.internal.utils.b.a(this.f6095a.getActivity().findViewById(R.id.content), this.f6095a.getResources().getString(c.a.a.a.b.i.adobe_csdk_collaborator));
        } else if (cVar.a() == AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToTargetAsset) {
            if (this.f6095a.ia()) {
                O = this.f6095a.N();
            } else {
                O = this.f6095a.O();
            }
            com.adobe.creativesdk.foundation.internal.utils.b.a(this.f6095a.getActivity().findViewById(R.id.content), O);
            this.f6095a.mb();
        }
    }
}
