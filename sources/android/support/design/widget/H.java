package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.F;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
public class H extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ int f421a;

    /* renamed from: b */
    final /* synthetic */ F.d f422b;

    public H(F.d dVar, int i) {
        this.f422b = dVar;
        this.f421a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        F.d dVar = this.f422b;
        dVar.f379c = this.f421a;
        dVar.f380d = 0.0f;
    }
}
