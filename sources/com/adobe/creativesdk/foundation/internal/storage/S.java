package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
class S implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(U u) {
        this.f5253a = u;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        ja jaVar;
        ja jaVar2;
        this.f5253a.f5259d = true;
        jaVar = this.f5253a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5253a.f5256a;
            jaVar2.c(adobeCSDKException);
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, U.class.getSimpleName(), "Failed to get more collctions");
    }
}
