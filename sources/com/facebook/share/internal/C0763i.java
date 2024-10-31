package com.facebook.share.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequestBatch;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0763i implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.d f9573a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeActionController.f f9574b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LikeActionController.l f9575c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9576d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0763i(LikeActionController likeActionController, LikeActionController.d dVar, LikeActionController.f fVar, LikeActionController.l lVar) {
        this.f9576d = likeActionController;
        this.f9573a = dVar;
        this.f9574b = fVar;
        this.f9575c = lVar;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        String str;
        String str2;
        String str3;
        FacebookRequestError a2;
        this.f9576d.verifiedObjectId = this.f9573a.f9524f;
        str = this.f9576d.verifiedObjectId;
        if (Utility.isNullOrEmpty(str)) {
            this.f9576d.verifiedObjectId = this.f9574b.f9529f;
            this.f9576d.objectIsPage = this.f9574b.f9530g;
        }
        str2 = this.f9576d.verifiedObjectId;
        if (Utility.isNullOrEmpty(str2)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str4 = LikeActionController.TAG;
            str3 = this.f9576d.objectId;
            Logger.log(loggingBehavior, str4, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", str3);
            LikeActionController likeActionController = this.f9576d;
            if (this.f9574b.a() != null) {
                a2 = this.f9574b.a();
            } else {
                a2 = this.f9573a.a();
            }
            likeActionController.logAppEventForError("get_verified_id", a2);
        }
        LikeActionController.l lVar = this.f9575c;
        if (lVar != null) {
            lVar.onComplete();
        }
    }
}
