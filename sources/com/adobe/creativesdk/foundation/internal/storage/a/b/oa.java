package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class oa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f5456a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f5457b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5458c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public oa(ra raVar, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f5458c = raVar;
        this.f5456a = bVar;
        this.f5457b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5456a.a(this.f5457b);
    }
}
