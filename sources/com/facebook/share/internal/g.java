package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.CreationCallback f365a;
    final /* synthetic */ LikeActionController b;
    final /* synthetic */ FacebookException c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LikeActionController.CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        this.f365a = creationCallback;
        this.b = likeActionController;
        this.c = facebookException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f365a.onComplete(this.b, this.c);
    }
}
