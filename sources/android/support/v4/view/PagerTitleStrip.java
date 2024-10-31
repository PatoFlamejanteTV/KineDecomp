package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: a */
    private static final int[] f1815a = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: b */
    private static final int[] f1816b = {R.attr.textAllCaps};

    /* renamed from: c */
    ViewPager f1817c;

    /* renamed from: d */
    TextView f1818d;

    /* renamed from: e */
    TextView f1819e;

    /* renamed from: f */
    TextView f1820f;

    /* renamed from: g */
    private int f1821g;

    /* renamed from: h */
    float f1822h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final PageListener m;
    private WeakReference<PagerAdapter> n;
    private int o;
    int p;

    /* loaded from: classes.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private int f1823a;

        PageListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a(pagerTitleStrip.f1817c.getCurrentItem(), PagerTitleStrip.this.f1817c.getAdapter());
            float f2 = PagerTitleStrip.this.f1822h;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.f1817c.getCurrentItem(), f2, true);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f1823a = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (f2 > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f2, false);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.f1823a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a(pagerTitleStrip.f1817c.getCurrentItem(), PagerTitleStrip.this.f1817c.getAdapter());
                float f2 = PagerTitleStrip.this.f1822h;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.f1817c.getCurrentItem(), f2, true);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f1825a;

        SingleLineAllCapsTransform(Context context) {
            this.f1825a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f1825a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    void a(int i, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.k = true;
        CharSequence charSequence = null;
        this.f1818d.setText((i < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i - 1));
        this.f1819e.setText((pagerAdapter == null || i >= count) ? null : pagerAdapter.getPageTitle(i));
        int i2 = i + 1;
        if (i2 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i2);
        }
        this.f1820f.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f1818d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1819e.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1820f.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1821g = i;
        if (!this.l) {
            a(i, this.f1822h, false);
        }
        this.k = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.a(this.m);
            viewPager.addOnAdapterChangeListener(this.m);
            this.f1817c = viewPager;
            WeakReference<PagerAdapter> weakReference = this.n;
            a(weakReference != null ? weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f1817c;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (PagerAdapter) null);
            this.f1817c.a((ViewPager.OnPageChangeListener) null);
            this.f1817c.removeOnAdapterChangeListener(this.m);
            this.f1817c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1817c != null) {
            float f2 = this.f1822h;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            a(this.f1821g, f2, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
            this.f1818d.measure(childMeasureSpec2, childMeasureSpec);
            this.f1819e.measure(childMeasureSpec2, childMeasureSpec);
            this.f1820f.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                max = View.MeasureSpec.getSize(i2);
            } else {
                max = Math.max(getMinHeight(), this.f1819e.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.f1819e.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.k) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i) {
        this.j = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        this.o = ((int) (f2 * 255.0f)) & 255;
        int i = (this.o << 24) | (this.p & ViewCompat.MEASURED_SIZE_MASK);
        this.f1818d.setTextColor(i);
        this.f1820f.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.p = i;
        this.f1819e.setTextColor(i);
        int i2 = (this.o << 24) | (this.p & ViewCompat.MEASURED_SIZE_MASK);
        this.f1818d.setTextColor(i2);
        this.f1820f.setTextColor(i2);
    }

    public void setTextSize(int i, float f2) {
        this.f1818d.setTextSize(i, f2);
        this.f1819e.setTextSize(i, f2);
        this.f1820f.setTextSize(i, f2);
    }

    public void setTextSpacing(int i) {
        this.i = i;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1821g = -1;
        this.f1822h = -1.0f;
        this.m = new PageListener();
        TextView textView = new TextView(context);
        this.f1818d = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f1819e = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f1820f = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1815a);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.f1818d, resourceId);
            TextViewCompat.setTextAppearance(this.f1819e, resourceId);
            TextViewCompat.setTextAppearance(this.f1820f, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f1818d.setTextColor(color);
            this.f1819e.setTextColor(color);
            this.f1820f.setTextColor(color);
        }
        this.j = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.p = this.f1819e.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f1818d.setEllipsize(TextUtils.TruncateAt.END);
        this.f1819e.setEllipsize(TextUtils.TruncateAt.END);
        this.f1820f.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f1816b);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f1818d);
            setSingleLineAllCaps(this.f1819e);
            setSingleLineAllCaps(this.f1820f);
        } else {
            this.f1818d.setSingleLine();
            this.f1819e.setSingleLine();
            this.f1820f.setSingleLine();
        }
        this.i = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.m);
            this.n = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.m);
            this.n = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f1817c;
        if (viewPager != null) {
            this.f1821g = -1;
            this.f1822h = -1.0f;
            a(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public void a(int i, float f2, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i != this.f1821g) {
            a(i, this.f1817c.getAdapter());
        } else if (!z && f2 == this.f1822h) {
            return;
        }
        this.l = true;
        int measuredWidth = this.f1818d.getMeasuredWidth();
        int measuredWidth2 = this.f1819e.getMeasuredWidth();
        int measuredWidth3 = this.f1820f.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (i8 * f3))) - i6;
        int i10 = measuredWidth2 + i9;
        int baseline = this.f1818d.getBaseline();
        int baseline2 = this.f1819e.getBaseline();
        int baseline3 = this.f1820f.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int max2 = Math.max(Math.max(this.f1818d.getMeasuredHeight() + i11, this.f1819e.getMeasuredHeight() + i12), this.f1820f.getMeasuredHeight() + i13);
        int i14 = this.j & 112;
        if (i14 == 16) {
            i2 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else {
            if (i14 != 80) {
                i3 = i11 + paddingTop;
                i4 = i12 + paddingTop;
                i5 = paddingTop + i13;
                TextView textView = this.f1819e;
                textView.layout(i9, i4, i10, textView.getMeasuredHeight() + i4);
                int min = Math.min(paddingLeft, (i9 - this.i) - measuredWidth);
                TextView textView2 = this.f1818d;
                textView2.layout(min, i3, measuredWidth + min, textView2.getMeasuredHeight() + i3);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.i);
                TextView textView3 = this.f1820f;
                textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
                this.f1822h = f2;
                this.l = false;
            }
            i2 = (height - paddingBottom) - max2;
        }
        i3 = i11 + i2;
        i4 = i12 + i2;
        i5 = i2 + i13;
        TextView textView4 = this.f1819e;
        textView4.layout(i9, i4, i10, textView4.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i9 - this.i) - measuredWidth);
        TextView textView22 = this.f1818d;
        textView22.layout(min2, i3, measuredWidth + min2, textView22.getMeasuredHeight() + i3);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.i);
        TextView textView32 = this.f1820f;
        textView32.layout(max32, i5, max32 + measuredWidth3, textView32.getMeasuredHeight() + i5);
        this.f1822h = f2;
        this.l = false;
    }
}
