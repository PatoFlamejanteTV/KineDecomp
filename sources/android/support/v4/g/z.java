package android.support.v4.g;

import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: ViewPropertyAnimatorCompatICS.java */
/* loaded from: classes.dex */
class z {
    public static void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void a(View view, float f) {
        view.animate().translationX(f);
    }

    public static void b(View view, float f) {
        view.animate().translationY(f);
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void c(View view, float f) {
        view.animate().scaleY(f);
    }

    public static void a(View view) {
        view.animate().cancel();
    }

    public static void b(View view) {
        view.animate().start();
    }

    public static void a(View view, ad adVar) {
        if (adVar != null) {
            view.animate().setListener(new aa(adVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
