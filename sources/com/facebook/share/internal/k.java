package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
class k implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.j f368a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, LikeActionController.j jVar2) {
        this.b = jVar;
        this.f368a = jVar2;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AppEventsLogger appEventsLogger;
        this.b.b.isPendingLikeOrUnlike = false;
        if (this.f368a.a() != null) {
            this.b.b.publishDidError(false);
            return;
        }
        this.b.b.unlikeToken = Utility.coerceValueIfNullOrEmpty(this.f368a.e, null);
        this.b.b.isObjectLikedOnServer = true;
        appEventsLogger = this.b.b.getAppEventsLogger();
        appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, this.b.f367a);
        this.b.b.publishAgainIfNeeded(this.b.f367a);
    }
}
