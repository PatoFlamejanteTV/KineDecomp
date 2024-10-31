package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class H implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f5233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(I i) {
        this.f5233a = i;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        ia iaVar;
        ia iaVar2;
        this.f5233a.f5238e = true;
        iaVar = this.f5233a.f5235b;
        if (iaVar != null) {
            iaVar2 = this.f5233a.f5235b;
            iaVar2.b(adobeCSDKException);
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, I.class.getSimpleName(), "Failed to get more assets");
    }
}
