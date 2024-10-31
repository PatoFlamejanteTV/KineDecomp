package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0765k implements LikeActionController.CreationCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9578a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f9579b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Intent f9580c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0765k(int i, int i2, Intent intent) {
        this.f9578a = i;
        this.f9579b = i2;
        this.f9580c = intent;
    }

    @Override // com.facebook.share.internal.LikeActionController.CreationCallback
    public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
        if (facebookException == null) {
            likeActionController.onActivityResult(this.f9578a, this.f9579b, this.f9580c);
        } else {
            Utility.logd(LikeActionController.TAG, facebookException);
        }
    }
}
