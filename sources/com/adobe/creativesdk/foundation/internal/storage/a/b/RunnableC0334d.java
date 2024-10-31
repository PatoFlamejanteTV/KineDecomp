package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.d */
/* loaded from: classes.dex */
public class RunnableC0334d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeAuthException f5387a;

    /* renamed from: b */
    final /* synthetic */ C0335e f5388b;

    public RunnableC0334d(C0335e c0335e, AdobeAuthException adobeAuthException) {
        this.f5388b = c0335e;
        this.f5387a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        xa xaVar = this.f5388b.f5393b;
        if (xaVar != null) {
            xaVar.a(this.f5387a);
        }
    }
}
