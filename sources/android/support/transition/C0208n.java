package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0208n extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    private boolean f598a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f599b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Rect f600c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f601d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f602e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f603f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f604g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ C0210p f605h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0208n(C0210p c0210p, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.f605h = c0210p;
        this.f599b = view;
        this.f600c = rect;
        this.f601d = i;
        this.f602e = i2;
        this.f603f = i3;
        this.f604g = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f598a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f598a) {
            return;
        }
        ViewCompat.setClipBounds(this.f599b, this.f600c);
        ka.a(this.f599b, this.f601d, this.f602e, this.f603f, this.f604g);
    }
}
