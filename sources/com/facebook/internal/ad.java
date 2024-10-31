package com.facebook.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;

/* compiled from: Utility.java */
/* loaded from: classes.dex */
public final class ad implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ Utility.GraphMeRequestWithCacheCallback f283a;
    final /* synthetic */ String b;

    public ad(Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
        this.f283a = graphMeRequestWithCacheCallback;
        this.b = str;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            this.f283a.onFailure(graphResponse.getError().getException());
        } else {
            aa.a(this.b, graphResponse.getJSONObject());
            this.f283a.onSuccess(graphResponse.getJSONObject());
        }
    }
}
