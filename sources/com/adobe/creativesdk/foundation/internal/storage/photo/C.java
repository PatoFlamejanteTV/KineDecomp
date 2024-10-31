package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class C implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f6645a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f6646b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f6647c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(F f2, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f6647c = f2;
        this.f6645a = bVar;
        this.f6646b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6645a.a(this.f6646b);
    }
}
