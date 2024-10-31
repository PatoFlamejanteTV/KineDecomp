package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f2544a = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    private final Runnable A;
    private final Runnable B;
    private final NestedScrollingParentHelper C;

    /* renamed from: b, reason: collision with root package name */
    private int f2545b;

    /* renamed from: c, reason: collision with root package name */
    private int f2546c;

    /* renamed from: d, reason: collision with root package name */
    private ContentFrameLayout f2547d;

    /* renamed from: e, reason: collision with root package name */
    ActionBarContainer f2548e;

    /* renamed from: f, reason: collision with root package name */
    private DecorToolbar f2549f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f2550g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2551h;
    private boolean i;
    private boolean j;
    private boolean k;
    boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private ActionBarVisibilityCallback v;
    private final int w;
    private OverScroller x;
    ViewPropertyAnimator y;
    final AnimatorListenerAdapter z;

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2544a);
        this.f2545b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2550g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f2550g == null);
        obtainStyledAttributes.recycle();
        this.f2551h = context.getApplicationInfo().targetSdkVersion < 19;
        this.x = new OverScroller(context);
    }

    private void c() {
        a();
        this.B.run();
    }

    private void d() {
        a();
        postDelayed(this.B, 600L);
    }

    private void e() {
        a();
        postDelayed(this.A, 600L);
    }

    private void f() {
        a();
        this.A.run();
    }

    void b() {
        if (this.f2547d == null) {
            this.f2547d = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2548e = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f2549f = a(findViewById(R.id.action_bar));
        }
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        b();
        return this.f2549f.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void dismissPopups() {
        b();
        this.f2549f.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2550g == null || this.f2551h) {
            return;
        }
        int bottom = this.f2548e.getVisibility() == 0 ? (int) (this.f2548e.getBottom() + this.f2548e.getTranslationY() + 0.5f) : 0;
        this.f2550g.setBounds(0, bottom, getWidth(), this.f2550g.getIntrinsicHeight() + bottom);
        this.f2550g.draw(canvas);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        b();
        int windowSystemUiVisibility = ViewCompat.getWindowSystemUiVisibility(this) & 256;
        boolean a2 = a(this.f2548e, rect, true, true, false, true);
        this.r.set(rect);
        ViewUtils.computeFitSystemWindows(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            a2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2548e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.C.getNestedScrollAxes();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public CharSequence getTitle() {
        b();
        return this.f2549f.getTitle();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasIcon() {
        b();
        return this.f2549f.hasIcon();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hasLogo() {
        b();
        return this.f2549f.hasLogo();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        b();
        return this.f2549f.hideOverflowMenu();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void initFeature(int i) {
        b();
        if (i == 2) {
            this.f2549f.initProgress();
        } else if (i == 5) {
            this.f2549f.initIndeterminateProgress();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.k;
    }

    public boolean isInOverlayMode() {
        return this.i;
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        b();
        return this.f2549f.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        b();
        return this.f2549f.isOverflowMenuShowing();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        b();
        measureChildWithMargins(this.f2548e, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f2548e.getLayoutParams();
        int max = Math.max(0, this.f2548e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f2548e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2548e.getMeasuredState());
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f2545b;
            if (this.j && this.f2548e.getTabContainer() != null) {
                measuredHeight += this.f2545b;
            }
        } else {
            measuredHeight = this.f2548e.getVisibility() != 8 ? this.f2548e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.t.set(this.r);
        if (!this.i && !z) {
            Rect rect = this.q;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        a(this.f2547d, this.q, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.f2547d.dispatchFitSystemWindows(this.t);
        }
        measureChildWithMargins(this.f2547d, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f2547d.getLayoutParams();
        int max3 = Math.max(max, this.f2547d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.f2547d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2547d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.k || !z) {
            return false;
        }
        if (a(f2, f3)) {
            c();
        } else {
            f();
        }
        this.l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.m += i2;
        setActionBarHideOffset(this.m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.C.onNestedScrollAccepted(view, view2, i);
        this.m = getActionBarHideOffset();
        a();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.v;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f2548e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.f2548e.getHeight()) {
                e();
            } else {
                d();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.v;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        b();
        int i2 = this.n ^ i;
        this.n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.v;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z2);
            if (!z && z2) {
                this.v.hideForSystem();
            } else {
                this.v.showForSystem();
            }
        }
        if ((i2 & 256) == 0 || this.v == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f2546c = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.v;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i);
        }
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        b();
        this.f2549f.restoreHierarchyState(sparseArray);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        b();
        this.f2549f.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        a();
        this.f2548e.setTranslationY(-Math.max(0, Math.min(i, this.f2548e.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.v = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.v.onWindowVisibilityChanged(this.f2546c);
            int i = this.n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                return;
            }
            a();
            setActionBarHideOffset(0);
        }
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(int i) {
        b();
        this.f2549f.setIcon(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setLogo(int i) {
        b();
        this.f2549f.setLogo(i);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        b();
        this.f2549f.setMenu(menu, callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setMenuPrepared() {
        b();
        this.f2549f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        this.f2551h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setUiOptions(int i) {
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        b();
        this.f2549f.setWindowCallback(callback);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        b();
        this.f2549f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.support.v7.widget.DecorContentParent
    public boolean showOverflowMenu() {
        b();
        return this.f2549f.showOverflowMenu();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2546c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.w = 600;
        this.z = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.y = null;
                actionBarOverlayLayout.l = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.y = null;
                actionBarOverlayLayout.l = false;
            }
        };
        this.A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.a();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.y = actionBarOverlayLayout.f2548e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.z);
            }
        };
        this.B = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.a();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.y = actionBarOverlayLayout.f2548e.animate().translationY(-ActionBarOverlayLayout.this.f2548e.getHeight()).setListener(ActionBarOverlayLayout.this.z);
            }
        };
        a(context);
        this.C = new NestedScrollingParentHelper(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.DecorContentParent
    public void setIcon(Drawable drawable) {
        b();
        this.f2549f.setIcon(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            android.support.v7.widget.ActionBarOverlayLayout$LayoutParams r3 = (android.support.v7.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            r5 = 1
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarOverlayLayout.a(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    void a() {
        removeCallbacks(this.A);
        removeCallbacks(this.B);
        ViewPropertyAnimator viewPropertyAnimator = this.y;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private boolean a(float f2, float f3) {
        this.x.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        return this.x.getFinalY() > this.f2548e.getHeight();
    }
}
