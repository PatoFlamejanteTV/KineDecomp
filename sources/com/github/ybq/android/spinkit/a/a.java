package com.github.ybq.android.spinkit.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.github.ybq.android.spinkit.b.q;

/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public class a {
    public static void a(Animator animator) {
        if (animator == null || animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public static void b(q... qVarArr) {
        for (q qVar : qVarArr) {
            qVar.start();
        }
    }

    public static void c(q... qVarArr) {
        for (q qVar : qVarArr) {
            qVar.stop();
        }
    }

    public static boolean a(q... qVarArr) {
        for (q qVar : qVarArr) {
            if (qVar.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public static boolean a(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }
}
