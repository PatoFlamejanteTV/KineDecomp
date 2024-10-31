package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.collaboration.h;
import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public class d implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f4993a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h.a f4994b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f4995c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h hVar, com.adobe.creativesdk.foundation.internal.net.j jVar, h.a aVar) {
        this.f4995c = hVar;
        this.f4993a = jVar;
        this.f4994b = aVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(l lVar) {
        Map map;
        map = h.f5003e;
        map.remove(this.f4993a);
        this.f4994b.a(lVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4994b.a(adobeNetworkException);
    }
}
