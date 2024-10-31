package android.support.v7.internal.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.a;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f146a = {a.C0016a.actionBarSize, R.attr.windowContentOverlay};
    private final android.support.v4.g.ad A;
    private final android.support.v4.g.ad B;
    private final Runnable C;
    private final Runnable D;
    private final android.support.v4.g.o E;
    private int b;
    private int c;
    private ContentFrameLayout d;
    private ActionBarContainer e;
    private ActionBarContainer f;
    private m g;
    private Drawable h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private a v;
    private final int w;
    private android.support.v4.widget.h x;
    private android.support.v4.g.y y;
    private android.support.v4.g.y z;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.w = 600;
        this.A = new e(this);
        this.B = new f(this);
        this.C = new g(this);
        this.D = new h(this);
        a(context);
        this.E = new android.support.v4.g.o(this);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f146a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.h == null);
        obtainStyledAttributes.recycle();
        this.i = context.getApplicationInfo().targetSdkVersion < 19;
        this.x = android.support.v4.widget.h.a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.v = aVar;
        if (getWindowToken() != null) {
            this.v.a(this.c);
            if (this.o != 0) {
                onWindowSystemUiVisibilityChanged(this.o);
                android.support.v4.g.p.h(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.j = z;
        this.i = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.k = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        android.support.v4.g.p.h(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        b();
        int i2 = this.o ^ i;
        this.o = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.v != null) {
            this.v.a(z2 ? false : true);
            if (z || !z2) {
                this.v.a();
            } else {
                this.v.b();
            }
        }
        if ((i2 & 256) != 0 && this.v != null) {
            android.support.v4.g.p.h(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        if (this.v != null) {
            this.v.a(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        b bVar = (b) view.getLayoutParams();
        if (z && bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        b();
        if ((android.support.v4.g.p.g(this) & 256) != 0) {
        }
        boolean a2 = a(this.f, rect, true, true, false, true);
        if (this.e != null) {
            a2 |= a(this.e, rect, true, false, true, true);
        }
        this.s.set(rect);
        af.a(this, this.s, this.p);
        if (!this.q.equals(this.p)) {
            this.q.set(this.p);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int measuredHeight;
        int i6;
        b();
        measureChildWithMargins(this.f, i, 0, i2, 0);
        b bVar = (b) this.f.getLayoutParams();
        int max = Math.max(0, this.f.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, bVar.bottomMargin + this.f.getMeasuredHeight() + bVar.topMargin);
        int a2 = af.a(0, android.support.v4.g.p.c(this.f));
        if (this.e != null) {
            measureChildWithMargins(this.e, i, 0, i2, 0);
            b bVar2 = (b) this.e.getLayoutParams();
            int max3 = Math.max(max, this.e.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
            int max4 = Math.max(max2, bVar2.bottomMargin + this.e.getMeasuredHeight() + bVar2.topMargin);
            i5 = af.a(a2, android.support.v4.g.p.c(this.e));
            i4 = max3;
            i3 = max4;
        } else {
            i3 = max2;
            i4 = max;
            i5 = a2;
        }
        boolean z = (android.support.v4.g.p.g(this) & 256) != 0;
        if (z) {
            measuredHeight = this.b;
            if (this.k && this.f.getTabContainer() != null) {
                measuredHeight += this.b;
            }
        } else {
            measuredHeight = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        if (!this.g.a() || this.e == null) {
            i6 = 0;
        } else if (z) {
            i6 = this.b;
        } else {
            i6 = this.e.getMeasuredHeight();
        }
        this.r.set(this.p);
        this.t.set(this.s);
        if (!this.j && !z) {
            Rect rect = this.r;
            rect.top = measuredHeight + rect.top;
            Rect rect2 = this.r;
            rect2.bottom = i6 + rect2.bottom;
        } else {
            Rect rect3 = this.t;
            rect3.top = measuredHeight + rect3.top;
            Rect rect4 = this.t;
            rect4.bottom = i6 + rect4.bottom;
        }
        a(this.d, this.r, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.d.a(this.t);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        b bVar3 = (b) this.d.getLayoutParams();
        int max5 = Math.max(i4, this.d.getMeasuredWidth() + bVar3.leftMargin + bVar3.rightMargin);
        int max6 = Math.max(i3, bVar3.bottomMargin + this.d.getMeasuredHeight() + bVar3.topMargin);
        int a3 = af.a(i5, android.support.v4.g.p.c(this.d));
        setMeasuredDimension(android.support.v4.g.p.a(Math.max(max5 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, a3), android.support.v4.g.p.a(Math.max(max6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, a3 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = bVar.leftMargin + paddingLeft;
                if (childAt == this.e) {
                    i5 = (paddingBottom - measuredHeight) - bVar.bottomMargin;
                } else {
                    i5 = bVar.topMargin + paddingTop;
                }
                childAt.layout(i7, i5, measuredWidth + i7, measuredHeight + i5);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h != null && !this.i) {
            int bottom = this.f.getVisibility() == 0 ? (int) (this.f.getBottom() + android.support.v4.g.p.d(this.f) + 0.5f) : 0;
            this.h.setBounds(0, bottom, getWidth(), this.h.getIntrinsicHeight() + bottom);
            this.h.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.E.a(view, view2, i);
        this.n = getActionBarHideOffset();
        c();
        if (this.v != null) {
            this.v.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.n += i2;
        setActionBarHideOffset(this.n);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.l && !this.m) {
            if (this.n <= this.f.getHeight()) {
                d();
            } else {
                e();
            }
        }
        if (this.v != null) {
            this.v.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.l || !z) {
            return false;
        }
        if (a(f, f2)) {
            g();
        } else {
            f();
        }
        this.m = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    void b() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(a.e.action_bar_activity_content);
            this.f = (ActionBarContainer) findViewById(a.e.action_bar_container);
            this.g = a(findViewById(a.e.action_bar));
            this.e = (ActionBarContainer) findViewById(a.e.split_action_bar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m a(View view) {
        if (view instanceof m) {
            return (m) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (!z) {
                c();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        if (this.f != null) {
            return -((int) android.support.v4.g.p.d(this.f));
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        c();
        int max = Math.max(0, Math.min(i, this.f.getHeight()));
        android.support.v4.g.p.b(this.f, -max);
        if (this.e != null && this.e.getVisibility() != 8) {
            android.support.v4.g.p.b(this.e, (int) ((max / r0) * this.e.getHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        if (this.y != null) {
            this.y.a();
        }
        if (this.z != null) {
            this.z.a();
        }
    }

    private void d() {
        c();
        postDelayed(this.C, 600L);
    }

    private void e() {
        c();
        postDelayed(this.D, 600L);
    }

    private void f() {
        c();
        this.C.run();
    }

    private void g() {
        c();
        this.D.run();
    }

    private boolean a(float f, float f2) {
        this.x.a(0, 0, 0, (int) f2, 0, 0, NexEditorDeviceProfile.UNKNOWN, Integer.MAX_VALUE);
        return this.x.a() > this.f.getHeight();
    }

    public void setWindowCallback(Window.Callback callback) {
        b();
        this.g.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        b();
        this.g.a(charSequence);
    }

    public CharSequence getTitle() {
        b();
        return this.g.b();
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        b();
        this.g.a(i);
    }

    public void setIcon(Drawable drawable) {
        b();
        this.g.a(drawable);
    }

    public void setLogo(int i) {
        b();
        this.g.b(i);
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
