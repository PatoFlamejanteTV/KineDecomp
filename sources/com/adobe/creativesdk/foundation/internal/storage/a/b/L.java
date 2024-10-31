package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeCSDKException f5320a;

    /* renamed from: b */
    final /* synthetic */ M f5321b;

    public L(M m, AdobeCSDKException adobeCSDKException) {
        this.f5321b = m;
        this.f5320a = adobeCSDKException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5321b.f5322a.a(this.f5320a);
    }
}
