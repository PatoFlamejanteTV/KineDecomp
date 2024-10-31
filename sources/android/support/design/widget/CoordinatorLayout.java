package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DirectedAcyclicGraph;
import android.support.v4.widget.ViewGroupUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {

    /* renamed from: a */
    static final String f343a;

    /* renamed from: b */
    static final Class<?>[] f344b;

    /* renamed from: c */
    static final ThreadLocal<Map<String, Constructor<b>>> f345c;

    /* renamed from: d */
    static final Comparator<View> f346d;

    /* renamed from: e */
    private static final Pools.Pool<Rect> f347e;

    /* renamed from: f */
    private final List<View> f348f;

    /* renamed from: g */
    private final DirectedAcyclicGraph<View> f349g;

    /* renamed from: h */
    private final List<View> f350h;
    private final List<View> i;
    private final int[] j;
    private Paint k;
    private boolean l;
    private boolean m;
    private int[] n;
    private View o;
    private View p;
    private f q;
    private boolean r;
    private WindowInsetsCompat s;
    private boolean t;
    private Drawable u;
    ViewGroup.OnHierarchyChangeListener v;
    private OnApplyWindowInsetsListener w;
    private final NestedScrollingParentHelper x;

    /* loaded from: classes.dex */
    public interface a {
        b a();
    }

    /* loaded from: classes.dex */
    public static abstract class b<V extends View> {
        public b() {
        }

        public WindowInsetsCompat a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void a() {
        }

        public void a(e eVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, i3, i4);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i, i2, iArr);
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface c {
        Class<? extends b> value();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float z = ViewCompat.getZ(view);
            float z2 = ViewCompat.getZ(view2);
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f343a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f346d = new h();
        } else {
            f346d = null;
        }
        f344b = new Class[]{Context.class, AttributeSet.class};
        f345c = new ThreadLocal<>();
        f347e = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f347e.release(rect);
    }

    private int b(int i) {
        int[] iArr = this.n;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    private static int c(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int d(int i) {
        if ((i & 7) == 0) {
            i |= GravityCompat.START;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static Rect d() {
        Rect acquire = f347e.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private static int e(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private void e() {
        this.f348f.clear();
        this.f349g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e d2 = d(childAt);
            d2.a(this, childAt);
            this.f349g.addNode(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.f349g.contains(childAt2)) {
                            this.f349g.addNode(childAt2);
                        }
                        this.f349g.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.f348f.addAll(this.f349g.getSortedList());
        Collections.reverse(this.f348f);
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.w == null) {
                this.w = new C0188n(this);
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.w);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    void c(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        b bVar = eVar.f352a;
        if (bVar != null) {
            float c2 = bVar.c(this, view);
            if (c2 > 0.0f) {
                if (this.k == null) {
                    this.k = new Paint();
                }
                this.k.setColor(eVar.f352a.b(this, view));
                this.k.setAlpha(MathUtils.clamp(Math.round(c2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.k);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    final List<View> getDependencySortedChildren() {
        e();
        return Collections.unmodifiableList(this.f348f);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.s;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.x.getNestedScrollAxes();
    }

    public Drawable getStatusBarBackground() {
        return this.u;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.r) {
            if (this.q == null) {
                this.q = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        if (this.s == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.r && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        View view = this.p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.m = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.t || this.u == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.s;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.u.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.u.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b d2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f348f.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f348f.get(i5);
            if (view.getVisibility() != 8 && ((d2 = ((e) view.getLayoutParams()).d()) == null || !d2.a(this, (CoordinatorLayout) view, layoutDirection))) {
                b(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0117, code lost:            if (r0.a(r30, (android.support.design.widget.CoordinatorLayout) r20, r11, r21, r23, 0) == false) goto L100;     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        b d2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0) && (d2 = eVar.d()) != null) {
                    z2 |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        b d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0) && (d2 = eVar.d()) != null) {
                    z |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        SparseArray<Parcelable> sparseArray = gVar.f361b;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b d2 = d(childAt).d();
            if (id != -1 && d2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                d2.a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable d2;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b d3 = ((e) childAt.getLayoutParams()).d();
            if (id != -1 && d3 != null && (d2 = d3.d(this, childAt)) != null) {
                sparseArray.append(id, d2);
            }
        }
        gVar.f361b = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:            if (r3 != false) goto L32;     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$e r6 = (android.support.design.widget.CoordinatorLayout.e) r6
            android.support.design.widget.CoordinatorLayout$b r6 = r6.d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.o
            boolean r6 = r6.b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.o
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b d2 = ((e) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, (CoordinatorLayout) view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.l) {
            return;
        }
        a(false);
        this.l = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        f();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.v = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.u = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.u;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.u, ViewCompat.getLayoutDirection(this));
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.u;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.u.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b.b.a.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        b d2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i3) && (d2 = eVar.d()) != null) {
                    int[] iArr2 = this.j;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    d2.a(this, (CoordinatorLayout) childAt, view, i, i2, iArr2, i3);
                    if (i > 0) {
                        min = Math.max(i4, this.j[0]);
                    } else {
                        min = Math.min(i4, this.j[0]);
                    }
                    if (i2 > 0) {
                        min2 = Math.max(i5, this.j[1]);
                    } else {
                        min2 = Math.min(i5, this.j[1]);
                    }
                    i4 = min;
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            a(1);
        }
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        b d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i5) && (d2 = eVar.d()) != null) {
                    d2.a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        b d2;
        this.x.onNestedScrollAccepted(view, view2, i, i2);
        this.p = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.a(i2) && (d2 = eVar.d()) != null) {
                d2.a(this, (CoordinatorLayout) childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b d2 = eVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i, i2);
                    eVar.a(i2, b2);
                    z |= b2;
                } else {
                    eVar.a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.x.onStopNestedScroll(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.a(i)) {
                b d2 = eVar.d();
                if (d2 != null) {
                    d2.a(this, (CoordinatorLayout) childAt, view, i);
                }
                eVar.b(i);
                eVar.g();
            }
        }
        this.p = null;
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        b f352a;

        /* renamed from: b */
        boolean f353b;

        /* renamed from: c */
        public int f354c;

        /* renamed from: d */
        public int f355d;

        /* renamed from: e */
        public int f356e;

        /* renamed from: f */
        int f357f;

        /* renamed from: g */
        public int f358g;

        /* renamed from: h */
        public int f359h;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public e(int i, int i2) {
            super(i, i2);
            this.f353b = false;
            this.f354c = 0;
            this.f355d = 0;
            this.f356e = -1;
            this.f357f = -1;
            this.f358g = 0;
            this.f359h = 0;
            this.q = new Rect();
        }

        public void a(b bVar) {
            b bVar2 = this.f352a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.a();
                }
                this.f352a = bVar;
                this.r = null;
                this.f353b = true;
                if (bVar != null) {
                    bVar.a(this);
                }
            }
        }

        boolean b() {
            if (this.f352a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f357f;
        }

        public b d() {
            return this.f352a;
        }

        boolean e() {
            return this.p;
        }

        Rect f() {
            return this.q;
        }

        void g() {
            this.p = false;
        }

        void h() {
            this.m = false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            b bVar = this.f352a;
            boolean a2 = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        void a(Rect rect) {
            this.q.set(rect);
        }

        void b(int i) {
            a(i, false);
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f357f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view2;
            return true;
        }

        boolean a() {
            return this.k == null && this.f357f != -1;
        }

        void a(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.o = z;
            }
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f353b = false;
            this.f354c = 0;
            this.f355d = 0;
            this.f356e = -1;
            this.f357f = -1;
            this.f358g = 0;
            this.f359h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.c.CoordinatorLayout_Layout);
            this.f354c = obtainStyledAttributes.getInteger(b.b.b.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f357f = obtainStyledAttributes.getResourceId(b.b.b.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f355d = obtainStyledAttributes.getInteger(b.b.b.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f356e = obtainStyledAttributes.getInteger(b.b.b.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f358g = obtainStyledAttributes.getInt(b.b.b.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f359h = obtainStyledAttributes.getInt(b.b.b.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f353b = obtainStyledAttributes.hasValue(b.b.b.c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f353b) {
                this.f352a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(b.b.b.c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            b bVar = this.f352a;
            if (bVar != null) {
                bVar.a(this);
            }
        }

        boolean a(int i) {
            if (i == 0) {
                return this.n;
            }
            if (i != 1) {
                return false;
            }
            return this.o;
        }

        void a(boolean z) {
            this.p = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.l || a(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((bVar = this.f352a) != null && bVar.a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f357f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f357f);
            View view2 = this.k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f357f) + " to anchor view " + view);
            }
            if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f353b = false;
            this.f354c = 0;
            this.f355d = 0;
            this.f356e = -1;
            this.f357f = -1;
            this.f358g = 0;
            this.f359h = 0;
            this.q = new Rect();
        }

        private boolean a(View view, int i) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((e) view.getLayoutParams()).f358g, i);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f359h, i) & absoluteGravity) == absoluteGravity;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f353b = false;
            this.f354c = 0;
            this.f355d = 0;
            this.f356e = -1;
            this.f357f = -1;
            this.f358g = 0;
            this.f359h = 0;
            this.q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f353b = false;
            this.f354c = 0;
            this.f355d = 0;
            this.f356e = -1;
            this.f357f = -1;
            this.f358g = 0;
            this.f359h = 0;
            this.q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.f348f = new ArrayList();
        this.f349g = new DirectedAcyclicGraph<>();
        this.f350h = new ArrayList();
        this.i = new ArrayList();
        this.j = new int[2];
        this.x = new NestedScrollingParentHelper(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.c.CoordinatorLayout, 0, b.b.b.b.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.c.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(b.b.b.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.n = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.n.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.n[i2] = (int) (r1[i2] * f2);
            }
        }
        this.u = obtainStyledAttributes.getDrawable(b.b.b.c.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        f();
        super.setOnHierarchyChangeListener(new d());
    }

    private void c(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect d2 = d();
        d2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.s != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            d2.left += this.s.getSystemWindowInsetLeft();
            d2.top += this.s.getSystemWindowInsetTop();
            d2.right -= this.s.getSystemWindowInsetRight();
            d2.bottom -= this.s.getSystemWindowInsetBottom();
        }
        Rect d3 = d();
        GravityCompat.apply(d(eVar.f354c), view.getMeasuredWidth(), view.getMeasuredHeight(), d2, d3, i);
        view.layout(d3.left, d3.top, d3.right, d3.bottom);
        a(d2);
        a(d3);
    }

    public final WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.equals(this.s, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.s = windowInsetsCompat;
        this.t = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        setWillNotDraw(!this.t && getBackground() == null);
        WindowInsetsCompat b2 = b(windowInsetsCompat);
        requestLayout();
        return b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e d(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f353b) {
            if (view instanceof a) {
                b a2 = ((a) view).a();
                if (a2 == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.a(a2);
                eVar.f353b = true;
            } else {
                c cVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.a(cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                eVar.f353b = true;
            }
        }
        return eVar;
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    private WindowInsetsCompat b(WindowInsetsCompat windowInsetsCompat) {
        b d2;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt) && (d2 = ((e) childAt.getLayoutParams()).d()) != null) {
                windowInsetsCompat = d2.a(this, (CoordinatorLayout) childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class g extends AbsSavedState {
        public static final Parcelable.Creator<g> CREATOR = new C0189o();

        /* renamed from: b */
        SparseArray<Parcelable> f361b;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f361b = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f361b.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f361b;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f361b.keyAt(i2);
                parcelableArr[i2] = this.f361b.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b d2 = ((e) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    d2.a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    d2.b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).h();
        }
        this.o = null;
        this.l = false;
    }

    public void b(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.a()) {
            View view2 = eVar.k;
            if (view2 != null) {
                a(view, view2, i);
                return;
            }
            int i2 = eVar.f356e;
            if (i2 >= 0) {
                b(view, i2, i);
                return;
            } else {
                c(view, i);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    private void e(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int i2 = eVar.j;
        if (i2 != i) {
            ViewCompat.offsetTopAndBottom(view, i - i2);
            eVar.j = i;
        }
    }

    private void d(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int i2 = eVar.i;
        if (i2 != i) {
            ViewCompat.offsetLeftAndRight(view, i - i2);
            eVar.i = i;
        }
    }

    private boolean e(View view) {
        return this.f349g.hasOutgoingEdges(view);
    }

    void b(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).f());
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = f346d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public List<View> c(View view) {
        List incomingEdges = this.f349g.getIncomingEdges(view);
        this.i.clear();
        if (incomingEdges != null) {
            this.i.addAll(incomingEdges);
        }
        return this.i;
    }

    private void b(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(e(eVar.f354c), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b2 = b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            b2 += measuredWidth / 2;
        } else if (i3 == 5) {
            b2 += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    void c() {
        if (this.m && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        this.r = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f350h;
        a(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            e eVar = (e) view.getLayoutParams();
            b d2 = eVar.d();
            if (!(z || z2) || actionMasked == 0) {
                if (!z && d2 != null) {
                    if (i == 0) {
                        z = d2.a(this, (CoordinatorLayout) view, motionEvent);
                    } else if (i == 1) {
                        z = d2.b(this, (CoordinatorLayout) view, motionEvent);
                    }
                    if (z) {
                        this.o = view;
                    }
                }
                boolean b2 = eVar.b();
                boolean b3 = eVar.b(this, view);
                boolean z3 = b3 && !b2;
                if (b3 && !z3) {
                    break;
                }
                z2 = z3;
            } else if (d2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    d2.a(this, (CoordinatorLayout) view, motionEvent2);
                } else if (i == 1) {
                    d2.b(this, (CoordinatorLayout) view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    public List<View> b(View view) {
        List<View> outgoingEdges = this.f349g.getOutgoingEdges(view);
        this.i.clear();
        if (outgoingEdges != null) {
            this.i.addAll(outgoingEdges);
        }
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static b a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f343a)) {
            str = f343a + '.' + str;
        }
        try {
            Map map = f345c.get();
            if (map == null) {
                map = new HashMap();
                f345c.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f344b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.r) {
            if (z) {
                a();
            } else {
                c();
            }
        }
    }

    void a(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int width;
        int height;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(c(eVar.f354c), i);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(d(eVar.f355d), i);
        int i4 = absoluteGravity & 7;
        int i5 = absoluteGravity & 112;
        int i6 = absoluteGravity2 & 7;
        int i7 = absoluteGravity2 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void a(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        a(eVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i) {
        Rect d2 = d();
        Rect d3 = d();
        try {
            a(view2, d2);
            a(view, i, d2, d3);
            view.layout(d3.left, d3.top, d3.right, d3.bottom);
        } finally {
            a(d2);
            a(d3);
        }
    }

    final void a(int i) {
        boolean z;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f348f.size();
        Rect d2 = d();
        Rect d3 = d();
        Rect d4 = d();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f348f.get(i2);
            e eVar = (e) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (eVar.l == this.f348f.get(i3)) {
                        a(view, layoutDirection);
                    }
                }
                a(view, true, d3);
                if (eVar.f358g != 0 && !d3.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.f358g, layoutDirection);
                    int i4 = absoluteGravity & 112;
                    if (i4 == 48) {
                        d2.top = Math.max(d2.top, d3.bottom);
                    } else if (i4 == 80) {
                        d2.bottom = Math.max(d2.bottom, getHeight() - d3.top);
                    }
                    int i5 = absoluteGravity & 7;
                    if (i5 == 3) {
                        d2.left = Math.max(d2.left, d3.right);
                    } else if (i5 == 5) {
                        d2.right = Math.max(d2.right, getWidth() - d3.left);
                    }
                }
                if (eVar.f359h != 0 && view.getVisibility() == 0) {
                    a(view, d2, layoutDirection);
                }
                if (i != 2) {
                    b(view, d4);
                    if (!d4.equals(d3)) {
                        c(view, d3);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.f348f.get(i6);
                    e eVar2 = (e) view2.getLayoutParams();
                    b d5 = eVar2.d();
                    if (d5 != null && d5.a(this, (CoordinatorLayout) view2, view)) {
                        if (i == 0 && eVar2.e()) {
                            eVar2.g();
                        } else {
                            if (i != 2) {
                                z = d5.b(this, (CoordinatorLayout) view2, view);
                            } else {
                                d5.c(this, view2, view);
                                z = true;
                            }
                            if (i == 1) {
                                eVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(d2);
        a(d3);
        a(d4);
    }

    private void a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b d2 = eVar.d();
            Rect d3 = d();
            Rect d4 = d();
            d4.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 != null && d2.a(this, (CoordinatorLayout) view, d3)) {
                if (!d4.contains(d3)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + d3.toShortString() + " | Bounds:" + d4.toShortString());
                }
            } else {
                d3.set(d4);
            }
            a(d4);
            if (d3.isEmpty()) {
                a(d3);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.f359h, i);
            if ((absoluteGravity & 48) != 48 || (i6 = (d3.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.j) >= (i7 = rect.top)) {
                z = false;
            } else {
                e(view, i7 - i6);
                z = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - d3.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.j) < (i5 = rect.bottom)) {
                e(view, height - i5);
                z = true;
            }
            if (!z) {
                e(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i3 = (d3.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                d(view, i4 - i3);
                z2 = true;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - d3.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.i) < (i2 = rect.right)) {
                d(view, width - i2);
                z2 = true;
            }
            if (!z2) {
                d(view, 0);
            }
            a(d3);
        }
    }

    public void a(View view) {
        List incomingEdges = this.f349g.getIncomingEdges(view);
        if (incomingEdges == null || incomingEdges.isEmpty()) {
            return;
        }
        for (int i = 0; i < incomingEdges.size(); i++) {
            View view2 = (View) incomingEdges.get(i);
            b d2 = ((e) view2.getLayoutParams()).d();
            if (d2 != null) {
                d2.b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    void a() {
        if (this.m) {
            if (this.q == null) {
                this.q = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        this.r = true;
    }

    void a(View view, int i) {
        b d2;
        e eVar = (e) view.getLayoutParams();
        if (eVar.k != null) {
            Rect d3 = d();
            Rect d4 = d();
            Rect d5 = d();
            a(eVar.k, d3);
            a(view, false, d4);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, d3, d5, eVar, measuredWidth, measuredHeight);
            boolean z = (d5.left == d4.left && d5.top == d4.top) ? false : true;
            a(eVar, d5, measuredWidth, measuredHeight);
            int i2 = d5.left - d4.left;
            int i3 = d5.top - d4.top;
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(view, i3);
            }
            if (z && (d2 = eVar.d()) != null) {
                d2.b(this, (CoordinatorLayout) view, eVar.k);
            }
            a(d3);
            a(d4);
            a(d5);
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect d2 = d();
        a(view, d2);
        try {
            return d2.contains(i, i2);
        } finally {
            a(d2);
        }
    }

    public boolean a(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect d2 = d();
        a(view, view.getParent() != this, d2);
        Rect d3 = d();
        a(view2, view2.getParent() != this, d3);
        try {
            if (d2.left <= d3.right && d2.top <= d3.bottom && d2.right >= d3.left) {
                if (d2.bottom >= d3.top) {
                    z = true;
                }
            }
            return z;
        } finally {
            a(d2);
            a(d3);
        }
    }
}
