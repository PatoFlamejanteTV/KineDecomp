package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0771q implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.j f9587a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f9588b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0771q(r rVar, LikeActionController.j jVar) {
        this.f9588b = rVar;
        this.f9587a = jVar;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AppEventsLogger appEventsLogger;
        this.f9588b.f9590b.isPendingLikeOrUnlike = false;
        if (this.f9587a.a() != null) {
            this.f9588b.f9590b.publishDidError(false);
            return;
        }
        this.f9588b.f9590b.unlikeToken = Utility.coerceValueIfNullOrEmpty(this.f9587a.f9538f, null);
        this.f9588b.f9590b.isObjectLikedOnServer = true;
        appEventsLogger = this.f9588b.f9590b.getAppEventsLogger();
        appEventsLogger.logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, this.f9588b.f9589a);
        r rVar = this.f9588b;
        rVar.f9590b.publishAgainIfNeeded(rVar.f9589a);
    }
}
