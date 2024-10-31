package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.collaboration.h;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public class g implements h.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.collaboration.a.c f4997a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f4998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, com.adobe.creativesdk.foundation.internal.collaboration.a.c cVar) {
        this.f4998b = hVar;
        this.f4997a = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(AdobeNetworkException adobeNetworkException) {
        l a2;
        AdobeCollaborationException adobeCollaborationException;
        a2 = this.f4998b.a(adobeNetworkException);
        if (a2 != null) {
            adobeCollaborationException = this.f4998b.a(a2);
        } else {
            adobeCollaborationException = new AdobeCollaborationException(AdobeCollaborationErrorCode.ADOBE_COLLABORATION_ERROR_UNEXPECTED_RESPONSE, adobeNetworkException.getData(), null);
        }
        this.f4997a.a(adobeCollaborationException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(l lVar) {
        AdobeCollaborationException a2;
        int g2 = lVar.g();
        if (g2 >= 200 && g2 <= 299) {
            this.f4997a.onComplete();
            return;
        }
        com.adobe.creativesdk.foundation.internal.collaboration.a.c cVar = this.f4997a;
        a2 = this.f4998b.a(lVar);
        cVar.a(a2);
    }
}
