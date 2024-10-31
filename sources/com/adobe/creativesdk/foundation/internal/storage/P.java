package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
class P implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f5250a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f5251b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(U u, c.a.a.a.c cVar) {
        this.f5251b = u;
        this.f5250a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f5250a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, U.class.getSimpleName(), "Failed to retrieve the collection");
        }
    }
}
