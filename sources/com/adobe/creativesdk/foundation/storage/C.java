package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class C implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeAuthException f6934a;

    /* renamed from: b */
    final /* synthetic */ D f6935b;

    public C(D d2, AdobeAuthException adobeAuthException) {
        this.f6935b = d2;
        this.f6934a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6935b.f6945a.a((sd) this.f6934a);
    }
}
