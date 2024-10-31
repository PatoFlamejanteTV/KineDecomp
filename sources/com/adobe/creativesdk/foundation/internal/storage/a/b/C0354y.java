package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0354y implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ua f5487a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra f5488b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0354y(ra raVar, ua uaVar) {
        this.f5488b = raVar;
        this.f5487a = uaVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        if (g2 != 200 && g2 != 304 && g2 != 415) {
            this.f5487a.a((ua) ra.a(lVar));
        } else {
            this.f5487a.a(lVar.c());
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5487a.a(d2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5487a.a((ua) ra.a(adobeNetworkException));
    }
}
