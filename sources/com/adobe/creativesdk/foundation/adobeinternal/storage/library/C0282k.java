package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommunitySession.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0282k implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f4640a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra.b f4641b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0287p f4642c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0282k(C0287p c0287p, com.adobe.creativesdk.foundation.internal.net.j jVar, ra.b bVar) {
        this.f4642c = c0287p;
        this.f4640a = jVar;
        this.f4641b = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Map map;
        map = C0287p.k;
        map.remove(this.f4640a);
        this.f4641b.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4641b.a(adobeNetworkException);
    }
}
