package com.facebook.share.internal;

import com.facebook.GraphRequestBatch;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.widget.LikeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0774u implements LikeActionController.l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0774u(LikeActionController likeActionController) {
        this.f9597a = likeActionController;
    }

    @Override // com.facebook.share.internal.LikeActionController.l
    public void onComplete() {
        LikeView.ObjectType objectType;
        LikeActionController.h gVar;
        String str;
        String str2;
        LikeView.ObjectType objectType2;
        String str3;
        LikeView.ObjectType objectType3;
        int[] iArr = C0764j.f9577a;
        objectType = this.f9597a.objectType;
        if (iArr[objectType.ordinal()] != 1) {
            LikeActionController likeActionController = this.f9597a;
            str3 = likeActionController.verifiedObjectId;
            objectType3 = this.f9597a.objectType;
            gVar = new LikeActionController.e(str3, objectType3);
        } else {
            LikeActionController likeActionController2 = this.f9597a;
            str = likeActionController2.verifiedObjectId;
            gVar = new LikeActionController.g(str);
        }
        LikeActionController likeActionController3 = this.f9597a;
        str2 = likeActionController3.verifiedObjectId;
        objectType2 = this.f9597a.objectType;
        LikeActionController.c cVar = new LikeActionController.c(str2, objectType2);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        gVar.a(graphRequestBatch);
        cVar.a(graphRequestBatch);
        graphRequestBatch.addCallback(new C0773t(this, gVar, cVar));
        graphRequestBatch.executeAsync();
    }
}
