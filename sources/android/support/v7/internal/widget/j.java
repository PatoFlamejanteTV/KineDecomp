package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* compiled from: AdapterViewCompat.java */
/* loaded from: classes.dex */
public abstract class j<T extends Adapter> extends ViewGroup {
    int A;
    int B;
    long C;
    boolean D;

    /* renamed from: a, reason: collision with root package name */
    private int f176a;
    private View b;
    private boolean c;
    private boolean d;
    private j<T>.e e;

    @ViewDebug.ExportedProperty(category = "scrolling")
    int j;
    int k;
    int l;
    long m;
    long n;
    boolean o;
    int p;
    boolean q;
    d r;
    b s;
    c t;
    boolean u;

    @ViewDebug.ExportedProperty(category = "list")
    int v;
    long w;

    @ViewDebug.ExportedProperty(category = "list")
    int x;
    long y;

    @ViewDebug.ExportedProperty(category = "list")
    int z;

    /* compiled from: AdapterViewCompat.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(j<?> jVar, View view, int i, long j);
    }

    /* compiled from: AdapterViewCompat.java */
    /* loaded from: classes.dex */
    public interface c {
    }

    /* compiled from: AdapterViewCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(j<?> jVar);

        void a(j<?> jVar, View view, int i, long j);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 0;
        this.m = Long.MIN_VALUE;
        this.o = false;
        this.q = false;
        this.v = -1;
        this.w = Long.MIN_VALUE;
        this.x = -1;
        this.y = Long.MIN_VALUE;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        this.D = false;
    }

    public void setOnItemClickListener(b bVar) {
        this.s = bVar;
    }

    public final b getOnItemClickListener() {
        return this.s;
    }

    public boolean a(View view, int i, long j) {
        if (this.s == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.s.a(this, view, i, j);
        return true;
    }

    public void setOnItemLongClickListener(c cVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.t = cVar;
    }

    public final c getOnItemLongClickListener() {
        return this.t;
    }

    public void setOnItemSelectedListener(d dVar) {
        this.r = dVar;
    }

    public final d getOnItemSelectedListener() {
        return this.r;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f176a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.v;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.w;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.z;
    }

    public int getFirstVisiblePosition() {
        return this.j;
    }

    public int getLastVisiblePosition() {
        return (this.j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.b = view;
        T adapter = getAdapter();
        a(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.b;
    }

    boolean d() {
        return false;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.c = z;
        if (!z) {
            this.d = false;
        }
        if (!z || (z3 && !d())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.d = z;
        if (z) {
            this.c = true;
        }
        if (!z || (z3 && !d())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        T adapter = getAdapter();
        boolean z = !(adapter == null || adapter.getCount() == 0) || d();
        super.setFocusableInTouchMode(z && this.d);
        super.setFocusable(z && this.c);
        if (this.b != null) {
            a(adapter == null || adapter.isEmpty());
        }
    }

    private void a(boolean z) {
        if (d()) {
            z = false;
        }
        if (z) {
            if (this.b != null) {
                this.b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        setVisibility(0);
    }

    public long a(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* compiled from: AdapterViewCompat.java */
    /* loaded from: classes.dex */
    class a extends DataSetObserver {
        private Parcelable b = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            j.this.u = true;
            j.this.A = j.this.z;
            j.this.z = j.this.getAdapter().getCount();
            if (j.this.getAdapter().hasStableIds() && this.b != null && j.this.A == 0 && j.this.z > 0) {
                j.this.onRestoreInstanceState(this.b);
                this.b = null;
            } else {
                j.this.j();
            }
            j.this.e();
            j.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j.this.u = true;
            if (j.this.getAdapter().hasStableIds()) {
                this.b = j.this.onSaveInstanceState();
            }
            j.this.A = j.this.z;
            j.this.z = 0;
            j.this.x = -1;
            j.this.y = Long.MIN_VALUE;
            j.this.v = -1;
            j.this.w = Long.MIN_VALUE;
            j.this.o = false;
            j.this.e();
            j.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdapterViewCompat.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!j.this.u) {
                j.this.a();
            } else if (j.this.getAdapter() != null) {
                j.this.post(this);
            }
        }
    }

    void f() {
        if (this.r != null) {
            if (this.q || this.D) {
                if (this.e == null) {
                    this.e = new e();
                }
                post(this.e);
            } else {
                a();
            }
        }
        if (this.x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.r != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.r.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            } else {
                this.r.a(this);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.z > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            r8 = this;
            r6 = -9223372036854775808
            r5 = -1
            r2 = 1
            r1 = 0
            int r4 = r8.z
            if (r4 <= 0) goto L55
            boolean r0 = r8.o
            if (r0 == 0) goto L53
            r8.o = r1
            int r0 = r8.i()
            if (r0 < 0) goto L53
            int r3 = r8.b(r0, r2)
            if (r3 != r0) goto L53
            r8.setNextSelectedPositionInt(r0)
            r3 = r2
        L1f:
            if (r3 != 0) goto L4f
            int r0 = r8.getSelectedItemPosition()
            if (r0 < r4) goto L29
            int r0 = r4 + (-1)
        L29:
            if (r0 >= 0) goto L2c
            r0 = r1
        L2c:
            int r4 = r8.b(r0, r2)
            if (r4 >= 0) goto L51
            int r0 = r8.b(r0, r1)
        L36:
            if (r0 < 0) goto L4f
            r8.setNextSelectedPositionInt(r0)
            r8.h()
            r0 = r2
        L3f:
            if (r0 != 0) goto L4e
            r8.x = r5
            r8.y = r6
            r8.v = r5
            r8.w = r6
            r8.o = r1
            r8.h()
        L4e:
            return
        L4f:
            r0 = r3
            goto L3f
        L51:
            r0 = r4
            goto L36
        L53:
            r3 = r1
            goto L1f
        L55:
            r0 = r1
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.j.g():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.x != this.B || this.y != this.C) {
            f();
            this.B = this.x;
            this.C = this.y;
        }
    }

    int i() {
        int i = this.z;
        if (i == 0) {
            return -1;
        }
        long j = this.m;
        int i2 = this.l;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i4) != j) {
                boolean z2 = min == i + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                }
                if (z3 || (z && !z2)) {
                    min++;
                    z = false;
                    i4 = min;
                } else if (z2 || (!z && !z3)) {
                    i3--;
                    z = true;
                    i4 = i3;
                }
            } else {
                return i4;
            }
        }
        return -1;
    }

    int b(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i) {
        this.x = i;
        this.y = a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i) {
        this.v = i;
        this.w = a(i);
        if (this.o && this.p == 0 && i >= 0) {
            this.l = i;
            this.m = this.w;
        }
    }

    void j() {
        if (getChildCount() > 0) {
            this.o = true;
            this.n = this.f176a;
            if (this.x >= 0) {
                View childAt = getChildAt(this.x - this.j);
                this.m = this.w;
                this.l = this.v;
                if (childAt != null) {
                    this.k = childAt.getTop();
                }
                this.p = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.j >= 0 && this.j < adapter.getCount()) {
                this.m = adapter.getItemId(this.j);
            } else {
                this.m = -1L;
            }
            this.l = this.j;
            if (childAt2 != null) {
                this.k = childAt2.getTop();
            }
            this.p = 1;
        }
    }
}
