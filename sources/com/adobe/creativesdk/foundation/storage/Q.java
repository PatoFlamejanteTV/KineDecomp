package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
class Q implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f7094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s) {
        this.f7094a = s;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeGetRendition:for video", String.format("Failed to get video metadata for %s: %s", this.f7094a.f7107a.name, adobeCSDKException));
    }
}
