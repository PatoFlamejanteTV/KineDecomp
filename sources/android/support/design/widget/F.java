package android.support.design.widget;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.util.Pools;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TabLayout.java */
@ViewPager.DecorView
/* loaded from: classes.dex */
public class F extends HorizontalScrollView {

    /* renamed from: a */
    private static final Pools.Pool<e> f366a = new Pools.SynchronizedPool(16);
    private DataSetObserver A;
    private f B;
    private a C;
    private boolean D;
    private final Pools.Pool<g> E;

    /* renamed from: b */
    private final ArrayList<e> f367b;

    /* renamed from: c */
    private e f368c;

    /* renamed from: d */
    private final d f369d;

    /* renamed from: e */
    int f370e;

    /* renamed from: f */
    int f371f;

    /* renamed from: g */
    int f372g;

    /* renamed from: h */
    int f373h;
    int i;
    ColorStateList j;
    float k;
    float l;
    final int m;
    int n;
    private final int o;
    private final int p;
    private final int q;
    private int r;
    int s;
    int t;
    private b u;
    private final ArrayList<b> v;
    private b w;
    private ValueAnimator x;
    ViewPager y;
    private PagerAdapter z;

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public class a implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private boolean f374a;

        a() {
        }

        void a(boolean z) {
            this.f374a = z;
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            F f2 = F.this;
            if (f2.y == viewPager) {
                f2.a(pagerAdapter2, this.f374a);
            }
        }
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);

        void b(e eVar);

        void c(e eVar);
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            F.this.b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            F.this.b();
        }
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a */
        private Object f385a;

        /* renamed from: b */
        private Drawable f386b;

        /* renamed from: c */
        private CharSequence f387c;

        /* renamed from: d */
        private CharSequence f388d;

        /* renamed from: e */
        private int f389e = -1;

        /* renamed from: f */
        private View f390f;

        /* renamed from: g */
        F f391g;

        /* renamed from: h */
        g f392h;

        e() {
        }

        public e a(View view) {
            this.f390f = view;
            i();
            return this;
        }

        public View b() {
            return this.f390f;
        }

        public Drawable c() {
            return this.f386b;
        }

        public int d() {
            return this.f389e;
        }

        public CharSequence e() {
            return this.f387c;
        }

        public boolean f() {
            F f2 = this.f391g;
            if (f2 != null) {
                return f2.getSelectedTabPosition() == this.f389e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void g() {
            this.f391g = null;
            this.f392h = null;
            this.f385a = null;
            this.f386b = null;
            this.f387c = null;
            this.f388d = null;
            this.f389e = -1;
            this.f390f = null;
        }

        public void h() {
            F f2 = this.f391g;
            if (f2 != null) {
                f2.b(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void i() {
            g gVar = this.f392h;
            if (gVar != null) {
                gVar.b();
            }
        }

        void b(int i) {
            this.f389e = i;
        }

        public e a(int i) {
            a(LayoutInflater.from(this.f392h.getContext()).inflate(i, (ViewGroup) this.f392h, false));
            return this;
        }

        public e b(CharSequence charSequence) {
            this.f387c = charSequence;
            i();
            return this;
        }

        public e a(Drawable drawable) {
            this.f386b = drawable;
            i();
            return this;
        }

        public e a(CharSequence charSequence) {
            this.f388d = charSequence;
            i();
            return this;
        }

        public CharSequence a() {
            return this.f388d;
        }
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public static class f implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private final WeakReference<F> f393a;

        /* renamed from: b */
        private int f394b;

        /* renamed from: c */
        private int f395c;

        public f(F f2) {
            this.f393a = new WeakReference<>(f2);
        }

        void a() {
            this.f395c = 0;
            this.f394b = 0;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f394b = this.f395c;
            this.f395c = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            F f3 = this.f393a.get();
            if (f3 != null) {
                f3.a(i, f2, this.f395c != 2 || this.f394b == 1, (this.f395c == 2 && this.f394b == 0) ? false : true);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            F f2 = this.f393a.get();
            if (f2 == null || f2.getSelectedTabPosition() == i || i >= f2.getTabCount()) {
                return;
            }
            int i2 = this.f395c;
            f2.b(f2.b(i), i2 == 0 || (i2 == 2 && this.f394b == 0));
        }
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public static class h implements b {

        /* renamed from: a */
        private final ViewPager f404a;

        public h(ViewPager viewPager) {
            this.f404a = viewPager;
        }

        @Override // android.support.design.widget.F.b
        public void a(e eVar) {
        }

        @Override // android.support.design.widget.F.b
        public void b(e eVar) {
        }

        @Override // android.support.design.widget.F.b
        public void c(e eVar) {
            this.f404a.setCurrentItem(eVar.d());
        }
    }

    public F(Context context) {
        this(context, null);
    }

    private g d(e eVar) {
        Pools.Pool<g> pool = this.E;
        g acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new g(getContext());
        }
        acquire.a(eVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        return acquire;
    }

    private LinearLayout.LayoutParams e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void f() {
        if (this.x == null) {
            this.x = new ValueAnimator();
            this.x.setInterpolator(C0175a.f463b);
            this.x.setDuration(300L);
            this.x.addUpdateListener(new E(this));
        }
    }

    private void g() {
        int size = this.f367b.size();
        for (int i = 0; i < size; i++) {
            this.f367b.get(i).i();
        }
    }

    private int getDefaultHeight() {
        int size = this.f367b.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                e eVar = this.f367b.get(i);
                if (eVar != null && eVar.c() != null && !TextUtils.isEmpty(eVar.e())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f369d.b();
    }

    private int getTabMinWidth() {
        int i = this.o;
        if (i != -1) {
            return i;
        }
        if (this.t == 0) {
            return this.q;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f369d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f369d.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f369d.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    public void a(int i, float f2, boolean z) {
        a(i, f2, z, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public void b(b bVar) {
        this.v.remove(bVar);
    }

    public void c() {
        for (int childCount = this.f369d.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<e> it = this.f367b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            next.g();
            f366a.release(next);
        }
        this.f368c = null;
    }

    public int getSelectedTabPosition() {
        e eVar = this.f368c;
        if (eVar != null) {
            return eVar.d();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f367b.size();
    }

    public int getTabGravity() {
        return this.s;
    }

    int getTabMaxWidth() {
        return this.n;
    }

    public int getTabMode() {
        return this.t;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.y == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.D) {
            setupWithViewPager(null);
            this.D = false;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int a2 = a(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(a2, View.MeasureSpec.getSize(i2)), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i3 = this.p;
            if (i3 <= 0) {
                i3 = size - a(56);
            }
            this.n = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            boolean z = false;
            View childAt = getChildAt(0);
            int i4 = this.t;
            if (i4 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i4 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z = true;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.u;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.u = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.x.addListener(animatorListener);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f369d.a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f369d.b(i);
    }

    public void setTabGravity(int i) {
        if (this.s != i) {
            this.s = i;
            d();
        }
    }

    public void setTabMode(int i) {
        if (i != this.t) {
            this.t = i;
            d();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            g();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        a(pagerAdapter, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public F(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    void a(int i, float f2, boolean z, boolean z2) {
        int round = Math.round(i + f2);
        if (round < 0 || round >= this.f369d.getChildCount()) {
            return;
        }
        if (z2) {
            this.f369d.a(i, f2);
        }
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.x.cancel();
        }
        scrollTo(a(i, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        a(view);
    }

    public e b(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.f367b.get(i);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: a */
        private int f377a;

        /* renamed from: b */
        private final Paint f378b;

        /* renamed from: c */
        int f379c;

        /* renamed from: d */
        float f380d;

        /* renamed from: e */
        private int f381e;

        /* renamed from: f */
        private int f382f;

        /* renamed from: g */
        private int f383g;

        /* renamed from: h */
        private ValueAnimator f384h;

        d(Context context) {
            super(context);
            this.f379c = -1;
            this.f381e = -1;
            this.f382f = -1;
            this.f383g = -1;
            setWillNotDraw(false);
            this.f378b = new Paint();
        }

        private void c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f379c);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.f380d > 0.0f && this.f379c < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f379c + 1);
                    float left = this.f380d * childAt2.getLeft();
                    float f2 = this.f380d;
                    i = (int) (left + ((1.0f - f2) * i));
                    i2 = (int) ((f2 * childAt2.getRight()) + ((1.0f - this.f380d) * i2));
                }
            }
            b(i, i2);
        }

        void a(int i) {
            if (this.f378b.getColor() != i) {
                this.f378b.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void b(int i) {
            if (this.f377a != i) {
                this.f377a = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i = this.f382f;
            if (i < 0 || this.f383g <= i) {
                return;
            }
            canvas.drawRect(i, getHeight() - this.f377a, this.f383g, getHeight(), this.f378b);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.f384h;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f384h.cancel();
                a(this.f379c, Math.round((1.0f - this.f384h.getAnimatedFraction()) * ((float) this.f384h.getDuration())));
                return;
            }
            c();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            F f2 = F.this;
            boolean z = true;
            if (f2.t == 1 && f2.s == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (F.this.a(16) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    F f3 = F.this;
                    f3.s = 0;
                    f3.a(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.f381e == i) {
                return;
            }
            requestLayout();
            this.f381e = i;
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float b() {
            return this.f379c + this.f380d;
        }

        public void b(int i, int i2) {
            if (i == this.f382f && i2 == this.f383g) {
                return;
            }
            this.f382f = i;
            this.f383g = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void a(int i, float f2) {
            ValueAnimator valueAnimator = this.f384h;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f384h.cancel();
            }
            this.f379c = i;
            this.f380d = f2;
            c();
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            ValueAnimator valueAnimator = this.f384h;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f384h.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                c();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.f379c) <= 1) {
                i3 = this.f382f;
                i4 = this.f383g;
            } else {
                int a2 = F.this.a(24);
                i3 = (i >= this.f379c ? !z : z) ? left - a2 : a2 + right;
                i4 = i3;
            }
            if (i3 == left && i4 == right) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f384h = valueAnimator2;
            valueAnimator2.setInterpolator(C0175a.f463b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new G(this, i3, left, i4, right));
            valueAnimator2.addListener(new H(this, i));
            valueAnimator2.start();
        }
    }

    /* compiled from: TabLayout.java */
    /* loaded from: classes.dex */
    public class g extends LinearLayout {

        /* renamed from: a */
        private e f396a;

        /* renamed from: b */
        private TextView f397b;

        /* renamed from: c */
        private ImageView f398c;

        /* renamed from: d */
        private View f399d;

        /* renamed from: e */
        private TextView f400e;

        /* renamed from: f */
        private ImageView f401f;

        /* renamed from: g */
        private int f402g;

        public g(Context context) {
            super(context);
            this.f402g = 2;
            int i = F.this.m;
            if (i != 0) {
                ViewCompat.setBackground(this, AppCompatResources.getDrawable(context, i));
            }
            ViewCompat.setPaddingRelative(this, F.this.f370e, F.this.f371f, F.this.f372g, F.this.f373h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        void a(e eVar) {
            if (eVar != this.f396a) {
                this.f396a = eVar;
                b();
            }
        }

        final void b() {
            e eVar = this.f396a;
            View b2 = eVar != null ? eVar.b() : null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f399d = b2;
                TextView textView = this.f397b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f398c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f398c.setImageDrawable(null);
                }
                this.f400e = (TextView) b2.findViewById(R.id.text1);
                TextView textView2 = this.f400e;
                if (textView2 != null) {
                    this.f402g = TextViewCompat.getMaxLines(textView2);
                }
                this.f401f = (ImageView) b2.findViewById(R.id.icon);
            } else {
                View view = this.f399d;
                if (view != null) {
                    removeView(view);
                    this.f399d = null;
                }
                this.f400e = null;
                this.f401f = null;
            }
            boolean z = false;
            if (this.f399d == null) {
                if (this.f398c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(b.b.d.f.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.f398c = imageView2;
                }
                if (this.f397b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(b.b.d.f.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.f397b = textView3;
                    this.f402g = TextViewCompat.getMaxLines(this.f397b);
                }
                TextViewCompat.setTextAppearance(this.f397b, F.this.i);
                ColorStateList colorStateList = F.this.j;
                if (colorStateList != null) {
                    this.f397b.setTextColor(colorStateList);
                }
                a(this.f397b, this.f398c);
            } else if (this.f400e != null || this.f401f != null) {
                a(this.f400e, this.f401f);
            }
            if (eVar != null && eVar.f()) {
                z = true;
            }
            setSelected(z);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = F.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(F.this.n, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f397b != null) {
                getResources();
                float f2 = F.this.k;
                int i3 = this.f402g;
                ImageView imageView = this.f398c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f397b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = F.this.l;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.f397b.getTextSize();
                int lineCount = this.f397b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f397b);
                if (f2 != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (F.this.t == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f397b.getLayout()) == null || a(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f397b.setTextSize(0, f2);
                        this.f397b.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f396a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f396a.h();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f397b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f398c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f399d;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void a() {
            a(null);
            setSelected(false);
        }

        private void a(TextView textView, ImageView imageView) {
            e eVar = this.f396a;
            Drawable c2 = eVar != null ? eVar.c() : null;
            e eVar2 = this.f396a;
            CharSequence e2 = eVar2 != null ? eVar2.e() : null;
            e eVar3 = this.f396a;
            CharSequence a2 = eVar3 != null ? eVar3.a() : null;
            int i = 0;
            if (imageView != null) {
                if (c2 != null) {
                    imageView.setImageDrawable(c2);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(a2);
            }
            boolean z = !TextUtils.isEmpty(e2);
            if (textView != null) {
                if (z) {
                    textView.setText(e2);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(a2);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i = F.this.a(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            TooltipCompat.setTooltipText(this, z ? null : a2);
        }

        private float a(Layout layout, int i, float f2) {
            return layout.getLineWidth(i) * (f2 / layout.getPaint().getTextSize());
        }
    }

    public F(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f367b = new ArrayList<>();
        this.n = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.v = new ArrayList<>();
        this.E = new Pools.SimplePool(12);
        O.a(context);
        setHorizontalScrollBarEnabled(false);
        this.f369d = new d(context);
        super.addView(this.f369d, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.TabLayout, i, b.b.d.h.Widget_Design_TabLayout);
        this.f369d.b(obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabIndicatorHeight, 0));
        this.f369d.a(obtainStyledAttributes.getColor(b.b.d.i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabPadding, 0);
        this.f373h = dimensionPixelSize;
        this.f372g = dimensionPixelSize;
        this.f371f = dimensionPixelSize;
        this.f370e = dimensionPixelSize;
        this.f370e = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabPaddingStart, this.f370e);
        this.f371f = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabPaddingTop, this.f371f);
        this.f372g = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabPaddingEnd, this.f372g);
        this.f373h = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabPaddingBottom, this.f373h);
        this.i = obtainStyledAttributes.getResourceId(b.b.d.i.TabLayout_tabTextAppearance, b.b.d.h.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.i, android.support.v7.appcompat.R.styleable.TextAppearance);
        try {
            this.k = obtainStyledAttributes2.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.j = obtainStyledAttributes2.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(b.b.d.i.TabLayout_tabTextColor)) {
                this.j = obtainStyledAttributes.getColorStateList(b.b.d.i.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(b.b.d.i.TabLayout_tabSelectedTextColor)) {
                this.j = a(this.j.getDefaultColor(), obtainStyledAttributes.getColor(b.b.d.i.TabLayout_tabSelectedTextColor, 0));
            }
            this.o = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabMinWidth, -1);
            this.p = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabMaxWidth, -1);
            this.m = obtainStyledAttributes.getResourceId(b.b.d.i.TabLayout_tabBackground, 0);
            this.r = obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.TabLayout_tabContentStart, 0);
            this.t = obtainStyledAttributes.getInt(b.b.d.i.TabLayout_tabMode, 1);
            this.s = obtainStyledAttributes.getInt(b.b.d.i.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.l = resources.getDimensionPixelSize(b.b.d.b.design_tab_text_size_2line);
            this.q = resources.getDimensionPixelSize(b.b.d.b.design_tab_scrollable_min_width);
            d();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void e(e eVar) {
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.v.get(size).a(eVar);
        }
    }

    private void g(e eVar) {
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.v.get(size).b(eVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    void b() {
        int currentItem;
        c();
        PagerAdapter pagerAdapter = this.z;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                e a2 = a();
                a2.b(this.z.getPageTitle(i));
                a(a2, false);
            }
            ViewPager viewPager = this.y;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            b(b(currentItem));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    private void d(int i) {
        g gVar = (g) this.f369d.getChildAt(i);
        this.f369d.removeViewAt(i);
        if (gVar != null) {
            gVar.a();
            this.E.release(gVar);
        }
        requestLayout();
    }

    private void f(e eVar) {
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.v.get(size).c(eVar);
        }
    }

    private void c(e eVar) {
        this.f369d.addView(eVar.f392h, eVar.d(), e());
    }

    public void a(e eVar) {
        a(eVar, this.f367b.isEmpty());
    }

    public void a(e eVar, boolean z) {
        a(eVar, this.f367b.size(), z);
    }

    private void c(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f369d.a()) {
            int scrollX = getScrollX();
            int a2 = a(i, 0.0f);
            if (scrollX != a2) {
                f();
                this.x.setIntValues(scrollX, a2);
                this.x.start();
            }
            this.f369d.a(i, 300);
            return;
        }
        a(i, 0.0f, true);
    }

    private void d() {
        ViewCompat.setPaddingRelative(this.f369d, this.t == 0 ? Math.max(0, this.r - this.f370e) : 0, 0, 0, 0);
        int i = this.t;
        if (i == 0) {
            this.f369d.setGravity(GravityCompat.START);
        } else if (i == 1) {
            this.f369d.setGravity(1);
        }
        a(true);
    }

    public void a(e eVar, int i, boolean z) {
        if (eVar.f391g == this) {
            a(eVar, i);
            c(eVar);
            if (z) {
                eVar.h();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    void b(e eVar) {
        b(eVar, true);
    }

    void b(e eVar, boolean z) {
        e eVar2 = this.f368c;
        if (eVar2 == eVar) {
            if (eVar2 != null) {
                e(eVar);
                c(eVar.d());
                return;
            }
            return;
        }
        int d2 = eVar != null ? eVar.d() : -1;
        if (z) {
            if ((eVar2 == null || eVar2.d() == -1) && d2 != -1) {
                a(d2, 0.0f, true);
            } else {
                c(d2);
            }
            if (d2 != -1) {
                setSelectedTabView(d2);
            }
        }
        if (eVar2 != null) {
            g(eVar2);
        }
        this.f368c = eVar;
        if (eVar != null) {
            f(eVar);
        }
    }

    private void a(D d2) {
        e a2 = a();
        CharSequence charSequence = d2.f362a;
        if (charSequence != null) {
            a2.b(charSequence);
        }
        Drawable drawable = d2.f363b;
        if (drawable != null) {
            a2.a(drawable);
        }
        int i = d2.f364c;
        if (i != 0) {
            a2.a(i);
        }
        if (!TextUtils.isEmpty(d2.getContentDescription())) {
            a2.a(d2.getContentDescription());
        }
        a(a2);
    }

    public void a(b bVar) {
        if (this.v.contains(bVar)) {
            return;
        }
        this.v.add(bVar);
    }

    public e a() {
        e acquire = f366a.acquire();
        if (acquire == null) {
            acquire = new e();
        }
        acquire.f391g = this;
        acquire.f392h = d(acquire);
        return acquire;
    }

    public void a(ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    private void a(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.y;
        if (viewPager2 != null) {
            f fVar = this.B;
            if (fVar != null) {
                viewPager2.removeOnPageChangeListener(fVar);
            }
            a aVar = this.C;
            if (aVar != null) {
                this.y.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.w;
        if (bVar != null) {
            b(bVar);
            this.w = null;
        }
        if (viewPager != null) {
            this.y = viewPager;
            if (this.B == null) {
                this.B = new f(this);
            }
            this.B.a();
            viewPager.addOnPageChangeListener(this.B);
            this.w = new h(viewPager);
            a(this.w);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.C == null) {
                this.C = new a();
            }
            this.C.a(z);
            viewPager.addOnAdapterChangeListener(this.C);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.y = null;
            a((PagerAdapter) null, false);
        }
        this.D = z2;
    }

    void a(PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.z;
        if (pagerAdapter2 != null && (dataSetObserver = this.A) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.z = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.A == null) {
                this.A = new c();
            }
            pagerAdapter.registerDataSetObserver(this.A);
        }
        b();
    }

    private void a(e eVar, int i) {
        eVar.b(i);
        this.f367b.add(i, eVar);
        int size = this.f367b.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.f367b.get(i).b(i);
            }
        }
    }

    private void a(View view) {
        if (view instanceof D) {
            a((D) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.t == 1 && this.s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    int a(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    private int a(int i, float f2) {
        if (this.t != 0) {
            return 0;
        }
        View childAt = this.f369d.getChildAt(i);
        int i2 = i + 1;
        View childAt2 = i2 < this.f369d.getChildCount() ? this.f369d.getChildAt(i2) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i3 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i3 : left - i3;
    }

    void a(boolean z) {
        for (int i = 0; i < this.f369d.getChildCount(); i++) {
            View childAt = this.f369d.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList a(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }
}
