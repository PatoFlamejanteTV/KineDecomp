package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.share.internal.LikeActionController;

/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
class n implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.h f371a;
    final /* synthetic */ LikeActionController.c b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LikeActionController.h hVar, LikeActionController.c cVar) {
        this.c = mVar;
        this.f371a = hVar;
        this.b = cVar;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        String str;
        if (this.f371a.a() == null && this.b.a() == null) {
            this.c.f370a.updateState(this.f371a.b(), this.b.e, this.b.f, this.b.g, this.b.h, this.f371a.c());
            return;
        }
        LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
        String str2 = LikeActionController.TAG;
        str = this.c.f370a.objectId;
        Logger.log(loggingBehavior, str2, "Unable to refresh like state for id: '%s'", str);
    }
}
