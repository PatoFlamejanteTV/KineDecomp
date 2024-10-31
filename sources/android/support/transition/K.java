package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public class K extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ArrayMap f534a;

    /* renamed from: b */
    final /* synthetic */ M f535b;

    public K(M m, ArrayMap arrayMap) {
        this.f535b = m;
        this.f534a = arrayMap;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ArrayList arrayList;
        this.f534a.remove(animator);
        arrayList = this.f535b.A;
        arrayList.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ArrayList arrayList;
        arrayList = this.f535b.A;
        arrayList.add(animator);
    }
}
