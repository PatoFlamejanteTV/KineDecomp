package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0280i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ra.b f4633a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkException f4634b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0287p f4635c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0280i(C0287p c0287p, ra.b bVar, AdobeNetworkException adobeNetworkException) {
        this.f4635c = c0287p;
        this.f4633a = bVar;
        this.f4634b = adobeNetworkException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4633a.a(this.f4634b);
    }
}
