package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class D implements com.adobe.creativesdk.foundation.internal.net.F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f6648a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ra.b f6649b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f6650c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(F f2, com.adobe.creativesdk.foundation.internal.net.j jVar, ra.b bVar) {
        this.f6650c = f2;
        this.f6648a = jVar;
        this.f6649b = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Map map;
        map = F.j;
        map.remove(this.f6648a);
        this.f6649b.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f6649b.a(adobeNetworkException);
    }
}
