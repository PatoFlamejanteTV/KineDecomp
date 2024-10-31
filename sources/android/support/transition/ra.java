package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public class ra extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ Z f628a;

    /* renamed from: b */
    final /* synthetic */ View f629b;

    /* renamed from: c */
    final /* synthetic */ sa f630c;

    public ra(sa saVar, Z z, View view) {
        this.f630c = saVar;
        this.f628a = z;
        this.f629b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f628a.b(this.f629b);
    }
}
