package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUploadCreateNewFolderDialogFragment.java */
/* loaded from: classes.dex */
public class j implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f6447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f6447a = kVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        boolean z;
        x xVar;
        z = this.f6447a.o;
        if (z) {
            this.f6447a.p = new x();
            xVar = this.f6447a.p;
            xVar.f6482a = adobeCSDKException;
            return;
        }
        this.f6447a.a(adobeCSDKException);
    }
}
