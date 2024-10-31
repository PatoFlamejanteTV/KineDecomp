package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPackage.java */
/* loaded from: classes.dex */
public class Wa implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7154a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ya f7155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(Ya ya, c.a.a.a.c cVar) {
        this.f7155b = ya;
        this.f7154a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPackage.loadMetadata", String.format("Failed to get the manifest for %s.", this.f7155b.GUID));
        this.f7154a.a(adobeCSDKException);
    }
}
