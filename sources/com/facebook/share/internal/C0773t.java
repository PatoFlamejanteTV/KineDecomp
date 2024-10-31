package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.share.internal.LikeActionController;

/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0773t implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.h f9594a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeActionController.c f9595b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0774u f9596c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0773t(C0774u c0774u, LikeActionController.h hVar, LikeActionController.c cVar) {
        this.f9596c = c0774u;
        this.f9594a = hVar;
        this.f9595b = cVar;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        String str;
        if (this.f9594a.a() == null && this.f9595b.a() == null) {
            LikeActionController likeActionController = this.f9596c.f9597a;
            boolean b2 = this.f9594a.b();
            LikeActionController.c cVar = this.f9595b;
            likeActionController.updateState(b2, cVar.f9521f, cVar.f9522g, cVar.f9523h, cVar.i, this.f9594a.c());
            return;
        }
        LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
        String str2 = LikeActionController.TAG;
        str = this.f9596c.f9597a.objectId;
        Logger.log(loggingBehavior, str2, "Unable to refresh like state for id: '%s'", str);
    }
}
