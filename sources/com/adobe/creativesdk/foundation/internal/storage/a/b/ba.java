package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class ba implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f5380a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra.b f5381b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ra f5382c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ra raVar, com.adobe.creativesdk.foundation.internal.net.j jVar, ra.b bVar) {
        this.f5382c = raVar;
        this.f5380a = jVar;
        this.f5381b = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Map map;
        map = ra.j;
        map.remove(this.f5380a);
        this.f5381b.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5381b.a(adobeNetworkException);
    }
}
