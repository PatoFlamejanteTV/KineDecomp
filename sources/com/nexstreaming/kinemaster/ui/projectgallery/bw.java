package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bw extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(ProjectGalleryActivity projectGalleryActivity) {
        this.f4176a = projectGalleryActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4176a.H = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4176a.H = false;
    }
}
