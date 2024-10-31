package com.facebook.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utility.java */
/* loaded from: classes.dex */
public class D implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Utility.GraphMeRequestWithCacheCallback f9273a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9274b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public D(Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
        this.f9273a = graphMeRequestWithCacheCallback;
        this.f9274b = str;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            this.f9273a.onFailure(graphResponse.getError().getException());
        } else {
            B.a(this.f9274b, graphResponse.getJSONObject());
            this.f9273a.onSuccess(graphResponse.getJSONObject());
        }
    }
}
