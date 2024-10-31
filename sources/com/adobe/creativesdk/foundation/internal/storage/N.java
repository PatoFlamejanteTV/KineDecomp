package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class N implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(U u) {
        this.f5246a = u;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        ja jaVar;
        ja jaVar2;
        this.f5246a.f5259d = true;
        jaVar = this.f5246a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5246a.f5256a;
            jaVar2.a(adobeCSDKException);
        }
    }
}
