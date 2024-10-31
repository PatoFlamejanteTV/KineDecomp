package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.i */
/* loaded from: classes.dex */
public class RunnableC0565i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeAuthException f7283a;

    /* renamed from: b */
    final /* synthetic */ C0628y f7284b;

    public RunnableC0565i(C0628y c0628y, AdobeAuthException adobeAuthException) {
        this.f7284b = c0628y;
        this.f7283a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7284b.f7470a.a((sd) this.f7283a);
    }
}
