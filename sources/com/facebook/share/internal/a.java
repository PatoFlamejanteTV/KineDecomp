package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public final class a implements LikeActionController.CreationCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f356a;
    final /* synthetic */ int b;
    final /* synthetic */ Intent c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, int i2, Intent intent) {
        this.f356a = i;
        this.b = i2;
        this.c = intent;
    }

    @Override // com.facebook.share.internal.LikeActionController.CreationCallback
    public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
        if (facebookException == null) {
            likeActionController.onActivityResult(this.f356a, this.b, this.c);
        } else {
            Utility.logd(LikeActionController.TAG, facebookException);
        }
    }
}
