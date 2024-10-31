package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
final class p implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GraphRequest.GraphJSONObjectCallback f333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        this.f333a = graphJSONObjectCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (this.f333a != null) {
            this.f333a.onCompleted(graphResponse.getJSONObject(), graphResponse);
        }
    }
}
