package android.support.design.widget;

import android.animation.ValueAnimator;
import android.support.design.widget.F;

/* compiled from: TabLayout.java */
/* loaded from: classes.dex */
class G implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f416a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f417b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f418c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f419d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ F.d f420e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(F.d dVar, int i, int i2, int i3, int i4) {
        this.f420e = dVar;
        this.f416a = i;
        this.f417b = i2;
        this.f418c = i3;
        this.f419d = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.f420e.b(C0175a.a(this.f416a, this.f417b, animatedFraction), C0175a.a(this.f418c, this.f419d, animatedFraction));
    }
}
