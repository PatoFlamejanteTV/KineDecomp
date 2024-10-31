package com.facebook.share.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0766l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0766l(LikeActionController likeActionController) {
        this.f9581a = likeActionController;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9581a.refreshStatusAsync();
    }
}
