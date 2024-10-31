package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* compiled from: AnimatorUtilsApi14.java */
/* renamed from: android.support.transition.b */
/* loaded from: classes.dex */
class C0196b implements InterfaceC0198d {

    /* compiled from: AnimatorUtilsApi14.java */
    /* renamed from: android.support.transition.b$a */
    /* loaded from: classes.dex */
    interface a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    @Override // android.support.transition.InterfaceC0198d
    public void a(Animator animator) {
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    @Override // android.support.transition.InterfaceC0198d
    public void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    @Override // android.support.transition.InterfaceC0198d
    public void b(Animator animator) {
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
