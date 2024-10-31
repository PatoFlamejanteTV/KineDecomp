package com.nexstreaming.kinemaster.ui.store.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: ExpandableLayout.kt */
/* loaded from: classes2.dex */
public final class ExpandableLayout extends FrameLayout {

    /* renamed from: a */
    public static final a f23668a = new a(null);

    /* renamed from: b */
    private Integer f23669b;

    /* renamed from: c */
    private Float f23670c;

    /* renamed from: d */
    private Float f23671d;

    /* renamed from: e */
    private Integer f23672e;

    /* renamed from: f */
    private State f23673f;

    /* renamed from: g */
    private Interpolator f23674g;

    /* renamed from: h */
    private ValueAnimator f23675h;
    private c i;

    /* compiled from: ExpandableLayout.kt */
    /* loaded from: classes2.dex */
    public enum State {
        COLLAPSING,
        COLLAPSED,
        EXPANDING,
        EXPANDED
    }

    /* compiled from: ExpandableLayout.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ExpandableLayout.kt */
    /* loaded from: classes2.dex */
    public final class b implements Animator.AnimatorListener {

        /* renamed from: a */
        private boolean f23676a;

        /* renamed from: b */
        private final float f23677b;

        public b(float f2) {
            this.f23677b = f2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f23676a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f23676a) {
                return;
            }
            ExpandableLayout.this.f23673f = this.f23677b == 0.0f ? State.COLLAPSED : State.EXPANDED;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ExpandableLayout.this.f23673f = this.f23677b == 0.0f ? State.COLLAPSING : State.EXPANDING;
        }
    }

    /* compiled from: ExpandableLayout.kt */
    /* loaded from: classes2.dex */
    public interface c {
        void a(float f2, State state);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.b(context, com.umeng.analytics.pro.b.Q);
        h.b(attributeSet, "attrs");
        this.f23674g = new DecelerateInterpolator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.ExpandableLayout);
        this.f23669b = Integer.valueOf(obtainStyledAttributes.getInt(1, 500));
        this.f23670c = Float.valueOf(obtainStyledAttributes.getFloat(3, 1.0f));
        this.f23671d = Float.valueOf(obtainStyledAttributes.getBoolean(2, false) ? 1.0f : 0.0f);
        this.f23672e = Integer.valueOf(obtainStyledAttributes.getInt(0, 1));
        obtainStyledAttributes.recycle();
        this.f23673f = a() ? State.EXPANDED : State.COLLAPSED;
        Float f2 = this.f23670c;
        if (f2 != null) {
            setParallax(f2.floatValue());
        } else {
            h.a();
            throw null;
        }
    }

    public final void b(boolean z) {
        a(true, z);
    }

    public final Integer getDuration() {
        return this.f23669b;
    }

    public final Interpolator getInterpolator() {
        return this.f23674g;
    }

    public final c getListener() {
        return this.i;
    }

    public final Integer getOrientation() {
        return this.f23672e;
    }

    public final Float getParallax() {
        return this.f23670c;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        ValueAnimator valueAnimator = this.f23675h;
        if (valueAnimator != null) {
            if (valueAnimator == null) {
                h.a();
                throw null;
            }
            valueAnimator.cancel();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Integer num = this.f23672e;
        int i3 = (num != null && num.intValue() == 0) ? measuredWidth : measuredHeight;
        setVisibility((h.a(this.f23671d, 0.0f) && i3 == 0) ? 4 : 0);
        float f2 = i3;
        Float f3 = this.f23671d;
        if (f3 != null) {
            int round = i3 - Math.round(f2 * f3.floatValue());
            Float f4 = this.f23670c;
            if (f4 != null) {
                if (f4.floatValue() > 0) {
                    float f5 = round;
                    Float f6 = this.f23670c;
                    if (f6 != null) {
                        float floatValue = f5 * f6.floatValue();
                        int childCount = getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            View childAt = getChildAt(i4);
                            Integer num2 = this.f23672e;
                            if (num2 != null && num2.intValue() == 0) {
                                int i5 = -1;
                                if (Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1) {
                                    i5 = 1;
                                }
                                h.a((Object) childAt, "child");
                                childAt.setTranslationX(i5 * floatValue);
                            } else {
                                h.a((Object) childAt, "child");
                                childAt.setTranslationY(-floatValue);
                            }
                        }
                    } else {
                        h.a();
                        throw null;
                    }
                }
                Integer num3 = this.f23672e;
                if (num3 != null && num3.intValue() == 0) {
                    setMeasuredDimension(measuredWidth - round, measuredHeight);
                    return;
                } else {
                    setMeasuredDimension(measuredWidth, measuredHeight - round);
                    return;
                }
            }
            h.a();
            throw null;
        }
        h.a();
        throw null;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Parcelable parcelable2 = bundle.getParcelable("super_state");
            this.f23671d = Float.valueOf(bundle.getFloat("expansion"));
            parcelable = parcelable2;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        this.f23671d = Float.valueOf(a() ? 1.0f : 0.0f);
        Bundle bundle = new Bundle();
        bundle.putParcelable("super_state", super.onSaveInstanceState());
        Float f2 = this.f23671d;
        if (f2 != null) {
            bundle.putFloat("expansion", f2.floatValue());
            return bundle;
        }
        h.a();
        throw null;
    }

    public final void setDuration(Integer num) {
        this.f23669b = num;
    }

    public final void setExpansion(float f2) {
        if (h.a(this.f23671d, f2)) {
            return;
        }
        Float f3 = this.f23671d;
        if (f3 != null) {
            float floatValue = f2 - f3.floatValue();
            if (f2 == 0.0f) {
                this.f23673f = State.COLLAPSED;
            } else if (f2 == 1.0f) {
                this.f23673f = State.EXPANDED;
            } else {
                float f4 = 0;
                if (floatValue < f4) {
                    this.f23673f = State.COLLAPSING;
                } else if (floatValue > f4) {
                    this.f23673f = State.EXPANDING;
                }
            }
            setVisibility(this.f23673f == State.COLLAPSED ? 4 : 0);
            this.f23671d = Float.valueOf(f2);
            requestLayout();
            c cVar = this.i;
            if (cVar != null) {
                State state = this.f23673f;
                if (state != null) {
                    cVar.a(f2, state);
                    return;
                } else {
                    h.a();
                    throw null;
                }
            }
            return;
        }
        h.a();
        throw null;
    }

    public final void setInterpolator(Interpolator interpolator) {
        h.b(interpolator, "<set-?>");
        this.f23674g = interpolator;
    }

    public final void setListener(c cVar) {
        this.i = cVar;
    }

    public final void setOrientation(Integer num) {
        this.f23672e = num;
    }

    public final void setParallax(Float f2) {
        this.f23670c = f2;
    }

    public final boolean a() {
        State state = this.f23673f;
        return state == State.EXPANDING || state == State.EXPANDED;
    }

    public final void setParallax(float f2) {
        this.f23670c = Float.valueOf(Math.min(1.0f, Math.max(0.0f, f2)));
    }

    public final void a(boolean z) {
        a(false, z);
    }

    public final void a(boolean z, boolean z2) {
        if (z == a()) {
            return;
        }
        float f2 = z ? 1.0f : 0.0f;
        if (z2) {
            a(f2);
        } else {
            setExpansion(f2);
        }
    }

    private final void a(float f2) {
        ValueAnimator valueAnimator = this.f23675h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f23675h = null;
        float[] fArr = new float[2];
        Float f3 = this.f23671d;
        if (f3 == null) {
            h.a();
            throw null;
        }
        fArr[0] = f3.floatValue();
        fArr[1] = f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f23674g);
        ofFloat.setDuration(this.f23669b != null ? r1.intValue() : 500);
        ofFloat.addUpdateListener(new com.nexstreaming.kinemaster.ui.store.view.b(this, f2));
        ofFloat.addListener(new b(f2));
        ofFloat.start();
        this.f23675h = ofFloat;
    }
}
