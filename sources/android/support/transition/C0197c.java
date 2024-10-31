package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: AnimatorUtilsApi19.java */
/* renamed from: android.support.transition.c */
/* loaded from: classes.dex */
class C0197c implements InterfaceC0198d {
    @Override // android.support.transition.InterfaceC0198d
    public void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    @Override // android.support.transition.InterfaceC0198d
    public void b(Animator animator) {
        animator.resume();
    }

    @Override // android.support.transition.InterfaceC0198d
    public void a(Animator animator) {
        animator.pause();
    }
}
