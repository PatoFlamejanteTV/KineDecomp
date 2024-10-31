package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
class q implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.GraphJSONObjectCallback f9466a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        this.f9466a = graphJSONObjectCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback = this.f9466a;
        if (graphJSONObjectCallback != null) {
            graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
        }
    }
}
