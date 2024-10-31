package android.support.v4.g;

import android.view.View;

/* compiled from: ViewCompatJB.java */
/* loaded from: classes.dex */
class s {
    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int a(View view) {
        return view.getMinimumHeight();
    }

    public static void b(View view) {
        view.requestFitSystemWindows();
    }
}
