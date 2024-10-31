package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.internal.collaboration.h;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.facebook.places.model.PlaceFields;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public class c implements h.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.collaboration.a.b f4991a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f4992b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h hVar, com.adobe.creativesdk.foundation.internal.collaboration.a.b bVar) {
        this.f4992b = hVar;
        this.f4991a = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4991a.onError(adobeNetworkException.getStatusCode().intValue());
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(l lVar) {
        AdobeAuthIMSEnvironment adobeAuthIMSEnvironment;
        String[] split = lVar.e().get(PlaceFields.LOCATION).get(0).split("/");
        adobeAuthIMSEnvironment = h.f5000b;
        this.f4991a.a(String.format("%s/link/%s", adobeAuthIMSEnvironment.equals(AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS) ? "https://assets-stage.adobecc.com" : "https://assets.adobe.com", split[split.length - 1]));
    }
}
