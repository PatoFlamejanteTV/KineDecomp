package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class D implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f5296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f5297b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(ra raVar, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f5298c = raVar;
        this.f5296a = bVar;
        this.f5297b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5296a.a(this.f5297b);
    }
}
