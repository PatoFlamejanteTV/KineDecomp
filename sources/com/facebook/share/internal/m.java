package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.widget.LikeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class m implements LikeActionController.l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LikeActionController likeActionController) {
        this.f370a = likeActionController;
    }

    @Override // com.facebook.share.internal.LikeActionController.l
    public void a() {
        LikeView.ObjectType objectType;
        LikeActionController.h gVar;
        String str;
        String str2;
        LikeView.ObjectType objectType2;
        String str3;
        LikeView.ObjectType objectType3;
        int[] iArr = d.f363a;
        objectType = this.f370a.objectType;
        switch (iArr[objectType.ordinal()]) {
            case 1:
                LikeActionController likeActionController = this.f370a;
                str = this.f370a.verifiedObjectId;
                gVar = new LikeActionController.g(str);
                break;
            default:
                LikeActionController likeActionController2 = this.f370a;
                str3 = this.f370a.verifiedObjectId;
                objectType3 = this.f370a.objectType;
                gVar = new LikeActionController.e(str3, objectType3);
                break;
        }
        LikeActionController likeActionController3 = this.f370a;
        str2 = this.f370a.verifiedObjectId;
        objectType2 = this.f370a.objectType;
        LikeActionController.c cVar = new LikeActionController.c(str2, objectType2);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        gVar.a(graphRequestBatch);
        cVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new n(this, gVar, cVar));
        graphRequestBatch.executeAsync();
    }
}
