package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class D implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f5227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(I i) {
        this.f5227a = i;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        ia iaVar;
        ia iaVar2;
        this.f5227a.f5238e = true;
        iaVar = this.f5227a.f5235b;
        if (iaVar != null) {
            iaVar2 = this.f5227a.f5235b;
            iaVar2.a(adobeCSDKException);
        }
        this.f5227a.f5237d = false;
    }
}
