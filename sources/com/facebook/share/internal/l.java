package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class l implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.k f369a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ LikeActionController c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LikeActionController likeActionController, LikeActionController.k kVar, Bundle bundle) {
        this.c = likeActionController;
        this.f369a = kVar;
        this.b = bundle;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AppEventsLogger appEventsLogger;
        this.c.isPendingLikeOrUnlike = false;
        if (this.f369a.a() != null) {
            this.c.publishDidError(true);
            return;
        }
        this.c.unlikeToken = null;
        this.c.isObjectLikedOnServer = false;
        appEventsLogger = this.c.getAppEventsLogger();
        appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, this.b);
        this.c.publishAgainIfNeeded(this.b);
    }
}
