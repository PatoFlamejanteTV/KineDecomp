package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bx extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4177a;
    final /* synthetic */ int b;
    final /* synthetic */ ProjectGalleryActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(ProjectGalleryActivity projectGalleryActivity, View view, int i) {
        this.c = projectGalleryActivity;
        this.f4177a = view;
        this.b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        View view;
        view = this.c.r;
        view.setEnabled(false);
        this.c.H = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        View[] viewArr;
        View view3;
        this.f4177a.setVisibility(8);
        view = this.c.s;
        view.setVisibility(8);
        view2 = this.c.t;
        view2.setVisibility(8);
        viewArr = this.c.l;
        for (View view4 : viewArr) {
            if ("np".equals(view4.getTag()) && this.b > 0) {
                view4.setVisibility(8);
            } else {
                view4.setVisibility(4);
            }
        }
        view3 = this.c.r;
        view3.setEnabled(true);
        this.c.H = false;
    }
}
