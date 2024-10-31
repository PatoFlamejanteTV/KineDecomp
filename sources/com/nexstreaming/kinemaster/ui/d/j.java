package com.nexstreaming.kinemaster.ui.d;

import android.view.animation.Animation;
import android.widget.ListView;

/* compiled from: OptionGroupFragment.java */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ m f21554a;

    public j(m mVar) {
        this.f21554a = mVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ListView listView = this.f21554a.s;
        if (listView != null) {
            listView.requestLayout();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
