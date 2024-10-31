package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.view.animation.Animation;
import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
public class d implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f21376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(i iVar) {
        this.f21376a = iVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ListView listView;
        ListView listView2;
        listView = this.f21376a.s;
        if (listView != null) {
            listView2 = this.f21376a.s;
            listView2.requestLayout();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
