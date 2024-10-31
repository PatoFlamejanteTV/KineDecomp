package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ua;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0277f implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ua f4604a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0287p f4605b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0277f(C0287p c0287p, ua uaVar) {
        this.f4605b = c0287p;
        this.f4604a = uaVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304) {
            this.f4604a.a((ua) this.f4605b.a(lVar));
        } else {
            this.f4604a.a(lVar.c());
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4604a.a((ua) ra.a(adobeNetworkException));
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f4604a.a(d2);
    }
}
