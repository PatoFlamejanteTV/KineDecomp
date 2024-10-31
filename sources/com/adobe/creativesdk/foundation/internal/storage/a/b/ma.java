package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class ma implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f5446a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f5447b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5448c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ma(ra raVar, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f5448c = raVar;
        this.f5446a = bVar;
        this.f5447b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5446a.a(this.f5447b);
    }
}
