package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class pa implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f5463a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra.b f5464b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5465c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pa(ra raVar, com.adobe.creativesdk.foundation.internal.net.j jVar, ra.b bVar) {
        this.f5465c = raVar;
        this.f5463a = jVar;
        this.f5464b = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Map map;
        map = ra.j;
        map.remove(this.f5463a);
        this.f5464b.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5464b.a(adobeNetworkException);
    }
}
