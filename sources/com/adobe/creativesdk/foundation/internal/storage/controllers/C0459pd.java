package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0449nd;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: MobileCreationPackageItemsFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.pd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0459pd implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0449nd.b f6378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0459pd(C0449nd.b bVar) {
        this.f6378a = bVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        C0449nd.c cVar = this.f6378a.f6352a;
        if (cVar == null) {
            return;
        }
        cVar.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, adobeCSDKException.getData()));
    }
}
