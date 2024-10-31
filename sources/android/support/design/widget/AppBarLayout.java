package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    private int f307a;

    /* renamed from: b */
    private int f308b;

    /* renamed from: c */
    private int f309c;

    /* renamed from: d */
    private boolean f310d;

    /* renamed from: e */
    private int f311e;

    /* renamed from: f */
    private WindowInsetsCompat f312f;

    /* renamed from: g */
    private List<b> f313g;

    /* renamed from: h */
    private boolean f314h;
    private boolean i;
    private int[] j;

    /* loaded from: classes.dex */
    public static class Behavior extends w<AppBarLayout> {
        private int k;
        private ValueAnimator l;
        private int m;
        private boolean n;
        private float o;
        private WeakReference<View> p;
        private a q;

        /* loaded from: classes.dex */
        public static abstract class a {
            public abstract boolean a(AppBarLayout appBarLayout);
        }

        public Behavior() {
            this.m = -1;
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private void d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int c2 = c();
            int b2 = b(appBarLayout, c2);
            if (b2 >= 0) {
                View childAt = appBarLayout.getChildAt(b2);
                int a2 = ((a) childAt.getLayoutParams()).a();
                if ((a2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (b2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (a(a2, 2)) {
                        i2 += ViewCompat.getMinimumHeight(childAt);
                    } else if (a(a2, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i2;
                        if (c2 < minimumHeight) {
                            i = minimumHeight;
                        } else {
                            i2 = minimumHeight;
                        }
                    }
                    if (c2 < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, appBarLayout, MathUtils.clamp(i, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        @Override // android.support.design.widget.P
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // android.support.design.widget.w
        public int c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.m = -1;
        }

        private int c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i3);
                a aVar = (a) childAt.getLayoutParams();
                Interpolator b2 = aVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b2 != null) {
                    int a2 = aVar.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i2 -= appBarLayout.getTopInset();
                    }
                    if (i2 > 0) {
                        float f2 = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i;
        }

        /* loaded from: classes.dex */
        public static class b extends AbsSavedState {
            public static final Parcelable.Creator<b> CREATOR = new C0178d();

            /* renamed from: b */
            int f315b;

            /* renamed from: c */
            float f316c;

            /* renamed from: d */
            boolean f317d;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f315b = parcel.readInt();
                this.f316c = parcel.readFloat();
                this.f317d = parcel.readByte() != 0;
            }

            @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f315b);
                parcel.writeFloat(this.f316c);
                parcel.writeByte(this.f317d ? (byte) 1 : (byte) 0);
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }
        }

        private int b(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -i;
                if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.support.design.widget.w
        public int b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        @Override // android.support.design.widget.P
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable d2 = super.d(coordinatorLayout, (CoordinatorLayout) appBarLayout);
            int b2 = b();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 <= 0 && bottom >= 0) {
                    b bVar = new b(d2);
                    bVar.f315b = i;
                    bVar.f317d = bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                    bVar.f316c = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return d2;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && appBarLayout.b() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && (valueAnimator = this.l) != null) {
                valueAnimator.cancel();
            }
            this.p = null;
            return z;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -appBarLayout.getTotalScrollRange();
                    i4 = i6;
                    i5 = appBarLayout.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i2, i4, i5);
                }
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List<View> c2 = coordinatorLayout.c(appBarLayout);
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.b d2 = ((CoordinatorLayout.e) c2.get(i).getLayoutParams()).d();
                if (d2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) d2).c() != 0;
                }
            }
            return false;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, appBarLayout);
            }
            this.p = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f2) {
            int height;
            int abs = Math.abs(c() - i);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, appBarLayout, i, height);
        }

        @Override // android.support.design.widget.w
        int c() {
            return b() + this.k;
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int c2 = c();
            if (c2 == i) {
                ValueAnimator valueAnimator = this.l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 == null) {
                this.l = new ValueAnimator();
                this.l.setInterpolator(C0175a.f466e);
                this.l.addUpdateListener(new C0177c(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.l.setDuration(Math.min(i2, 600));
            this.l.setIntValues(c2, i);
            this.l.start();
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) appBarLayout.getLayoutParams())).height == -2) {
                coordinatorLayout.a(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.P, android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int round;
            boolean a2 = super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2 = this.m;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.n) {
                    round = ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.o);
                }
                c(coordinatorLayout, (CoordinatorLayout) appBarLayout, i3 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, appBarLayout, i4, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) appBarLayout, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, (CoordinatorLayout) appBarLayout, 0);
                    }
                }
            }
            appBarLayout.c();
            this.m = -1;
            a(MathUtils.clamp(b(), -appBarLayout.getTotalScrollRange(), 0));
            a(coordinatorLayout, appBarLayout, b(), 0, true);
            appBarLayout.a(b());
            return a2;
        }

        @Override // android.support.design.widget.w
        public boolean a(AppBarLayout appBarLayout) {
            a aVar = this.q;
            if (aVar != null) {
                return aVar.a(appBarLayout);
            }
            WeakReference<View> weakReference = this.p;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // android.support.design.widget.w
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            d(coordinatorLayout, appBarLayout);
        }

        @Override // android.support.design.widget.w
        /* renamed from: a */
        public int b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int c2 = c();
            int i4 = 0;
            if (i2 != 0 && c2 >= i2 && c2 <= i3) {
                int clamp = MathUtils.clamp(i, i2, i3);
                if (c2 != clamp) {
                    int c3 = appBarLayout.a() ? c(appBarLayout, clamp) : clamp;
                    boolean a2 = a(c3);
                    i4 = c2 - clamp;
                    this.k = clamp - c3;
                    if (!a2 && appBarLayout.a()) {
                        coordinatorLayout.a(appBarLayout);
                    }
                    appBarLayout.a(b());
                    a(coordinatorLayout, appBarLayout, clamp, clamp < c2 ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            return i4;
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View a2 = a(appBarLayout, i);
            if (a2 != null) {
                int a3 = ((a) a2.getLayoutParams()).a();
                boolean z2 = false;
                if ((a3 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(a2);
                    if (i2 <= 0 || (a3 & 12) == 0 ? !((a3 & 2) == 0 || (-i) < (a2.getBottom() - minimumHeight) - appBarLayout.getTopInset()) : (-i) >= (a2.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        z2 = true;
                    }
                }
                boolean a4 = appBarLayout.a(z2);
                if (Build.VERSION.SDK_INT >= 11) {
                    if (z || (a4 && c(coordinatorLayout, appBarLayout))) {
                        appBarLayout.jumpDrawablesToCurrentState();
                    }
                }
            }
        }

        private static View a(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, bVar.getSuperState());
                this.m = bVar.f315b;
                this.o = bVar.f316c;
                this.n = bVar.f317d;
                return;
            }
            super.a(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
            this.m = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends x {
        public ScrollingViewBehavior() {
        }

        private void e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.b d2 = ((CoordinatorLayout.e) view2.getLayoutParams()).d();
            if (d2 instanceof Behavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((Behavior) d2).k) + d()) - a(view2));
            }
        }

        @Override // android.support.design.widget.x
        /* bridge */ /* synthetic */ View a(List list) {
            return a((List<View>) list);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            e(coordinatorLayout, view, view2);
            return false;
        }

        @Override // android.support.design.widget.x
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.P, android.support.design.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, (CoordinatorLayout) view, i);
        }

        @Override // android.support.design.widget.x
        float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (a2 / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // android.support.design.widget.x, android.support.design.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f519d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b d2 = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).d();
            if (d2 instanceof Behavior) {
                return ((Behavior) d2).c();
            }
            return 0;
        }

        @Override // android.support.design.widget.x
        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void d() {
        this.f307a = -1;
        this.f308b = -1;
        this.f309c = -1;
    }

    private void e() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (((a) getChildAt(i).getLayoutParams()).c()) {
                z = true;
                break;
            }
            i++;
        }
        b(z);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    boolean b() {
        return getTotalScrollRange() != 0;
    }

    void c() {
        this.f311e = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int getDownNestedPreScrollRange() {
        int topInset;
        int i = this.f308b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = aVar.f318a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = i2 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                if ((i3 & 8) != 0) {
                    i2 = i4 + ViewCompat.getMinimumHeight(childAt);
                } else {
                    if ((i3 & 2) != 0) {
                        topInset = ViewCompat.getMinimumHeight(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i2 = i4 + (measuredHeight - topInset);
                }
            }
        }
        int max = Math.max(0, i2);
        this.f308b = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i = this.f309c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
            int i4 = aVar.f318a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f309c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getPendingAction() {
        return this.f311e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f312f;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f307a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = aVar.f318a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.f307a = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.j == null) {
            this.j = new int[2];
        }
        int[] iArr = this.j;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f314h ? b.b.d.a.state_collapsible : -b.b.d.a.state_collapsible;
        iArr[1] = (this.f314h && this.i) ? b.b.d.a.state_collapsed : -b.b.d.a.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d();
        int i5 = 0;
        this.f310d = false;
        int childCount = getChildCount();
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (((a) getChildAt(i5).getLayoutParams()).b() != null) {
                this.f310d = true;
                break;
            }
            i5++;
        }
        e();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }

    public void setExpanded(boolean z) {
        a(z, ViewCompat.isLaidOut(this));
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            T.a(this, f2);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f307a = -1;
        this.f308b = -1;
        this.f309c = -1;
        this.f311e = 0;
        setOrientation(1);
        O.a(context);
        if (Build.VERSION.SDK_INT >= 21) {
            T.a(this);
            T.a(this, attributeSet, 0, b.b.d.h.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.AppBarLayout, 0, b.b.d.h.Widget_Design_AppBarLayout);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(b.b.d.i.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(b.b.d.i.AppBarLayout_expanded)) {
            a(obtainStyledAttributes.getBoolean(b.b.d.i.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(b.b.d.i.AppBarLayout_elevation)) {
            T.a(this, obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(b.b.d.i.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(b.b.d.i.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(b.b.d.i.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(b.b.d.i.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new C0176b(this));
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.f311e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.f314h == z) {
            return false;
        }
        this.f314h = z;
        refreshDrawableState();
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    boolean a() {
        return this.f310d;
    }

    void a(int i) {
        List<b> list = this.f313g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f313g.get(i2);
                if (bVar != null) {
                    bVar.a(this, i);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new a((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {

        /* renamed from: a */
        int f318a;

        /* renamed from: b */
        Interpolator f319b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f318a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.AppBarLayout_Layout);
            this.f318a = obtainStyledAttributes.getInt(b.b.d.i.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(b.b.d.i.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f319b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(b.b.d.i.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f318a;
        }

        public Interpolator b() {
            return this.f319b;
        }

        boolean c() {
            int i = this.f318a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f318a = 1;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f318a = 1;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f318a = 1;
        }

        public a(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f318a = 1;
        }
    }

    boolean a(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    public WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f312f, windowInsetsCompat2)) {
            this.f312f = windowInsetsCompat2;
            d();
        }
        return windowInsetsCompat;
    }
}
