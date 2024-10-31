package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class r extends sa {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f626a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f627b = false;

        a(View view) {
            this.f626a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ka.a(this.f626a, 1.0f);
            if (this.f627b) {
                this.f626a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.f626a) && this.f626a.getLayerType() == 0) {
                this.f627b = true;
                this.f626a.setLayerType(2, null);
            }
        }
    }

    public r(int i) {
        a(i);
    }

    private Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ka.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ka.f594d, f3);
        ofFloat.addListener(new a(view));
        a(new C0211q(this, view));
        return ofFloat;
    }

    @Override // android.support.transition.sa
    public Animator b(ViewGroup viewGroup, View view, V v, V v2) {
        ka.e(view);
        return a(view, a(v, 1.0f), 0.0f);
    }

    @Override // android.support.transition.sa, android.support.transition.M
    public void c(V v) {
        super.c(v);
        v.f560a.put("android:fade:transitionAlpha", Float.valueOf(ka.c(v.f561b)));
    }

    @Override // android.support.transition.sa
    public Animator a(ViewGroup viewGroup, View view, V v, V v2) {
        float a2 = a(v, 0.0f);
        return a(view, a2 != 1.0f ? a2 : 0.0f, 1.0f);
    }

    private static float a(V v, float f2) {
        Float f3;
        return (v == null || (f3 = (Float) v.f560a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }
}
