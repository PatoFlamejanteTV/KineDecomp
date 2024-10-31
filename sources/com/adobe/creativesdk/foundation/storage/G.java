package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdobeAuthException f6983a;

    /* renamed from: b */
    final /* synthetic */ H f6984b;

    public G(H h2, AdobeAuthException adobeAuthException) {
        this.f6984b = h2;
        this.f6983a = adobeAuthException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6984b.f6997a.a((sd) this.f6983a);
    }
}
