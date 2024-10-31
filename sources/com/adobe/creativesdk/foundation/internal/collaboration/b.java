package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.collaboration.h;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public class b implements h.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.collaboration.a.b f4989a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f4990b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(h hVar, com.adobe.creativesdk.foundation.internal.collaboration.a.b bVar) {
        this.f4990b = hVar;
        this.f4989a = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4989a.onError(adobeNetworkException.getStatusCode().intValue());
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.h.a
    public void a(l lVar) {
        try {
            this.f4989a.a((String) new JSONObject(lVar.d()).get("publicURL"));
        } catch (JSONException unused) {
            this.f4989a.onError(400);
        }
    }
}
