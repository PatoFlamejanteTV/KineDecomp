package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0194u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class r extends AnimatorListenerAdapter {

    /* renamed from: a */
    private boolean f488a;

    /* renamed from: b */
    final /* synthetic */ boolean f489b;

    /* renamed from: c */
    final /* synthetic */ C0194u.c f490c;

    /* renamed from: d */
    final /* synthetic */ C0194u f491d;

    public r(C0194u c0194u, boolean z, C0194u.c cVar) {
        this.f491d = c0194u;
        this.f489b = z;
        this.f490c = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f488a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C0194u c0194u = this.f491d;
        c0194u.f501f = 0;
        if (this.f488a) {
            return;
        }
        c0194u.p.a(this.f489b ? 8 : 4, this.f489b);
        C0194u.c cVar = this.f490c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f491d.p.a(0, this.f489b);
        this.f488a = false;
    }
}
