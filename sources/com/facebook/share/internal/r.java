package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.widget.LikeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class r implements LikeActionController.l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9589a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LikeActionController likeActionController, Bundle bundle) {
        this.f9590b = likeActionController;
        this.f9589a = bundle;
    }

    @Override // com.facebook.share.internal.LikeActionController.l
    public void onComplete() {
        String str;
        String str2;
        LikeView.ObjectType objectType;
        str = this.f9590b.verifiedObjectId;
        if (Utility.isNullOrEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
            LikeActionController.broadcastAction(this.f9590b, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
            return;
        }
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        LikeActionController likeActionController = this.f9590b;
        str2 = likeActionController.verifiedObjectId;
        objectType = this.f9590b.objectType;
        LikeActionController.j jVar = new LikeActionController.j(str2, objectType);
        jVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new C0771q(this, jVar));
        graphRequestBatch.executeAsync();
    }
}
