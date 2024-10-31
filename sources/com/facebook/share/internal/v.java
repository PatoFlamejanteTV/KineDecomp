package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class v implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.a f9598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LikeActionController.a aVar) {
        this.f9598a = aVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        this.f9598a.f9516d = graphResponse.getError();
        LikeActionController.a aVar = this.f9598a;
        FacebookRequestError facebookRequestError = aVar.f9516d;
        if (facebookRequestError != null) {
            aVar.a(facebookRequestError);
        } else {
            aVar.a(graphResponse);
        }
    }
}
