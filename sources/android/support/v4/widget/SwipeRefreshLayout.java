package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final String f2037a = "SwipeRefreshLayout";

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2038b = {R.attr.enabled};
    protected int A;
    int B;
    CircularProgressDrawable C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private OnChildScrollUpCallback L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;

    /* renamed from: c, reason: collision with root package name */
    private View f2039c;

    /* renamed from: d, reason: collision with root package name */
    OnRefreshListener f2040d;

    /* renamed from: e, reason: collision with root package name */
    boolean f2041e;

    /* renamed from: f, reason: collision with root package name */
    private int f2042f;

    /* renamed from: g, reason: collision with root package name */
    private float f2043g;

    /* renamed from: h, reason: collision with root package name */
    private float f2044h;
    private final NestedScrollingParentHelper i;
    private final NestedScrollingChildHelper j;
    private final int[] k;
    private final int[] l;
    private boolean m;
    private int n;
    int o;
    private float p;
    private float q;
    private boolean r;
    private int s;
    boolean t;
    private boolean u;
    private final DecelerateInterpolator v;
    CircleImageView w;
    private int x;
    protected int y;
    float z;

    /* loaded from: classes.dex */
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void b() {
        this.w = new CircleImageView(getContext(), -328966);
        this.C = new CircularProgressDrawable(getContext());
        this.C.setStyle(1);
        this.w.setImageDrawable(this.C);
        this.w.setVisibility(8);
        addView(this.w);
    }

    private void c() {
        if (this.f2039c == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.w)) {
                    this.f2039c = childAt;
                    return;
                }
            }
        }
    }

    private void d() {
        this.G = a(this.C.getAlpha(), 255);
    }

    private void e() {
        this.F = a(this.C.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i) {
        this.w.getBackground().setAlpha(i);
        this.C.setAlpha(i);
    }

    void a() {
        this.w.clearAnimation();
        this.C.stop();
        this.w.setVisibility(8);
        setColorViewAlpha(255);
        if (this.t) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.A - this.o);
        }
        this.o = this.w.getTop();
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.L;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.f2039c);
        }
        View view = this.f2039c;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.j.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.j.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.j.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.x;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.i.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.B;
    }

    public int getProgressViewStartOffset() {
        return this.A;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.f2041e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || canChildScrollUp() || this.f2041e || this.m) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.s;
                    if (i == -1) {
                        Log.e(f2037a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.r = false;
            this.s = -1;
        } else {
            setTargetOffsetTopAndBottom(this.A - this.w.getTop());
            this.s = motionEvent.getPointerId(0);
            this.r = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.s);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.q = motionEvent.getY(findPointerIndex2);
        }
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2039c == null) {
            c();
        }
        View view = this.f2039c;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.w.getMeasuredWidth();
        int measuredHeight2 = this.w.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.o;
        this.w.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2039c == null) {
            c();
        }
        View view = this.f2039c;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.w.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.x = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.w) {
                this.x = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f2 = this.f2044h;
            if (f2 > 0.0f) {
                float f3 = i2;
                if (f3 > f2) {
                    iArr[1] = i2 - ((int) f2);
                    this.f2044h = 0.0f;
                } else {
                    this.f2044h = f2 - f3;
                    iArr[1] = i2;
                }
                c(this.f2044h);
            }
        }
        if (this.K && i2 > 0 && this.f2044h == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.w.setVisibility(8);
        }
        int[] iArr2 = this.k;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.l);
        if (i4 + this.l[1] >= 0 || canChildScrollUp()) {
            return;
        }
        this.f2044h += Math.abs(r11);
        c(this.f2044h);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.i.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f2044h = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.u || this.f2041e || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.i.onStopNestedScroll(view);
        this.m = false;
        float f2 = this.f2044h;
        if (f2 > 0.0f) {
            b(f2);
            this.f2044h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.u && actionMasked == 0) {
            this.u = false;
        }
        if (!isEnabled() || this.u || canChildScrollUp() || this.f2041e || this.m) {
            return false;
        }
        if (actionMasked == 0) {
            this.s = motionEvent.getPointerId(0);
            this.r = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.s);
                if (findPointerIndex < 0) {
                    Log.e(f2037a, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.r) {
                    float y = (motionEvent.getY(findPointerIndex) - this.p) * 0.5f;
                    this.r = false;
                    b(y);
                }
                this.s = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.s);
                if (findPointerIndex2 < 0) {
                    Log.e(f2037a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                d(y2);
                if (this.r) {
                    float f2 = (y2 - this.p) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    c(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(f2037a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.s = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    a(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2039c instanceof AbsListView)) {
            View view = this.f2039c;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void setAnimationProgress(float f2) {
        this.w.setScaleX(f2);
        this.w.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        c();
        this.C.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f2043g = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        a();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.j.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.L = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f2040d = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.w.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.B = i;
        this.t = z;
        this.w.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.t = z;
        this.A = i;
        this.B = i2;
        this.K = true;
        a();
        this.f2041e = false;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.f2041e != z) {
            this.f2041e = z;
            if (!this.K) {
                i = this.B + this.A;
            } else {
                i = this.B;
            }
            setTargetOffsetTopAndBottom(i - this.o);
            this.I = false;
            b(this.M);
            return;
        }
        a(z, false);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.w.setImageDrawable(null);
            this.C.setStyle(i);
            this.w.setImageDrawable(this.C);
        }
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.w.bringToFront();
        ViewCompat.offsetTopAndBottom(this.w, i);
        this.o = this.w.getTop();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.j.startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2041e = false;
        this.f2043g = -1.0f;
        this.k = new int[2];
        this.l = new int[2];
        this.s = -1;
        this.x = -1;
        this.M = new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.f2041e) {
                    swipeRefreshLayout.C.setAlpha(255);
                    SwipeRefreshLayout.this.C.start();
                    SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                    if (swipeRefreshLayout2.I && (onRefreshListener = swipeRefreshLayout2.f2040d) != null) {
                        onRefreshListener.onRefresh();
                    }
                    SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                    swipeRefreshLayout3.o = swipeRefreshLayout3.w.getTop();
                    return;
                }
                swipeRefreshLayout.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.N = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                int i;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.K) {
                    i = swipeRefreshLayout.B - Math.abs(swipeRefreshLayout.A);
                } else {
                    i = swipeRefreshLayout.B;
                }
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.y + ((int) ((i - r1) * f2))) - swipeRefreshLayout2.w.getTop());
                SwipeRefreshLayout.this.C.setArrowScale(1.0f - f2);
            }
        };
        this.O = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.f2042f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.v = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        b();
        setChildrenDrawingOrderEnabled(true);
        this.B = (int) (displayMetrics.density * 64.0f);
        this.f2043g = this.B;
        this.i = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.J;
        this.o = i;
        this.A = i;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2038b);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void d(float f2) {
        float f3 = this.q;
        float f4 = f2 - f3;
        int i = this.f2042f;
        if (f4 <= i || this.r) {
            return;
        }
        this.p = f3 + i;
        this.r = true;
        this.C.setAlpha(76);
    }

    private void c(float f2) {
        this.C.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f2043g));
        double d2 = min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f2043g;
        float f3 = this.K ? this.B - this.A : this.B;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i = this.A + ((int) ((f3 * min) + (f3 * f4 * 2.0f)));
        if (this.w.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        if (!this.t) {
            this.w.setScaleX(1.0f);
            this.w.setScaleY(1.0f);
        }
        if (this.t) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f2043g));
        }
        if (f2 < this.f2043g) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                e();
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            d();
        }
        this.C.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.setArrowScale(Math.min(1.0f, max));
        this.C.setProgressRotation((((max * 0.4f) - 0.25f) + (f4 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.o);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.w.setVisibility(0);
        this.C.setAlpha(255);
        this.D = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.D.setDuration(this.n);
        if (animationListener != null) {
            this.w.setAnimationListener(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.D);
    }

    private void a(boolean z, boolean z2) {
        if (this.f2041e != z) {
            this.I = z2;
            c();
            this.f2041e = z;
            if (this.f2041e) {
                a(this.o, this.M);
            } else {
                a(this.M);
            }
        }
    }

    private void b(float f2) {
        if (f2 > this.f2043g) {
            a(true, true);
            return;
        }
        this.f2041e = false;
        this.C.setStartEndTrim(0.0f, 0.0f);
        b(this.o, this.t ? null : new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.t) {
                    return;
                }
                swipeRefreshLayout.a((Animation.AnimationListener) null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.C.setArrowEnabled(false);
    }

    void a(Animation.AnimationListener animationListener) {
        this.E = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.E.setDuration(150L);
        this.w.setAnimationListener(animationListener);
        this.w.clearAnimation();
        this.w.startAnimation(this.E);
    }

    private Animation a(final int i, final int i2) {
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.C.setAlpha((int) (i + ((i2 - r0) * f2)));
            }
        };
        animation.setDuration(300L);
        this.w.setAnimationListener(null);
        this.w.clearAnimation();
        this.w.startAnimation(animation);
        return animation;
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        if (this.t) {
            c(i, animationListener);
            return;
        }
        this.y = i;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.v);
        if (animationListener != null) {
            this.w.setAnimationListener(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.O);
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        this.y = i;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.v);
        if (animationListener != null) {
            this.w.setAnimationListener(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.N);
    }

    private void c(int i, Animation.AnimationListener animationListener) {
        this.y = i;
        this.z = this.w.getScaleX();
        this.H = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f3 = swipeRefreshLayout.z;
                swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.H.setDuration(150L);
        if (animationListener != null) {
            this.w.setAnimationListener(animationListener);
        }
        this.w.clearAnimation();
        this.w.startAnimation(this.H);
    }

    void a(float f2) {
        setTargetOffsetTopAndBottom((this.y + ((int) ((this.A - r0) * f2))) - this.w.getTop());
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.s) {
            this.s = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
