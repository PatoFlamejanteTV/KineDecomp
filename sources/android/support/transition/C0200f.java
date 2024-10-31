package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0200f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f578a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f579b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f580c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f581d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0210p f582e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0200f(C0210p c0210p, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
        this.f582e = c0210p;
        this.f578a = viewGroup;
        this.f579b = bitmapDrawable;
        this.f580c = view;
        this.f581d = f2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ka.b(this.f578a).b(this.f579b);
        ka.a(this.f580c, this.f581d);
    }
}
