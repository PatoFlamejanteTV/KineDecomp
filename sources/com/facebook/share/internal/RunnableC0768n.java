package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.share.internal.LikeActionController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0768n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController.CreationCallback f9582a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9583b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ FacebookException f9584c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0768n(LikeActionController.CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        this.f9582a = creationCallback;
        this.f9583b = likeActionController;
        this.f9584c = facebookException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9582a.onComplete(this.f9583b, this.f9584c);
    }
}
