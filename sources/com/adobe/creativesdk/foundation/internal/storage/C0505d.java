package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.ArrayList;

/* compiled from: AdobeAssetDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0505d implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f6563a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0506e f6564b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0505d(C0506e c0506e, ArrayList arrayList) {
        this.f6564b = c0506e;
        this.f6563a = arrayList;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        C0506e c0506e = this.f6564b;
        int[] iArr = c0506e.f6567a;
        iArr[0] = iArr[0] + 1;
        ha e2 = c0506e.f6570d.e();
        if (adobeCSDKException instanceof AdobeAssetException) {
            AdobeAssetException adobeAssetException = (AdobeAssetException) adobeCSDKException;
            if (adobeAssetException.getErrorCode().getValue() == 404) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetDataSource.loadNextPage", String.format("Failed to load the package metadata: %s", adobeCSDKException.getMessage()));
            } else if (e2 != null) {
                e2.a(adobeAssetException);
            }
        }
        int size = this.f6563a.size();
        C0506e c0506e2 = this.f6564b;
        if (size == c0506e2.f6567a[0]) {
            c0506e2.a();
        }
    }
}
