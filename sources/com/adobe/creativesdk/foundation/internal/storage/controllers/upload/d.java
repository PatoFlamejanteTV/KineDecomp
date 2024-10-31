package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCreatePhotoCollectionDialogFragment.java */
/* loaded from: classes.dex */
public class d implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f6444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f6444a = eVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCreatePhotoCollectionDialogFragment", "Failed to retrive the catalog.");
        this.f6444a.a(adobeCSDKException);
    }
}
