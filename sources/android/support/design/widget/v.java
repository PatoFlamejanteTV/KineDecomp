package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonLollipop.java */
/* loaded from: classes.dex */
class v extends C0194u {
    private InsetDrawable t;

    public v(U u, z zVar) {
        super(u, zVar);
    }

    @Override // android.support.design.widget.C0194u
    public void a(int i) {
        Drawable drawable = this.k;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    @Override // android.support.design.widget.C0194u
    public void a(int[] iArr) {
    }

    @Override // android.support.design.widget.C0194u
    public float b() {
        return this.p.getElevation();
    }

    @Override // android.support.design.widget.C0194u
    public void e() {
    }

    @Override // android.support.design.widget.C0194u
    public void g() {
        k();
    }

    @Override // android.support.design.widget.C0194u
    boolean j() {
        return false;
    }

    @Override // android.support.design.widget.C0194u
    void b(Rect rect) {
        if (this.q.a()) {
            this.t = new InsetDrawable(this.k, rect.left, rect.top, rect.right, rect.bottom);
            this.q.setBackgroundDrawable(this.t);
        } else {
            this.q.setBackgroundDrawable(this.k);
        }
    }

    @Override // android.support.design.widget.C0194u
    void a(float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.p.isEnabled()) {
                this.p.setElevation(f2);
                if (!this.p.isFocused() && !this.p.isPressed()) {
                    this.p.setTranslationZ(0.0f);
                } else {
                    this.p.setTranslationZ(f3);
                }
            } else {
                this.p.setElevation(0.0f);
                this.p.setTranslationZ(0.0f);
            }
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.p, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.p, (Property<U, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
            animatorSet.setInterpolator(C0194u.f496a);
            stateListAnimator.addState(C0194u.f497b, animatorSet);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(ObjectAnimator.ofFloat(this.p, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.p, (Property<U, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
            animatorSet2.setInterpolator(C0194u.f496a);
            stateListAnimator.addState(C0194u.f498c, animatorSet2);
            AnimatorSet animatorSet3 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.p, "elevation", f2).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                U u = this.p;
                arrayList.add(ObjectAnimator.ofFloat(u, (Property<U, Float>) View.TRANSLATION_Z, u.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.p, (Property<U, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet3.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet3.setInterpolator(C0194u.f496a);
            stateListAnimator.addState(C0194u.f499d, animatorSet3);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.play(ObjectAnimator.ofFloat(this.p, "elevation", 0.0f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.p, (Property<U, Float>) View.TRANSLATION_Z, 0.0f).setDuration(0L));
            animatorSet4.setInterpolator(C0194u.f496a);
            stateListAnimator.addState(C0194u.f500e, animatorSet4);
            this.p.setStateListAnimator(stateListAnimator);
        }
        if (this.q.a()) {
            k();
        }
    }

    @Override // android.support.design.widget.C0194u
    void a(Rect rect) {
        if (this.q.a()) {
            float b2 = this.q.b();
            float b3 = b() + this.o;
            int ceil = (int) Math.ceil(y.a(b3, b2, false));
            int ceil2 = (int) Math.ceil(y.b(b3, b2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
