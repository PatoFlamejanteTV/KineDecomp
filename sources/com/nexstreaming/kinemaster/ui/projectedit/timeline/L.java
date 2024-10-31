package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.J;

/* compiled from: TimelineItemTrimDecoration.java */
/* loaded from: classes2.dex */
public class L extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ J.b f22598a;

    public L(J.b bVar) {
        this.f22598a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super/*android.widget.PopupWindow*/.dismiss();
        this.f22598a.f22594b = false;
        this.f22598a.f22593a = false;
    }
}
