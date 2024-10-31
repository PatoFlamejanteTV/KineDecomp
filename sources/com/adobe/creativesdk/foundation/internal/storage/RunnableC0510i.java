package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.sd;

/* compiled from: AdobeAssetFileInternal.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.i */
/* loaded from: classes.dex */
class RunnableC0510i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ sd f6589a;

    /* renamed from: b */
    final /* synthetic */ AdobeAssetException f6590b;

    public RunnableC0510i(sd sdVar, AdobeAssetException adobeAssetException) {
        this.f6589a = sdVar;
        this.f6590b = adobeAssetException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6589a.a((sd) this.f6590b);
    }
}
