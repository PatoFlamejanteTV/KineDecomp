package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0772s implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.k f9591a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f9592b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9593c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0772s(LikeActionController likeActionController, LikeActionController.k kVar, Bundle bundle) {
        this.f9593c = likeActionController;
        this.f9591a = kVar;
        this.f9592b = bundle;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AppEventsLogger appEventsLogger;
        this.f9593c.isPendingLikeOrUnlike = false;
        if (this.f9591a.a() != null) {
            this.f9593c.publishDidError(true);
            return;
        }
        this.f9593c.unlikeToken = null;
        this.f9593c.isObjectLikedOnServer = false;
        appEventsLogger = this.f9593c.getAppEventsLogger();
        appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, this.f9592b);
        this.f9593c.publishAgainIfNeeded(this.f9592b);
    }
}
