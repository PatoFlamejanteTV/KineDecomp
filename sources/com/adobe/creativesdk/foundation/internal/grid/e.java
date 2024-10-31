package com.adobe.creativesdk.foundation.internal.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ExtendableListView.java */
@SuppressLint({"WrongCall"})
/* loaded from: classes.dex */
public abstract class e extends AbsListView {
    protected boolean A;
    private f B;
    private ArrayList<b> C;
    private ArrayList<b> D;
    private AbsListView.OnScrollListener E;
    protected int F;
    protected int G;
    long H;
    long I;
    boolean J;
    private C0025e K;

    /* renamed from: a */
    private int f5018a;

    /* renamed from: b */
    private int f5019b;

    /* renamed from: c */
    private int f5020c;

    /* renamed from: d */
    private VelocityTracker f5021d;

    /* renamed from: e */
    private int f5022e;

    /* renamed from: f */
    private int f5023f;

    /* renamed from: g */
    private int f5024g;

    /* renamed from: h */
    private boolean f5025h;
    ListAdapter i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    protected int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    final boolean[] v;
    private g w;
    private a x;
    private int y;
    private c z;

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class a extends DataSetObserver {

        /* renamed from: a */
        private Parcelable f5026a = null;

        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            e.this.s = true;
            e eVar = e.this;
            eVar.u = eVar.t;
            e eVar2 = e.this;
            eVar2.t = eVar2.getAdapter().getCount();
            e.this.w.b();
            if (e.this.getAdapter().hasStableIds() && this.f5026a != null && e.this.u == 0 && e.this.t > 0) {
                e.this.onRestoreInstanceState(this.f5026a);
                this.f5026a = null;
            } else {
                e.this.f();
            }
            e.this.n();
            e.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            e.this.s = true;
            if (e.this.getAdapter().hasStableIds()) {
                this.f5026a = e.this.onSaveInstanceState();
            }
            e eVar = e.this;
            eVar.u = eVar.t;
            e.this.t = 0;
            e eVar2 = e.this;
            eVar2.J = false;
            eVar2.n();
            e.this.requestLayout();
        }
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public View f5028a;

        /* renamed from: b */
        public Object f5029b;

        /* renamed from: c */
        public boolean f5030c;
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a */
        private final Scroller f5031a;

        /* renamed from: b */
        private int f5032b;

        c() {
            this.f5031a = new Scroller(e.this.getContext());
        }

        public void b() {
            this.f5032b = 0;
            e.this.f5019b = 0;
            e.this.g(0);
            e.this.removeCallbacks(this);
            this.f5031a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (e.this.f5019b != 2) {
                return;
            }
            if (e.this.t != 0 && e.this.getChildCount() != 0) {
                Scroller scroller = this.f5031a;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i = this.f5032b - currY;
                if (i > 0) {
                    e eVar = e.this;
                    eVar.m = eVar.p;
                    max = Math.min(((e.this.getHeight() - e.this.getPaddingBottom()) - e.this.getPaddingTop()) - 1, i);
                } else {
                    int childCount = e.this.getChildCount() - 1;
                    e eVar2 = e.this;
                    eVar2.m = eVar2.p + childCount;
                    max = Math.max(-(((e.this.getHeight() - e.this.getPaddingBottom()) - e.this.getPaddingTop()) - 1), i);
                }
                boolean f2 = e.this.f(max, max);
                if (computeScrollOffset && !f2) {
                    e.this.invalidate();
                    this.f5032b = currY;
                    e.this.a(this);
                    return;
                }
                b();
                return;
            }
            b();
        }

        void a(int i) {
            int i2 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 0;
            this.f5032b = i2;
            this.f5031a.forceFinished(true);
            this.f5031a.fling(0, i2, 0, i, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            e.this.f5019b = 2;
            e.this.a(this);
        }
    }

    /* compiled from: ExtendableListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.grid.e$e */
    /* loaded from: classes.dex */
    public static class C0025e extends com.adobe.creativesdk.foundation.internal.grid.c {
        public static final Parcelable.Creator<C0025e> CREATOR = new com.adobe.creativesdk.foundation.internal.grid.f();

        /* renamed from: d */
        protected long f5038d;

        /* renamed from: e */
        protected long f5039e;

        /* renamed from: f */
        protected int f5040f;

        /* renamed from: g */
        protected int f5041g;

        /* renamed from: h */
        protected int f5042h;

        public C0025e(Parcelable parcelable) {
            super(parcelable, AbsListView.class.getClassLoader());
        }

