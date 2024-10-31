package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.ViewTreeObserver;
import android.widget.GridView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ba implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MediaBrowserFragment mediaBrowserFragment) {
        this.f4724a = mediaBrowserFragment;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        GridView gridView;
        GridView gridView2;
        gridView = this.f4724a.k;
        gridView.requestLayout();
        gridView2 = this.f4724a.k;
        gridView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
