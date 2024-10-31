package com.facebook.share.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.LikeActionController;

/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class o implements GraphRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ LikeActionController.a f372a;

    public o(LikeActionController.a aVar) {
        this.f372a = aVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        this.f372a.c = graphResponse.getError();
        if (this.f372a.c != null) {
            this.f372a.a(this.f372a.c);
        } else {
            this.f372a.a(graphResponse);
        }
    }
}