        public String toString() {
            return "ExtendableListView.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f5038d + " firstId=" + this.f5039e + " viewTop=" + this.f5040f + " position=" + this.f5041g + " height=" + this.f5042h + "}";
        }

        @Override // com.adobe.creativesdk.foundation.internal.grid.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f5038d);
            parcel.writeLong(this.f5039e);
            parcel.writeInt(this.f5040f);
            parcel.writeInt(this.f5041g);
            parcel.writeInt(this.f5042h);
        }

        public C0025e(Parcel parcel) {
            super(parcel);
            this.f5038d = parcel.readLong();
            this.f5039e = parcel.readLong();
            this.f5040f = parcel.readInt();
            this.f5041g = parcel.readInt();
            this.f5042h = parcel.readInt();
        }
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class f extends h implements Runnable {

        /* renamed from: c */
        int f5043c;

        private f() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (e.this.s) {
                return;
            }
            e eVar = e.this;
            ListAdapter listAdapter = eVar.i;
            int i = this.f5043c;
            if (listAdapter == null || eVar.t <= 0 || i == -1 || i >= listAdapter.getCount() || !c() || (childAt = e.this.getChildAt(i)) == null) {
                return;
            }
            e eVar2 = e.this;
            eVar2.performItemClick(childAt, eVar2.p + i, listAdapter.getItemId(i));
        }

        /* synthetic */ f(e eVar, com.adobe.creativesdk.foundation.internal.grid.d dVar) {
            this();
        }
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class h {

        /* renamed from: a */
        private int f5053a;

        private h() {
        }

        public void b() {
            this.f5053a = e.this.getWindowAttachCount();
        }

        public boolean c() {
            return e.this.hasWindowFocus() && e.this.getWindowAttachCount() == this.f5053a;
        }

        /* synthetic */ h(e eVar, com.adobe.creativesdk.foundation.internal.grid.d dVar) {
            this();
        }
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5020c = 0;
        this.f5021d = null;
        this.o = -1;
        this.r = false;
        this.v = new boolean[1];
        this.H = Long.MIN_VALUE;
        this.J = false;
        setWillNotDraw(false);
        setClipToPadding(false);
        setFocusableInTouchMode(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5022e = viewConfiguration.getScaledTouchSlop();
        this.f5023f = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5024g = viewConfiguration.getScaledMinimumFlingVelocity();
        this.w = new g();
        this.x = new a();
        this.C = new ArrayList<>();
        this.D = new ArrayList<>();
        this.f5018a = 0;
    }

    private void i(int i) {
        if (this.p != 0 || i <= 0) {
            return;
        }
        int highestChildTop = getHighestChildTop();
        int listPaddingTop = getListPaddingTop();
        int top = (getTop() - getBottom()) - getListPaddingBottom();
        int i2 = highestChildTop - listPaddingTop;
        int lowestChildBottom = getLowestChildBottom();
        int i3 = (this.p + i) - 1;
        if (i2 > 0) {
            int i4 = this.t;
            if (i3 >= i4 - 1 && lowestChildBottom <= top) {
                if (i3 == i4 - 1) {
                    h();
                    return;
                }
                return;
            }
            if (i3 == this.t - 1) {
                i2 = Math.min(i2, lowestChildBottom - top);
            }
            f(-i2);
            if (i3 < this.t - 1) {
                int i5 = i3 + 1;
                c(i5, d(i5));
                h();
            }
        }
    }

    private View j(int i) {
        this.p = Math.min(this.p, this.t - 1);
        if (this.p < 0) {
            this.p = 0;
        }
        return c(this.p, i);
    }

    private int k(int i) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i <= getChildAt(i2).getBottom()) {
                return this.p + i2;
            }
        }
        return -1;
    }

    private void l(int i) {
        int childCount;
        ViewParent parent;
        int i2 = i - this.j;
        int i3 = i2 - this.l;
        int i4 = this.n;
        int i5 = i4 != Integer.MIN_VALUE ? i - i4 : i3;
        if (this.f5019b != 1 || i == this.n) {
            return;
        }
        if (Math.abs(i2) > this.f5022e && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        int i6 = this.m;
        if (i6 >= 0) {
            childCount = i6 - this.p;
        } else {
            childCount = getChildCount() / 2;
        }
        if (i5 != 0) {
            f(i3, i5);
        }
        if (getChildAt(childCount) != null) {
            this.j = i;
        }
        this.n = i;
    }

    private boolean m(int i) {
        int i2 = i - this.j;
        int abs = Math.abs(i2);
        int i3 = this.f5022e;
        if (abs <= i3) {
            return false;
        }
        this.f5019b = 1;
        if (i2 <= 0) {
            i3 = -i3;
        }
        this.l = i3;
        setPressed(false);
        View childAt = getChildAt(this.m - this.p);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        l(i);
        return true;
    }

    public void n() {
        boolean z = getAdapter() == null || getAdapter().isEmpty();
        if (isInFilterMode()) {
            z = false;
        }
        View emptyView = getEmptyView();
        if (z) {
            if (emptyView != null) {
                emptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.s) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public void a(int i, int i2) {
    }

    public void a(int i, boolean z) {
    }

    protected boolean b() {
        return false;
    }

    protected boolean c() {
        return false;
    }

    public void g() {
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.t;
    }

    public int getFirstChildTop() {
        if (a()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return Math.max(0, this.p - getHeaderViewsCount());
    }

    public int getFooterViewsCount() {
        return this.D.size();
    }

    public int getHeaderViewsCount() {
        return this.C.size();
    }

    public int getHighestChildTop() {
        if (a()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    public int getLastChildBottom() {
        if (a()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return Math.min((this.p + getChildCount()) - 1, this.i.getCount() - 1);
    }

    public int getLowestChildBottom() {
        if (a()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AbsListView
    protected void handleDataChanged() {
        super.handleDataChanged();
        int i = this.t;
        if (i > 0 && this.J) {
            this.J = false;
            this.K = null;
            this.f5018a = 2;
            this.F = Math.min(Math.max(0, this.F), i - 1);
            return;
        }
        this.f5018a = 1;
        this.J = false;
        this.K = null;
    }

    @Override // android.widget.AbsListView
    public void layoutChildren() {
        if (this.r) {
            return;
        }
        this.r = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.i == null) {
                i();
                return;
            }
            int listPaddingTop = getListPaddingTop();
            int childCount = getChildCount();
            View childAt = this.f5018a == 0 ? getChildAt(0) : null;
            boolean z = this.s;
            if (z) {
                handleDataChanged();
            }
            if (this.t == 0) {
                i();
                return;
            }
            if (this.t == this.i.getCount()) {
                int i = this.p;
                g gVar = this.w;
                if (z) {
                    for (int i2 = 0; i2 < childCount; i2++) {
                        gVar.a(getChildAt(i2), i + i2);
                    }
                } else {
                    gVar.a(childCount, i);
                }
                detachAllViewsFromParent();
                gVar.d();
                int i3 = this.f5018a;
                if (i3 == 1) {
                    this.p = 0;
                    g();
                    h();
                    j(listPaddingTop);
                    h();
                } else if (i3 == 2) {
                    d(this.F, this.G);
                } else if (childCount == 0) {
                    j(listPaddingTop);
                } else if (this.p < this.t) {
                    int i4 = this.p;
                    if (childAt != null) {
                        listPaddingTop = childAt.getTop();
                    }
                    d(i4, listPaddingTop);
                } else {
                    d(0, listPaddingTop);
                }
                gVar.e();
                this.s = false;
                this.J = false;
                this.f5018a = 0;
                return;
            }
            throw new IllegalStateException("The content of the adapter has changed but ExtendableListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ExtendableListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.i.getClass() + ")]");
        } finally {
            this.r = false;
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ListAdapter listAdapter = this.i;
        if (listAdapter != null) {
            this.s = true;
            this.u = this.t;
            this.t = listAdapter.getCount();
        }
        this.q = true;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.w.a();
        c cVar = this.z;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        this.q = false;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!this.q) {
            return false;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            a(motionEvent);
                        }
                    }
                } else if (this.f5019b == 3) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.o);
                    if (findPointerIndex == -1) {
                        this.o = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    k();
                    this.f5021d.addMovement(motionEvent);
                    if (m(y)) {
                        return true;
                    }
                }
            }
            this.f5019b = 0;
            this.o = -1;
            l();
            g(0);
        } else {
            int i2 = this.f5019b;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.o = motionEvent.getPointerId(0);
            int k = k(y2);
            if (i2 != 2 && k >= 0) {
                this.k = x;
                this.j = y2;
                this.m = k;
                this.f5019b = 3;
            }
            this.n = Integer.MIN_VALUE;
            j();
            this.f5021d.addMovement(motionEvent);
            if (i2 == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i == null) {
            return;
        }
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.w.c();
        }
        this.f5025h = true;
        layoutChildren();
        this.f5025h = false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.y = i;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        C0025e c0025e = (C0025e) parcelable;
        super.onRestoreInstanceState(c0025e.a());
        this.s = true;
        this.I = c0025e.f5042h;
        long j = c0025e.f5039e;
        if (j >= 0) {
            this.J = true;
            this.K = c0025e;
            this.H = j;
            this.F = c0025e.f5041g;
            this.G = c0025e.f5040f;
        }
        requestLayout();
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        C0025e c0025e = new C0025e(super.onSaveInstanceState());
        C0025e c0025e2 = this.K;
        if (c0025e2 != null) {
            c0025e.f5038d = c0025e2.f5038d;
            c0025e.f5039e = c0025e2.f5039e;
            c0025e.f5040f = c0025e2.f5040f;
            c0025e.f5041g = c0025e2.f5041g;
            c0025e.f5042h = c0025e2.f5042h;
            return c0025e;
        }
        boolean z = getChildCount() > 0 && this.t > 0;
        c0025e.f5038d = getSelectedItemId();
        c0025e.f5042h = getHeight();
        if (z && this.p > 0) {
            c0025e.f5040f = getChildAt(0).getTop();
            int i = this.p;
            int i2 = this.t;
            if (i >= i2) {
                i = i2 - 1;
            }
            c0025e.f5041g = i;
            c0025e.f5039e = this.i.getItemId(i);
        } else {
            c0025e.f5040f = 0;
            c0025e.f5039e = -1L;
            c0025e.f5041g = 0;
        }
        return c0025e;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        b(i, i2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean c2;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        k();
        this.f5021d.addMovement(motionEvent);
        if (!a()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            c2 = c(motionEvent);
        } else if (action == 6) {
            c2 = e(motionEvent);
        } else if (action == 2) {
            c2 = d(motionEvent);
        } else if (action != 3) {
            c2 = f(motionEvent);
        } else {
            c2 = b(motionEvent);
        }
        e();
        return c2;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            l();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.r || this.f5025h) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.A = z;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
        this.E = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        if (i >= 0) {
            this.f5018a = 2;
            this.G = getListPaddingTop();
            this.p = 0;
            if (this.J) {
                this.F = i;
                this.H = this.i.getItemId(i);
            }
            requestLayout();
        }
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public static class d extends AbsListView.LayoutParams {

        /* renamed from: a */
        boolean f5034a;

        /* renamed from: b */
        int f5035b;

        /* renamed from: c */
        long f5036c;

        /* renamed from: d */
        int f5037d;

        public d(int i, int i2) {
            super(i, i2);
            this.f5036c = -1L;
        }

        public d(int i, int i2, int i3) {
            super(i, i2);
            this.f5036c = -1L;
            this.f5037d = i3;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5036c = -1L;
        }
    }

    /* compiled from: ExtendableListView.java */
    /* loaded from: classes.dex */
    public class g {

        /* renamed from: a */
        private int f5045a;

        /* renamed from: b */
        private View[] f5046b = new View[0];

        /* renamed from: c */
        private ArrayList<View>[] f5047c;

        /* renamed from: d */
        private int f5048d;

        /* renamed from: e */
        private ArrayList<View> f5049e;

        /* renamed from: f */
        private ArrayList<View> f5050f;

        /* renamed from: g */
        private SparseArrayCompat<View> f5051g;

        g() {
        }

        private void f() {
            int length = this.f5046b.length;
            int i = this.f5048d;
            ArrayList<View>[] arrayListArr = this.f5047c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - length;
                int i5 = size - 1;
                int i6 = 0;
                while (i6 < i4) {
                    e.this.removeDetachedView(arrayList.remove(i5), false);
                    i6++;
                    i5--;
                }
            }
            if (this.f5051g != null) {
                while (i2 < this.f5051g.size()) {
                    if (!ViewCompat.hasTransientState(this.f5051g.valueAt(i2))) {
                        this.f5051g.removeAt(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }

        void a() {
            int i = this.f5048d;
            if (i == 1) {
                ArrayList<View> arrayList = this.f5049e;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.f5047c[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.f5051g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        void b() {
            SparseArrayCompat<View> sparseArrayCompat = this.f5051g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        public void c(int i) {
            if (i >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i];
                for (int i2 = 0; i2 < i; i2++) {
                    arrayListArr[i2] = new ArrayList<>();
                }
                this.f5048d = i;
                this.f5049e = arrayListArr[0];
                this.f5047c = arrayListArr;
                return;
            }
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }

        void d() {
            ArrayList<View> arrayList = this.f5050f;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                e.this.removeDetachedView(this.f5050f.get(i), false);
            }
            this.f5050f.clear();
        }

        public boolean d(int i) {
            return i >= 0;
        }

        void e() {
            View[] viewArr = this.f5046b;
            boolean z = this.f5048d > 1;
            ArrayList<View> arrayList = this.f5049e;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    d dVar = (d) view.getLayoutParams();
                    viewArr[length] = null;
                    boolean hasTransientState = ViewCompat.hasTransientState(view);
                    int i = dVar.f5037d;
                    if (!d(i) || hasTransientState) {
                        if (i != -2 || hasTransientState) {
                            e.this.removeDetachedView(view, false);
                        }
                        if (hasTransientState) {
                            if (this.f5051g == null) {
                                this.f5051g = new SparseArrayCompat<>();
                            }
                            this.f5051g.put(this.f5045a + length, view);
                        }
                    } else {
                        if (z) {
                            arrayList = this.f5047c[i];
                        }
                        dVar.f5035b = this.f5045a + length;
                        arrayList.add(view);
                    }
                }
            }
            f();
        }

        View b(int i) {
            if (this.f5048d == 1) {
                return e.a(this.f5049e, i);
            }
            int itemViewType = e.this.i.getItemViewType(i);
            if (itemViewType < 0) {
                return null;
            }
            ArrayList<View>[] arrayListArr = this.f5047c;
            if (itemViewType < arrayListArr.length) {
                return e.a(arrayListArr[itemViewType], i);
            }
            return null;
        }

        public void c() {
            int i = this.f5048d;
            if (i == 1) {
                ArrayList<View> arrayList = this.f5049e;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.f5047c[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.f5051g;
            if (sparseArrayCompat != null) {
                int size3 = sparseArrayCompat.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.f5051g.valueAt(i5).forceLayout();
                }
            }
        }

        void a(int i, int i2) {
            if (this.f5046b.length < i) {
                this.f5046b = new View[i];
            }
            this.f5045a = i2;
            View[] viewArr = this.f5046b;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = e.this.getChildAt(i3);
                d dVar = (d) childAt.getLayoutParams();
                if (dVar != null && dVar.f5037d != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        View a(int i) {
            int i2 = i - this.f5045a;
            View[] viewArr = this.f5046b;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        void a(View view, int i) {
            d dVar = (d) view.getLayoutParams();
            if (dVar == null) {
                return;
            }
            dVar.f5035b = i;
            int i2 = dVar.f5037d;
            boolean hasTransientState = ViewCompat.hasTransientState(view);
            if (d(i2) && !hasTransientState) {
                if (this.f5048d == 1) {
                    this.f5049e.add(view);
                    return;
                } else {
                    this.f5047c[i2].add(view);
                    return;
                }
            }
            if (i2 != -2 || hasTransientState) {
                if (this.f5050f == null) {
                    this.f5050f = new ArrayList<>();
                }
                this.f5050f.add(view);
            }
            if (hasTransientState) {
                if (this.f5051g == null) {
                    this.f5051g = new SparseArrayCompat<>();
                }
                this.f5051g.put(i, view);
            }
        }
    }

    private boolean f(MotionEvent motionEvent) {
        int i = this.f5019b;
        if (i == 1) {
            return g(motionEvent);
        }
        if (i != 3 && i != 4 && i != 5) {
            setPressed(false);
            invalidate();
            l();
            this.o = -1;
            return true;
        }
        return h(motionEvent);
    }

    private boolean g(MotionEvent motionEvent) {
        if (a()) {
            if (!(this.p == 0 && getFirstChildTop() >= getListPaddingTop() && this.p + getChildCount() < this.t && getLastChildBottom() <= getHeight() - getListPaddingBottom())) {
                this.f5021d.computeCurrentVelocity(1000, this.f5023f);
                float yVelocity = this.f5021d.getYVelocity(this.o);
                if (Math.abs(yVelocity) > this.f5024g) {
                    a(yVelocity);
                    this.f5019b = 2;
                    this.j = 0;
                    invalidate();
                    return true;
                }
            }
        }
        m();
        l();
        this.f5019b = 0;
        return true;
    }

    private boolean h(MotionEvent motionEvent) {
        if (this.B == null) {
            invalidate();
            this.B = new f();
        }
        int i = this.m;
        if (this.s || i < 0 || !this.i.isEnabled(i)) {
            return true;
        }
        f fVar = this.B;
        fVar.f5043c = i;
        fVar.b();
        fVar.run();
        return true;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public d generateDefaultLayoutParams() {
        return new d(-1, -2, 0);
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.i;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.i;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.x);
        }
        if (this.C.size() <= 0 && this.D.size() <= 0) {
            this.i = listAdapter;
        } else {
            this.i = new com.adobe.creativesdk.foundation.internal.grid.g(this.C, this.D, listAdapter);
        }
        this.s = true;
        this.t = listAdapter != null ? listAdapter.getCount() : 0;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.x);
            this.w.c(listAdapter.getViewTypeCount());
        }
        requestLayout();
    }

    private boolean e(MotionEvent motionEvent) {
        a(motionEvent);
        int i = this.k;
        int i2 = this.j;
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.m = pointToPosition;
        }
        this.n = i2;
        return true;
    }

    private boolean c(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int pointToPosition = pointToPosition(x, y);
        this.f5021d.clear();
        this.o = MotionEventCompat.getPointerId(motionEvent, 0);
        if (this.f5019b != 2 && !this.s && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
            this.f5019b = 3;
            if (motionEvent.getEdgeFlags() != 0 && pointToPosition < 0) {
                return false;
            }
        } else if (this.f5019b == 2) {
            this.f5019b = 1;
            this.l = 0;
            pointToPosition = k(y);
        }
        this.k = x;
        this.j = y;
        this.m = pointToPosition;
        this.n = Integer.MIN_VALUE;
        return true;
    }

    private boolean d(MotionEvent motionEvent) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.o);
        if (findPointerIndex < 0) {
            Log.e("ExtendableListView", "onTouchMove could not find pointer with id " + this.o + " - did ExtendableListView receive an inconsistent event stream?");
            return false;
        }
        int y = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
        if (this.s) {
            layoutChildren();
        }
        int i = this.f5019b;
        if (i == 1) {
            l(y);
        } else if (i == 3 || i == 4 || i == 5) {
            m(y);
        }
        return true;
    }

    public void b(int i, int i2) {
        if (getChildCount() > 0) {
            m();
            this.w.a();
            this.s = true;
            f();
        }
    }

    private void j() {
        VelocityTracker velocityTracker = this.f5021d;
        if (velocityTracker == null) {
            this.f5021d = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void k() {
        if (this.f5021d == null) {
            this.f5021d = VelocityTracker.obtain();
        }
    }

    private void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.o) {
            int i = action == 0 ? 1 : 0;
            this.k = (int) motionEvent.getX(i);
            this.j = (int) motionEvent.getY(i);
            this.o = motionEvent.getPointerId(i);
            l();
        }
    }

    private boolean b(MotionEvent motionEvent) {
        this.f5019b = 0;
        setPressed(false);
        invalidate();
        l();
        this.o = -1;
        return true;
    }

    private View e(int i, int i2) {
        int listPaddingTop = this.A ? getListPaddingTop() : 0;
        while (true) {
            if ((i2 > listPaddingTop || c()) && i >= 0) {
                a(i, i2, false, false);
                i--;
                i2 = e(i);
            }
        }
        this.p = i + 1;
        return null;
    }

    public boolean f(int i, int i2) {
        int i3;
        int i4;
        int min;
        int i5;
        int i6;
        if (!a()) {
            return true;
        }
        int highestChildTop = getHighestChildTop();
        int lowestChildBottom = getLowestChildBottom();
        if (this.A) {
            i3 = getListPaddingTop();
            i4 = getListPaddingBottom();
        } else {
            i3 = 0;
            i4 = 0;
        }
        int height = getHeight();
        int firstChildTop = i3 - getFirstChildTop();
        int lastChildBottom = getLastChildBottom() - (height - i4);
        int listPaddingBottom = (height - getListPaddingBottom()) - getListPaddingTop();
        if (i2 < 0) {
            min = Math.max(-(listPaddingBottom - 1), i2);
        } else {
            min = Math.min(listPaddingBottom - 1, i2);
        }
        int i7 = this.p;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom2 = height - getListPaddingBottom();
        int childCount = getChildCount();
        boolean z = i7 == 0 && highestChildTop >= listPaddingTop && min >= 0;
        boolean z2 = i7 + childCount == this.t && lowestChildBottom <= listPaddingBottom2 && min <= 0;
        if (z) {
            return min != 0;
        }
        if (z2) {
            return min != 0;
        }
        boolean z3 = min < 0;
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.t - getFooterViewsCount();
        if (z3) {
            int i8 = -min;
            if (this.A) {
                i8 += getListPaddingTop();
            }
            i6 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getBottom() >= i8) {
                    break;
                }
                i6++;
                int i10 = i7 + i9;
                if (i10 >= headerViewsCount && i10 < footerViewsCount) {
                    this.w.a(childAt, i10);
                }
            }
            i5 = 0;
        } else {
            int i11 = height - min;
            if (this.A) {
                i11 -= getListPaddingBottom();
            }
            i5 = 0;
            i6 = 0;
            for (int i12 = childCount - 1; i12 >= 0; i12--) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getTop() <= i11) {
                    break;
                }
                i6++;
                int i13 = i7 + i12;
                if (i13 >= headerViewsCount && i13 < footerViewsCount) {
                    this.w.a(childAt2, i13);
                }
                i5 = i12;
            }
        }
        this.r = true;
        if (i6 > 0) {
            detachViewsFromParent(i5, i6);
            this.w.d();
            a(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        f(min);
        if (z3) {
            this.p += i6;
        }
        int abs = Math.abs(min);
        if (firstChildTop < abs || lastChildBottom < abs) {
            b(z3);
        }
        this.r = false;
        d();
        return false;
    }

    private void h(int i) {
        if ((this.p + i) - 1 != this.t - 1 || i <= 0) {
            return;
        }
        int bottom = ((getBottom() - getTop()) - getListPaddingBottom()) - getLowestChildBottom();
        int highestChildTop = getHighestChildTop();
        if (bottom > 0) {
            if (this.p > 0 || highestChildTop < getListPaddingTop()) {
                if (this.p == 0) {
                    bottom = Math.min(bottom, getListPaddingTop() - highestChildTop);
                }
                f(bottom);
                int i2 = this.p;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    e(i3, e(i3));
                    h();
                }
            }
        }
    }

    private View d(int i, int i2) {
        a(i, i2, true, false);
        this.p = i;
        int i3 = i - 1;
        int e2 = e(i3);
        int i4 = i + 1;
        int d2 = d(i4);
        View e3 = e(i3, e2);
        h();
        View c2 = c(i4, d2);
        int childCount = getChildCount();
        if (childCount > 0) {
            h(childCount);
        }
        return e3 != null ? e3 : c2;
    }

    private void m() {
        c cVar = this.z;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(boolean z) {
        if (z) {
            h(getChildCount());
        } else {
            i(getChildCount());
        }
    }

    protected void b(boolean z) {
        int childCount = getChildCount();
        if (z) {
            int i = this.p + childCount;
            c(i, c(i));
        } else {
            int i2 = this.p - 1;
            e(i2, a(i2));
        }
        a(z);
    }

    public int e(int i) {
        int childCount = getChildCount();
        if (childCount != 0 && childCount > 0) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    private void i() {
        a(this.C);
        a(this.D);
        removeAllViewsInLayout();
        this.p = 0;
        this.s = false;
        this.w.a();
        this.J = false;
        this.K = null;
        this.f5018a = 0;
        invalidate();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        View a2;
        a(i, z);
        if (!this.s && (a2 = this.w.a(i)) != null) {
            a(a2, i, i2, z, z2, true);
            return a2;
        }
        View a3 = a(i, this.v);
        a(a3, i, i2, z, z2, this.v[0]);
        return a3;
    }

    private void l() {
        VelocityTracker velocityTracker = this.f5021d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5021d = null;
        }
    }

    public void e() {
        int i = this.f5019b;
        if (i == 0) {
            g(0);
        } else if (i == 1) {
            g(1);
        } else {
            if (i != 2) {
                return;
            }
            g(2);
        }
    }

    void g(int i) {
        if (i != this.f5020c) {
            this.f5020c = i;
            AbsListView.OnScrollListener onScrollListener = this.E;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i);
            }
        }
    }

    private View c(int i, int i2) {
        int height = getHeight();
        if (this.A) {
            height -= getListPaddingBottom();
        }
        while (true) {
            if ((i2 >= height && !b()) || i >= this.t) {
                return null;
            }
            a(i, i2, true, false);
            i++;
            i2 = d(i);
        }
    }

    public int d(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            return getChildAt(childCount - 1).getBottom();
        }
        return 0;
    }

    private void a(View view, int i, int i2, boolean z, boolean z2, boolean z3) {
        d a2;
        boolean isSelected = view.isSelected();
        int i3 = this.f5019b;
        boolean z4 = i3 > 3 && i3 < 1 && this.m == i;
        boolean z5 = z4 != view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        int itemViewType = this.i.getItemViewType(i);
        if (itemViewType == -2) {
            a2 = b(view);
        } else {
            a2 = a(view);
        }
        a2.f5037d = itemViewType;
        a2.f5035b = i;
        if (!z3 && (!a2.f5034a || a2.f5037d != -2)) {
            if (a2.f5037d == -2) {
                a2.f5034a = true;
            }
            addViewInLayout(view, z ? -1 : 0, a2, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, a2);
        }
        if (isSelected) {
            view.setSelected(false);
        }
        if (z5) {
            view.setPressed(z4);
        }
        if (z6) {
            a(view, a2);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = z ? i2 : i2 - measuredHeight;
        int b2 = b(i);
        if (z6) {
            a(view, i, z, b2, i4, b2 + measuredWidth, i4 + measuredHeight);
        } else {
            a(view, i, z, b2, i4);
        }
    }

    protected d b(View view) {
        d dVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            dVar = null;
        } else if (layoutParams instanceof d) {
            dVar = (d) layoutParams;
        } else {
            dVar = new d(layoutParams);
        }
        return dVar == null ? generateDefaultLayoutParams() : dVar;
    }

    private void h() {
        if (getChildCount() > 0) {
            int highestChildTop = getHighestChildTop() - getListPaddingTop();
            if (highestChildTop < 0) {
                highestChildTop = 0;
            }
            if (highestChildTop != 0) {
                f(-highestChildTop);
            }
        }
    }

    void d() {
        AbsListView.OnScrollListener onScrollListener = this.E;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.p, getChildCount(), this.t);
        }
    }

    public int b(int i) {
        return getListPaddingLeft();
    }

    public int c(int i) {
        int childCount = getChildCount();
        return childCount > 0 ? getChildAt(childCount - 1).getBottom() : this.A ? getListPaddingTop() : 0;
    }

    protected d a(View view) {
        return b(view);
    }

    public void a(View view, d dVar) {
        int makeMeasureSpec;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.y, getListPaddingLeft() + getListPaddingRight(), ((AbsListView.LayoutParams) dVar).width);
        int i = ((AbsListView.LayoutParams) dVar).height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public void f(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    void f() {
        if (getChildCount() > 0) {
            this.J = true;
            this.I = getHeight();
            View childAt = getChildAt(0);
            ListAdapter adapter = getAdapter();
            int i = this.p;
            if (i >= 0 && i < adapter.getCount()) {
                this.H = adapter.getItemId(this.p);
            } else {
                this.H = -1L;
            }
            if (childAt != null) {
                this.G = childAt.getTop();
            }
            this.F = this.p;
        }
    }

    private View a(int i, boolean[] zArr) {
        zArr[0] = false;
        View b2 = this.w.b(i);
        if (b2 != null) {
            View view = this.i.getView(i, b2, this);
            if (view != b2) {
                this.w.a(b2, i);
                return view;
            }
            zArr[0] = true;
            return view;
        }
        return this.i.getView(i, null, this);
    }

    public void a(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4, i5);
    }

    public void a(View view, int i, boolean z, int i2, int i3) {
        view.offsetLeftAndRight(i2 - view.getLeft());
        view.offsetTopAndBottom(i3 - view.getTop());
    }

    public int a(int i) {
        return getChildCount() > 0 ? getChildAt(0).getTop() : getHeight() - (this.A ? getListPaddingBottom() : 0);
    }

    protected boolean a() {
        return getChildCount() > 0;
    }

    private void a(float f2) {
        if (this.z == null) {
            this.z = new c();
        }
        this.z.a((int) (-f2));
    }

    public void a(Runnable runnable) {
        ViewCompat.postOnAnimation(this, runnable);
    }

    static View a(ArrayList<View> arrayList, int i) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            if (((d) view.getLayoutParams()).f5035b == i) {
                arrayList.remove(i2);
                return view;
            }
        }
        return arrayList.remove(size - 1);
    }

    private void a(ArrayList<b> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next().f5028a.getLayoutParams();
            if (dVar != null) {
                dVar.f5034a = false;
            }
        }
    }
}
