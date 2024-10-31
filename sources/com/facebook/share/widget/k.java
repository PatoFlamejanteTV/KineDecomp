package com.facebook.share.widget;

import android.view.View;

/* compiled from: LikeView.java */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ LikeView f9638a;

    public k(LikeView likeView) {
        this.f9638a = likeView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9638a.toggleLike();
    }
}
