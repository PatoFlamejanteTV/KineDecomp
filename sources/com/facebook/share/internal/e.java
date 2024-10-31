package com.facebook.share.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LikeActionController likeActionController) {
        this.f364a = likeActionController;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f364a.refreshStatusAsync();
    }
}
