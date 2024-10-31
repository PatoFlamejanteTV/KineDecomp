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
public class j implements LikeActionController.l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f367a;
    final /* synthetic */ LikeActionController b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LikeActionController likeActionController, Bundle bundle) {
        this.b = likeActionController;
        this.f367a = bundle;
    }

    @Override // com.facebook.share.internal.LikeActionController.l
    public void a() {
        String str;
        String str2;
        LikeView.ObjectType objectType;
        str = this.b.verifiedObjectId;
        if (Utility.isNullOrEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
            LikeActionController.broadcastAction(this.b, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
            return;
        }
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        LikeActionController likeActionController = this.b;
        str2 = this.b.verifiedObjectId;
        objectType = this.b.objectType;
        LikeActionController.j jVar = new LikeActionController.j(str2, objectType);
        jVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new k(this, jVar));
        graphRequestBatch.executeAsync();
    }
}
