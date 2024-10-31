package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class F implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f5230a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f5231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(I i, c.a.a.a.c cVar) {
        this.f5231b = i;
        this.f5230a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        c.a.a.a.c cVar = this.f5230a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, I.class.getSimpleName(), "Failed to retrieve the assets.");
        }
    }
}
