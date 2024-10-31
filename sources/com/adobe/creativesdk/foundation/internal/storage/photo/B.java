package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f6642a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f6643b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f6644c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(F f2, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f6644c = f2;
        this.f6642a = bVar;
        this.f6643b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6642a.a(this.f6643b);
    }
}
