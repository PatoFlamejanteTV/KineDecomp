package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class L implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(U u) {
        this.f5244a = u;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        ja jaVar;
        ja jaVar2;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, U.class.getSimpleName(), "Failed to retrive the catalog.");
        jaVar = this.f5244a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5244a.f5256a;
            jaVar2.b(adobeCSDKException);
        }
    }
}
