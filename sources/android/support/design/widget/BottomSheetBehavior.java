package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a */
    private float f326a;

    /* renamed from: b */
    private int f327b;

    /* renamed from: c */
    private boolean f328c;

    /* renamed from: d */
    private int f329d;

    /* renamed from: e */
    int f330e;

    /* renamed from: f */
    int f331f;

    /* renamed from: g */
    boolean f332g;

    /* renamed from: h */
    private boolean f333h;
    int i;
    ViewDragHelper j;
    private boolean k;
    private int l;
    private boolean m;
    int n;
    WeakReference<V> o;
    WeakReference<View> p;
    private a q;
    private VelocityTracker r;
    int s;
    private int t;
    boolean u;
    private final ViewDragHelper.Callback v;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i);
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a */
        private final View f335a;

        /* renamed from: b */
        private final int f336b;

        public c(View view, int i) {
            this.f335a = view;
            this.f336b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.j;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f335a, this);
            } else {
                BottomSheetBehavior.this.c(this.f336b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.i = 4;
        this.v = new C0183i(this);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, (CoordinatorLayout) v, bVar.getSuperState());
        int i = bVar.f334b;
        if (i != 1 && i != 2) {
            this.i = i;
        } else {
            this.i = 4;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.i == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.j;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            c();
        }
        if (this.r == null) {
            this.r = VelocityTracker.obtain();
        }
        this.r.addMovement(motionEvent);
        if (actionMasked == 2 && !this.k && Math.abs(this.t - motionEvent.getY()) > this.j.getTouchSlop()) {
            this.j.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.k;
    }

    public void c(int i) {
        a aVar;
        if (this.i == i) {
            return;
        }
        this.i = i;
        V v = this.o.get();
        if (v == null || (aVar = this.q) == null) {
            return;
        }
        aVar.a((View) v, i);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new b(super.d(coordinatorLayout, v), this.i);
    }

    /* loaded from: classes.dex */
    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new C0184j();

        /* renamed from: b */
        final int f334b;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f334b = parcel.readInt();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f334b);
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.f334b = i;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.f330e) {
            c(3);
            return;
        }
        WeakReference<View> weakReference = this.p;
        if (weakReference != null && view == weakReference.get() && this.m) {
            if (this.l > 0) {
                i = this.f330e;
            } else if (this.f332g && a(v, b())) {
                i = this.n;
                i2 = 5;
            } else {
                if (this.l == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.f330e) < Math.abs(top - this.f331f)) {
                        i = this.f330e;
                    } else {
                        i = this.f331f;
                    }
                } else {
                    i = this.f331f;
                }
                i2 = 4;
            }
            if (this.j.smoothSlideViewTo(v, v.getLeft(), i)) {
                c(2);
                ViewCompat.postOnAnimation(v, new c(v, i2));
            } else {
                c(i2);
            }
            this.m = false;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.i = 4;
        this.v = new C0183i(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.d.i.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(b.b.d.i.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i = peekValue.data) == -1) {
            b(i);
        } else {
            b(obtainStyledAttributes.getDimensionPixelSize(b.b.d.i.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        a(obtainStyledAttributes.getBoolean(b.b.d.i.BottomSheetBehavior_Layout_behavior_hideable, false));
        b(obtainStyledAttributes.getBoolean(b.b.d.i.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f326a = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void c() {
        this.s = -1;
        VelocityTracker velocityTracker = this.r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.r = null;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.b(v, i);
        this.n = coordinatorLayout.getHeight();
        if (this.f328c) {
            if (this.f329d == 0) {
                this.f329d = coordinatorLayout.getResources().getDimensionPixelSize(b.b.d.b.design_bottom_sheet_peek_height_min);
            }
            i2 = Math.max(this.f329d, this.n - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i2 = this.f327b;
        }
        this.f330e = Math.max(0, this.n - v.getHeight());
        this.f331f = Math.max(this.n - i2, this.f330e);
        int i3 = this.i;
        if (i3 == 3) {
            ViewCompat.offsetTopAndBottom(v, this.f330e);
        } else if (this.f332g && i3 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.n);
        } else {
            int i4 = this.i;
            if (i4 == 4) {
                ViewCompat.offsetTopAndBottom(v, this.f331f);
            } else if (i4 == 1 || i4 == 2) {
                ViewCompat.offsetTopAndBottom(v, top - v.getTop());
            }
        }
        if (this.j == null) {
            this.j = ViewDragHelper.create(coordinatorLayout, this.v);
        }
        this.o = new WeakReference<>(v);
        this.p = new WeakReference<>(a(v));
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.l = 0;
        this.m = false;
        return (i & 2) != 0;
    }

    public final void b(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.f328c) {
                this.f328c = true;
            }
            z = false;
        } else {
            if (this.f328c || this.f327b != i) {
                this.f328c = false;
                this.f327b = Math.max(0, i);
                this.f331f = this.n - i;
            }
            z = false;
        }
        if (!z || this.i != 4 || (weakReference = this.o) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void b(boolean z) {
        this.f333h = z;
    }

    private float b() {
        this.r.computeCurrentVelocity(1000, this.f326a);
        return this.r.getYVelocity(this.s);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            this.k = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            c();
        }
        if (this.r == null) {
            this.r = VelocityTracker.obtain();
        }
        this.r.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.t = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.p;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.a(view, x, this.t)) {
                this.s = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.u = true;
            }
            this.k = this.s == -1 && !coordinatorLayout.a(v, x, this.t);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.u = false;
            this.s = -1;
            if (this.k) {
                this.k = false;
                return false;
            }
        }
        if (!this.k && this.j.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        View view2 = this.p.get();
        return (actionMasked != 2 || view2 == null || this.k || this.i == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.t) - motionEvent.getY()) <= ((float) this.j.getTouchSlop())) ? false : true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view != this.p.get()) {
            return;
        }
        int top = v.getTop();
        int i3 = top - i2;
        if (i2 > 0) {
            int i4 = this.f330e;
            if (i3 < i4) {
                iArr[1] = top - i4;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                c(3);
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                c(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.f331f;
            if (i3 > i5 && !this.f332g) {
                iArr[1] = top - i5;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                c(4);
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                c(1);
            }
        }
        a(v.getTop());
        this.l = i2;
        this.m = true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        return view == this.p.get() && (this.i != 3 || super.a(coordinatorLayout, (CoordinatorLayout) v, view, f2, f3));
    }

    public void a(boolean z) {
        this.f332g = z;
    }

    public boolean a(View view, float f2) {
        if (this.f333h) {
            return true;
        }
        return view.getTop() >= this.f331f && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f331f)) / ((float) this.f327b) > 0.5f;
    }

    View a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a2 = a(viewGroup.getChildAt(i));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public void a(int i) {
        a aVar;
        V v = this.o.get();
        if (v == null || (aVar = this.q) == null) {
            return;
        }
        if (i > this.f331f) {
            aVar.a(v, (r2 - i) / (this.n - r2));
        } else {
            aVar.a(v, (r2 - i) / (r2 - this.f330e));
        }
    }
}
