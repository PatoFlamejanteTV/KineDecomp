package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class CircleIndicator extends LinearLayout {

    /* renamed from: a */
    private ViewPager f28731a;

    /* renamed from: b */
    private int f28732b;

    /* renamed from: c */
    private int f28733c;

    /* renamed from: d */
    private int f28734d;

    /* renamed from: e */
    private int f28735e;

    /* renamed from: f */
    private int f28736f;

    /* renamed from: g */
    private int f28737g;

    /* renamed from: h */
    private int f28738h;
    private Animator i;
    private Animator j;
    private Animator k;
    private Animator l;
    private int m;
    private final ViewPager.OnPageChangeListener n;
    private DataSetObserver o;

    /* loaded from: classes3.dex */
    public class a implements Interpolator {
        private a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return Math.abs(1.0f - f2);
        }

        /* synthetic */ a(CircleIndicator circleIndicator, me.relex.circleindicator.a aVar) {
            this();
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        this.f28732b = -1;
        this.f28733c = -1;
        this.f28734d = -1;
        this.f28735e = c.scale_with_alpha;
        this.f28736f = 0;
        int i = d.white_radius;
        this.f28737g = i;
        this.f28738h = i;
        this.m = -1;
        this.n = new me.relex.circleindicator.a(this);
        this.o = new b(this);
        b(context, null);
    }

    public DataSetObserver getDataSetObserver() {
        return this.o;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.f28731a;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
            this.f28731a.addOnPageChangeListener(onPageChangeListener);
            return;
        }
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    public void setViewPager(ViewPager viewPager) {
        this.f28731a = viewPager;
        ViewPager viewPager2 = this.f28731a;
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            return;
        }
        this.m = -1;
        a();
        this.f28731a.removeOnPageChangeListener(this.n);
        this.f28731a.addOnPageChangeListener(this.n);
        this.n.onPageSelected(this.f28731a.getCurrentItem());
    }

    private void b(Context context, AttributeSet attributeSet) {
        a(context, attributeSet);
        a(context);
    }

    private Animator c(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f28735e);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.CircleIndicator);
        this.f28733c = obtainStyledAttributes.getDimensionPixelSize(e.CircleIndicator_ci_width, -1);
        this.f28734d = obtainStyledAttributes.getDimensionPixelSize(e.CircleIndicator_ci_height, -1);
        this.f28732b = obtainStyledAttributes.getDimensionPixelSize(e.CircleIndicator_ci_margin, -1);
        this.f28735e = obtainStyledAttributes.getResourceId(e.CircleIndicator_ci_animator, c.scale_with_alpha);
        this.f28736f = obtainStyledAttributes.getResourceId(e.CircleIndicator_ci_animator_reverse, 0);
        this.f28737g = obtainStyledAttributes.getResourceId(e.CircleIndicator_ci_drawable, d.white_radius);
        this.f28738h = obtainStyledAttributes.getResourceId(e.CircleIndicator_ci_drawable_unselected, this.f28737g);
        setOrientation(obtainStyledAttributes.getInt(e.CircleIndicator_ci_orientation, -1) == 1 ? 1 : 0);
        int i = obtainStyledAttributes.getInt(e.CircleIndicator_ci_gravity, -1);
        if (i < 0) {
            i = 17;
        }
        setGravity(i);
        obtainStyledAttributes.recycle();
    }

    private Animator b(Context context) {
        int i = this.f28736f;
        if (i == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.f28735e);
            loadAnimator.setInterpolator(new a(this, null));
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(context, i);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28732b = -1;
        this.f28733c = -1;
        this.f28734d = -1;
        this.f28735e = c.scale_with_alpha;
        this.f28736f = 0;
        int i = d.white_radius;
        this.f28737g = i;
        this.f28738h = i;
        this.m = -1;
        this.n = new me.relex.circleindicator.a(this);
        this.o = new b(this);
        b(context, attributeSet);
    }

    private void a(Context context) {
        int i = this.f28733c;
        if (i < 0) {
            i = a(5.0f);
        }
        this.f28733c = i;
        int i2 = this.f28734d;
        if (i2 < 0) {
            i2 = a(5.0f);
        }
        this.f28734d = i2;
        int i3 = this.f28732b;
        if (i3 < 0) {
            i3 = a(5.0f);
        }
        this.f28732b = i3;
        int i4 = this.f28735e;
        if (i4 == 0) {
            i4 = c.scale_with_alpha;
        }
        this.f28735e = i4;
        this.i = c(context);
        this.k = c(context);
        this.k.setDuration(0L);
        this.j = b(context);
        this.l = b(context);
        this.l.setDuration(0L);
        int i5 = this.f28737g;
        if (i5 == 0) {
            i5 = d.white_radius;
        }
        this.f28737g = i5;
        int i6 = this.f28738h;
        if (i6 == 0) {
            i6 = this.f28737g;
        }
        this.f28738h = i6;
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28732b = -1;
        this.f28733c = -1;
        this.f28734d = -1;
        this.f28735e = c.scale_with_alpha;
        this.f28736f = 0;
        int i2 = d.white_radius;
        this.f28737g = i2;
        this.f28738h = i2;
        this.m = -1;
        this.n = new me.relex.circleindicator.a(this);
        this.o = new b(this);
        b(context, attributeSet);
    }

    public void a() {
        removeAllViews();
        int count = this.f28731a.getAdapter().getCount();
        if (count <= 0) {
            return;
        }
        int currentItem = this.f28731a.getCurrentItem();
        int orientation = getOrientation();
        for (int i = 0; i < count; i++) {
            if (currentItem == i) {
                a(orientation, this.f28737g, this.k);
            } else {
                a(orientation, this.f28738h, this.l);
            }
        }
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f28732b = -1;
        this.f28733c = -1;
        this.f28734d = -1;
        this.f28735e = c.scale_with_alpha;
        this.f28736f = 0;
        int i3 = d.white_radius;
        this.f28737g = i3;
        this.f28738h = i3;
        this.m = -1;
        this.n = new me.relex.circleindicator.a(this);
        this.o = new b(this);
        b(context, attributeSet);
    }

    private void a(int i, int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.f28733c, this.f28734d);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            int i3 = this.f28732b;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        } else {
            int i4 = this.f28732b;
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    public int a(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
