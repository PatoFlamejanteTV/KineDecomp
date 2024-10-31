package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class O implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f5330a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f5331b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5332c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(ra raVar, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f5332c = raVar;
        this.f5330a = bVar;
        this.f5331b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5330a.a(this.f5331b);
    }
}
