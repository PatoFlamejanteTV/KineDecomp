package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0194u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* renamed from: android.support.design.widget.s */
/* loaded from: classes.dex */
public class C0192s extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ boolean f492a;

    /* renamed from: b */
    final /* synthetic */ C0194u.c f493b;

    /* renamed from: c */
    final /* synthetic */ C0194u f494c;

    public C0192s(C0194u c0194u, boolean z, C0194u.c cVar) {
        this.f494c = c0194u;
        this.f492a = z;
        this.f493b = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f494c.f501f = 0;
        C0194u.c cVar = this.f493b;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f494c.p.a(0, this.f492a);
    }
}
