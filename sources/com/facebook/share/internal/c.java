package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequestBatch;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class c implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.d f362a;
    final /* synthetic */ LikeActionController.f b;
    final /* synthetic */ LikeActionController.l c;
    final /* synthetic */ LikeActionController d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LikeActionController likeActionController, LikeActionController.d dVar, LikeActionController.f fVar, LikeActionController.l lVar) {
        this.d = likeActionController;
        this.f362a = dVar;
        this.b = fVar;
        this.c = lVar;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        String str;
        String str2;
        String str3;
        FacebookRequestError a2;
        this.d.verifiedObjectId = this.f362a.e;
        str = this.d.verifiedObjectId;
        if (Utility.isNullOrEmpty(str)) {
            this.d.verifiedObjectId = this.b.e;
            this.d.objectIsPage = this.b.f;
        }
        str2 = this.d.verifiedObjectId;
        if (Utility.isNullOrEmpty(str2)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str4 = LikeActionController.TAG;
            str3 = this.d.objectId;
            Logger.log(loggingBehavior, str4, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", str3);
            LikeActionController likeActionController = this.d;
            if (this.b.a() != null) {
                a2 = this.b.a();
            } else {
                a2 = this.f362a.a();
            }
            likeActionController.logAppEventForError("get_verified_id", a2);
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
