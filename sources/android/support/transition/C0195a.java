package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatorUtils.java */
/* renamed from: android.support.transition.a */
/* loaded from: classes.dex */
public class C0195a {

    /* renamed from: a */
    private static final InterfaceC0198d f568a;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f568a = new C0197c();
        } else {
            f568a = new C0196b();
        }
    }

    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        f568a.a(animator, animatorListenerAdapter);
    }

    public static void b(Animator animator) {
        f568a.b(animator);
    }

    public static void a(Animator animator) {
        f568a.a(animator);
    }
}
