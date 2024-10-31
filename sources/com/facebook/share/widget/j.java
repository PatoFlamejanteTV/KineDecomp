package com.facebook.share.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeView.java */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeView f405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LikeView likeView) {
        this.f405a = likeView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f405a.toggleLike();
    }
}
