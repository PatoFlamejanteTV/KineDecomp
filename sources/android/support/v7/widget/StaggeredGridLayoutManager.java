package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private int[] O;
    Span[] t;
    OrientationHelper u;
    OrientationHelper v;
    private int w;
    private int x;
    private final LayoutState y;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final AnchorInfo L = new AnchorInfo();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.f();
        }
    };

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e, reason: collision with root package name */
        Span f3065e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3066f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.f3065e;
            if (span == null) {
                return -1;
            }
            return span.f3085e;
        }

        public boolean isFullSpan() {
            return this.f3066f;
        }

        public void setFullSpan(boolean z) {
            this.f3066f = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f3073a;

        /* renamed from: b, reason: collision with root package name */
        int f3074b;

        /* renamed from: c, reason: collision with root package name */
        int f3075c;

        /* renamed from: d, reason: collision with root package name */
        int[] f3076d;

        /* renamed from: e, reason: collision with root package name */
        int f3077e;

        /* renamed from: f, reason: collision with root package name */
        int[] f3078f;

        /* renamed from: g, reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f3079g;

        /* renamed from: h, reason: collision with root package name */
        boolean f3080h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        void a() {
            this.f3076d = null;
            this.f3075c = 0;
            this.f3073a = -1;
            this.f3074b = -1;
        }

        void b() {
            this.f3076d = null;
            this.f3075c = 0;
            this.f3077e = 0;
            this.f3078f = null;
            this.f3079g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3073a);
            parcel.writeInt(this.f3074b);
            parcel.writeInt(this.f3075c);
            if (this.f3075c > 0) {
                parcel.writeIntArray(this.f3076d);
            }
            parcel.writeInt(this.f3077e);
            if (this.f3077e > 0) {
                parcel.writeIntArray(this.f3078f);
            }
            parcel.writeInt(this.f3080h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.f3079g);
        }

        SavedState(Parcel parcel) {
            this.f3073a = parcel.readInt();
            this.f3074b = parcel.readInt();
            this.f3075c = parcel.readInt();
            int i = this.f3075c;
            if (i > 0) {
                this.f3076d = new int[i];
                parcel.readIntArray(this.f3076d);
            }
            this.f3077e = parcel.readInt();
            int i2 = this.f3077e;
            if (i2 > 0) {
                this.f3078f = new int[i2];
                parcel.readIntArray(this.f3078f);
            }
            this.f3080h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.f3079g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3075c = savedState.f3075c;
            this.f3073a = savedState.f3073a;
            this.f3074b = savedState.f3074b;
            this.f3076d = savedState.f3076d;
            this.f3077e = savedState.f3077e;
            this.f3078f = savedState.f3078f;
            this.f3080h = savedState.f3080h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.f3079g = savedState.f3079g;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.y = new LayoutState();
        l();
    }

    private boolean a(Span span) {
        if (this.A) {
            if (span.d() < this.u.getEndAfterPadding()) {
                ArrayList<View> arrayList = span.f3081a;
                return !span.b(arrayList.get(arrayList.size() - 1)).f3066f;
            }
        } else if (span.e() > this.u.getStartAfterPadding()) {
            return !span.b(span.f3081a.get(0)).f3066f;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0157, code lost:            if (f() != false) goto L90;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.support.v7.widget.RecyclerView.Recycler r9, android.support.v7.widget.RecyclerView.State r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.c(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, boolean):void");
    }

    private LazySpanLookup.FullSpanItem d(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3071c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.f3071c[i2] = i - this.t[i2].a(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem e(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3071c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.f3071c[i2] = this.t[i2].b(i) - i;
        }
        return fullSpanItem;
    }

    private int h(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int i(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void l() {
        this.u = OrientationHelper.createOrientationHelper(this, this.w);
        this.v = OrientationHelper.createOrientationHelper(this, 1 - this.w);
    }

    private void m() {
        if (this.v.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float decoratedMeasurement = this.v.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f2) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.s;
                }
                f2 = Math.max(f2, decoratedMeasurement);
            }
        }
        int i2 = this.x;
        int round = Math.round(f2 * this.s);
        if (this.v.getMode() == Integer.MIN_VALUE) {
            round = Math.min(round, this.v.getTotalSpace());
        }
        a(round);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f3066f) {
                if (k() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = layoutParams.f3065e.f3085e;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.f3065e.f3085e;
                    int i7 = this.x * i6;
                    int i8 = i6 * i2;
                    if (this.w == 1) {
                        childAt2.offsetLeftAndRight(i7 - i8);
                    } else {
                        childAt2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    private void n() {
        if (this.w != 1 && k()) {
            this.A = !this.z;
        } else {
            this.A = this.z;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.I == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    void b(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (a(state, anchorInfo) || c(state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f3058a = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.w == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.w == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int a2;
        int i3;
        if (this.w != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        a(i, state);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.s; i5++) {
            LayoutState layoutState = this.y;
            if (layoutState.f2810d == -1) {
                a2 = layoutState.f2812f;
                i3 = this.t[i5].b(a2);
            } else {
                a2 = this.t[i5].a(layoutState.f2813g);
                i3 = this.y.f2813g;
            }
            int i6 = a2 - i3;
            if (i6 >= 0) {
                this.O[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.O, 0, i4);
        for (int i7 = 0; i7 < i4 && this.y.a(state); i7++) {
            layoutPrefetchRegistry.addPosition(this.y.f2809c, this.O[i7]);
            LayoutState layoutState2 = this.y;
            layoutState2.f2809c += layoutState2.f2810d;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return a(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int b2 = b(i);
        PointF pointF = new PointF();
        if (b2 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = b2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = b2;
        }
        return pointF;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return a(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return c(state);
    }

    boolean f() {
        int h2;
        int i;
        if (getChildCount() == 0 || this.F == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.A) {
            h2 = i();
            i = h();
        } else {
            h2 = h();
            i = i();
        }
        if (h2 == 0 && j() != null) {
            this.E.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i2 = this.A ? -1 : 1;
        int i3 = i + 1;
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.E.getFirstFullSpanItemInRange(h2, i3, i2, true);
        if (firstFullSpanItemInRange == null) {
            this.M = false;
            this.E.b(i3);
            return false;
        }
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.E.getFirstFullSpanItemInRange(h2, firstFullSpanItemInRange.f3069a, i2 * (-1), true);
        if (firstFullSpanItemInRange2 == null) {
            this.E.b(firstFullSpanItemInRange.f3069a);
        } else {
            this.E.b(firstFullSpanItemInRange2.f3069a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.s; i++) {
            iArr[i] = this.t[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.s; i++) {
            iArr[i] = this.t[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.s; i++) {
            iArr[i] = this.t[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.s];
        } else if (iArr.length < this.s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.s + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.s; i++) {
            iArr[i] = this.t[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    int g() {
        View a2 = this.A ? a(true) : b(true);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.w == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.w == 1) {
            return this.s;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.F;
    }

    public int getOrientation() {
        return this.w;
    }

    public boolean getReverseLayout() {
        return this.z;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.w == 0) {
            return this.s;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.s;
    }

    public void invalidateSpanAssignments() {
        this.E.a();
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.F != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:            if (r10 == r11) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:            r10 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:            r10 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:            if (r10 == r11) goto L37;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View j() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.k()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r8 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r8
            android.support.v7.widget.StaggeredGridLayoutManager$Span r9 = r8.f3065e
            int r9 = r9.f3085e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            android.support.v7.widget.StaggeredGridLayoutManager$Span r9 = r8.f3065e
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            android.support.v7.widget.StaggeredGridLayoutManager$Span r9 = r8.f3065e
            int r9 = r9.f3085e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f3066f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            android.support.v7.widget.OrientationHelper r10 = r12.u
            int r10 = r10.getDecoratedEnd(r7)
            android.support.v7.widget.OrientationHelper r11 = r12.u
            int r11 = r11.getDecoratedEnd(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            android.support.v7.widget.OrientationHelper r10 = r12.u
            int r10 = r10.getDecoratedStart(r7)
            android.support.v7.widget.OrientationHelper r11 = r12.u
            int r11 = r11.getDecoratedStart(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r9 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r9
            android.support.v7.widget.StaggeredGridLayoutManager$Span r8 = r8.f3065e
            int r8 = r8.f3085e
            android.support.v7.widget.StaggeredGridLayoutManager$Span r9 = r9.f3065e
            int r9 = r9.f3085e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.j():android.view.View");
    }

    boolean k() {
        return getLayoutDirection() == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].c();
        }
        recyclerView.requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int h2;
        int findLastPartiallyVisibleItemPosition;
        int findLastPartiallyVisibleItemPosition2;
        int findLastPartiallyVisibleItemPosition3;
        View focusableViewAfter;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        n();
        int c2 = c(i);
        if (c2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.f3066f;
        Span span = layoutParams.f3065e;
        if (c2 == 1) {
            h2 = i();
        } else {
            h2 = h();
        }
        b(h2, state);
        m(c2);
        LayoutState layoutState = this.y;
        layoutState.f2809c = layoutState.f2810d + h2;
        layoutState.f2808b = (int) (this.u.getTotalSpace() * 0.33333334f);
        LayoutState layoutState2 = this.y;
        layoutState2.f2814h = true;
        layoutState2.f2807a = false;
        a(recycler, layoutState2, state);
        this.G = this.A;
        if (!z && (focusableViewAfter = span.getFocusableViewAfter(h2, c2)) != null && focusableViewAfter != findContainingItemView) {
            return focusableViewAfter;
        }
        if (l(c2)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View focusableViewAfter2 = this.t[i2].getFocusableViewAfter(h2, c2);
                if (focusableViewAfter2 != null && focusableViewAfter2 != findContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View focusableViewAfter3 = this.t[i3].getFocusableViewAfter(h2, c2);
                if (focusableViewAfter3 != null && focusableViewAfter3 != findContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (c2 == -1);
        if (!z) {
            if (z2) {
                findLastPartiallyVisibleItemPosition3 = span.findFirstPartiallyVisibleItemPosition();
            } else {
                findLastPartiallyVisibleItemPosition3 = span.findLastPartiallyVisibleItemPosition();
            }
            View findViewByPosition = findViewByPosition(findLastPartiallyVisibleItemPosition3);
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (l(c2)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != span.f3085e) {
                    if (z2) {
                        findLastPartiallyVisibleItemPosition2 = this.t[i4].findFirstPartiallyVisibleItemPosition();
                    } else {
                        findLastPartiallyVisibleItemPosition2 = this.t[i4].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition2 = findViewByPosition(findLastPartiallyVisibleItemPosition2);
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                if (z2) {
                    findLastPartiallyVisibleItemPosition = this.t[i5].findFirstPartiallyVisibleItemPosition();
                } else {
                    findLastPartiallyVisibleItemPosition = this.t[i5].findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition3 = findViewByPosition(findLastPartiallyVisibleItemPosition);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 == null || a2 == null) {
                return;
            }
            int position = getPosition(b2);
            int position2 = getPosition(a2);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.w == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.f3066f ? this.s : 1, -1, -1, layoutParams2.f3066f, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.f3066f ? this.s : 1, layoutParams2.f3066f, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.E.a();
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        b(i, i2, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        b(i, i2, 4);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        c(recycler, state, true);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.I = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int b2;
        int startAfterPadding;
        int[] iArr;
        SavedState savedState = this.I;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f3080h = this.z;
        savedState2.i = this.G;
        savedState2.j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.f3067a) != null) {
            savedState2.f3078f = iArr;
            savedState2.f3077e = savedState2.f3078f.length;
            savedState2.f3079g = lazySpanLookup.f3068b;
        } else {
            savedState2.f3077e = 0;
        }
        if (getChildCount() > 0) {
            savedState2.f3073a = this.G ? i() : h();
            savedState2.f3074b = g();
            int i = this.s;
            savedState2.f3075c = i;
            savedState2.f3076d = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    b2 = this.t[i2].a(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.u.getEndAfterPadding();
                        b2 -= startAfterPadding;
                        savedState2.f3076d[i2] = b2;
                    } else {
                        savedState2.f3076d[i2] = b2;
                    }
                } else {
                    b2 = this.t[i2].b(Integer.MIN_VALUE);
                    if (b2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.u.getStartAfterPadding();
                        b2 -= startAfterPadding;
                        savedState2.f3076d[i2] = b2;
                    } else {
                        savedState2.f3076d[i2] = b2;
                    }
                }
            }
        } else {
            savedState2.f3073a = -1;
            savedState2.f3074b = -1;
            savedState2.f3075c = 0;
        }
        return savedState2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            f();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.f3073a != i) {
            savedState.a();
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.a();
        }
        this.C = i;
        this.D = i2;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.F) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.F = i;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.w == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, (this.x * this.s) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, (this.x * this.s) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        OrientationHelper orientationHelper = this.u;
        this.u = this.v;
        this.v = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.f3080h != z) {
            savedState.f3080h = z;
        }
        this.z = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.s) {
            invalidateSpanAssignments();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new Span[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new Span(i2);
            }
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.I == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        int[] f3067a;

        /* renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f3068b;

        LazySpanLookup() {
        }

        private int f(int i) {
            if (this.f3068b == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.f3068b.remove(fullSpanItem);
            }
            int size = this.f3068b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f3068b.get(i2).f3069a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = this.f3068b.get(i2);
            this.f3068b.remove(i2);
            return fullSpanItem2.f3069a;
        }

        void a(int i, Span span) {
            a(i);
            this.f3067a[i] = span.f3085e;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.f3068b == null) {
                this.f3068b = new ArrayList();
            }
            int size = this.f3068b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f3068b.get(i);
                if (fullSpanItem2.f3069a == fullSpanItem.f3069a) {
                    this.f3068b.remove(i);
                }
                if (fullSpanItem2.f3069a >= fullSpanItem.f3069a) {
                    this.f3068b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3068b.add(fullSpanItem);
        }

        int b(int i) {
            List<FullSpanItem> list = this.f3068b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3068b.get(size).f3069a >= i) {
                        this.f3068b.remove(size);
                    }
                }
            }
            return d(i);
        }

        int c(int i) {
            int[] iArr = this.f3067a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int d(int i) {
            int[] iArr = this.f3067a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int f2 = f(i);
            if (f2 == -1) {
                int[] iArr2 = this.f3067a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f3067a.length;
            }
            int i2 = f2 + 1;
            Arrays.fill(this.f3067a, i, i2, -1);
            return i2;
        }

        int e(int i) {
            int length = this.f3067a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f3068b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f3068b.get(i4);
                int i5 = fullSpanItem.f3069a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f3070b == i3 || (z && fullSpanItem.f3072d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            List<FullSpanItem> list = this.f3068b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3068b.get(size);
                if (fullSpanItem.f3069a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.f3068b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3068b.get(size);
                int i3 = fullSpanItem.f3069a;
                if (i3 >= i) {
                    fullSpanItem.f3069a = i3 + i2;
                }
            }
        }

        void a(int i) {
            int[] iArr = this.f3067a;
            if (iArr == null) {
                this.f3067a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f3067a, -1);
            } else if (i >= iArr.length) {
                this.f3067a = new int[e(i)];
                System.arraycopy(iArr, 0, this.f3067a, 0, iArr.length);
                int[] iArr2 = this.f3067a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* renamed from: a, reason: collision with root package name */
            int f3069a;

            /* renamed from: b, reason: collision with root package name */
            int f3070b;

            /* renamed from: c, reason: collision with root package name */
            int[] f3071c;

            /* renamed from: d, reason: collision with root package name */
            boolean f3072d;

            FullSpanItem(Parcel parcel) {
                this.f3069a = parcel.readInt();
                this.f3070b = parcel.readInt();
                this.f3072d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f3071c = new int[readInt];
                    parcel.readIntArray(this.f3071c);
                }
            }

            int a(int i) {
                int[] iArr = this.f3071c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3069a + ", mGapDir=" + this.f3070b + ", mHasUnwantedGapAfter=" + this.f3072d + ", mGapPerSpan=" + Arrays.toString(this.f3071c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3069a);
                parcel.writeInt(this.f3070b);
                parcel.writeInt(this.f3072d ? 1 : 0);
                int[] iArr = this.f3071c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3071c);
                } else {
                    parcel.writeInt(0);
                }
            }

            FullSpanItem() {
            }
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.f3068b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3068b.get(size);
                int i4 = fullSpanItem.f3069a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f3068b.remove(size);
                    } else {
                        fullSpanItem.f3069a = i4 - i2;
                    }
                }
            }
        }

        void b(int i, int i2) {
            int[] iArr = this.f3067a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f3067a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f3067a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            d(i, i2);
        }

        void a() {
            int[] iArr = this.f3067a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3068b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f3067a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            a(i3);
            int[] iArr2 = this.f3067a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f3067a, i, i3, -1);
            c(i, i2);
        }
    }

    private int k(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Span {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f3081a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f3082b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f3083c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        int f3084d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f3085e;

        Span(int i) {
            this.f3085e = i;
        }

        int a(int i) {
            int i2 = this.f3083c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3081a.size() == 0) {
                return i;
            }
            a();
            return this.f3083c;
        }

        int b(int i) {
            int i2 = this.f3082b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3081a.size() == 0) {
                return i;
            }
            b();
            return this.f3082b;
        }

        void c(View view) {
            LayoutParams b2 = b(view);
            b2.f3065e = this;
            this.f3081a.add(0, view);
            this.f3082b = Integer.MIN_VALUE;
            if (this.f3081a.size() == 1) {
                this.f3083c = Integer.MIN_VALUE;
            }
            if (b2.isItemRemoved() || b2.isItemChanged()) {
                this.f3084d += StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(view);
            }
        }

        int d() {
            int i = this.f3083c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f3083c;
        }

        int e() {
            int i = this.f3082b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f3082b;
        }

        void f() {
            this.f3082b = Integer.MIN_VALUE;
            this.f3083c = Integer.MIN_VALUE;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return b(this.f3081a.size() - 1, -1, true);
            }
            return b(0, this.f3081a.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f3081a.size() - 1, -1, true);
            }
            return a(0, this.f3081a.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return b(this.f3081a.size() - 1, -1, false);
            }
            return b(0, this.f3081a.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return b(0, this.f3081a.size(), true);
            }
            return b(this.f3081a.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f3081a.size(), true);
            }
            return a(this.f3081a.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.z) {
                return b(0, this.f3081a.size(), false);
            }
            return b(this.f3081a.size() - 1, -1, false);
        }

        void g() {
            int size = this.f3081a.size();
            View remove = this.f3081a.remove(size - 1);
            LayoutParams b2 = b(remove);
            b2.f3065e = null;
            if (b2.isItemRemoved() || b2.isItemChanged()) {
                this.f3084d -= StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.f3082b = Integer.MIN_VALUE;
            }
            this.f3083c = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.f3084d;
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f3081a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f3081a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.getPosition(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.getPosition(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f3081a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f3081a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.getPosition(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.getPosition(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        void h() {
            View remove = this.f3081a.remove(0);
            LayoutParams b2 = b(remove);
            b2.f3065e = null;
            if (this.f3081a.size() == 0) {
                this.f3083c = Integer.MIN_VALUE;
            }
            if (b2.isItemRemoved() || b2.isItemChanged()) {
                this.f3084d -= StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(remove);
            }
            this.f3082b = Integer.MIN_VALUE;
        }

        void d(int i) {
            this.f3082b = i;
            this.f3083c = i;
        }

        void a() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.f3081a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams b2 = b(view);
            this.f3083c = StaggeredGridLayoutManager.this.u.getDecoratedEnd(view);
            if (b2.f3066f && (fullSpanItem = StaggeredGridLayoutManager.this.E.getFullSpanItem(b2.getViewLayoutPosition())) != null && fullSpanItem.f3070b == 1) {
                this.f3083c += fullSpanItem.a(this.f3085e);
            }
        }

        void b() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            View view = this.f3081a.get(0);
            LayoutParams b2 = b(view);
            this.f3082b = StaggeredGridLayoutManager.this.u.getDecoratedStart(view);
            if (b2.f3066f && (fullSpanItem = StaggeredGridLayoutManager.this.E.getFullSpanItem(b2.getViewLayoutPosition())) != null && fullSpanItem.f3070b == -1) {
                this.f3082b -= fullSpanItem.a(this.f3085e);
            }
        }

        void c() {
            this.f3081a.clear();
            f();
            this.f3084d = 0;
        }

        void c(int i) {
            int i2 = this.f3082b;
            if (i2 != Integer.MIN_VALUE) {
                this.f3082b = i2 + i;
            }
            int i3 = this.f3083c;
            if (i3 != Integer.MIN_VALUE) {
                this.f3083c = i3 + i;
            }
        }

        void a(View view) {
            LayoutParams b2 = b(view);
            b2.f3065e = this;
            this.f3081a.add(view);
            this.f3083c = Integer.MIN_VALUE;
            if (this.f3081a.size() == 1) {
                this.f3082b = Integer.MIN_VALUE;
            }
            if (b2.isItemRemoved() || b2.isItemChanged()) {
                this.f3084d += StaggeredGridLayoutManager.this.u.getDecoratedMeasurement(view);
            }
        }

        LayoutParams b(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        void a(boolean z, int i) {
            int b2;
            if (z) {
                b2 = a(Integer.MIN_VALUE);
            } else {
                b2 = b(Integer.MIN_VALUE);
            }
            c();
            if (b2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || b2 >= StaggeredGridLayoutManager.this.u.getEndAfterPadding()) {
                if (z || b2 <= StaggeredGridLayoutManager.this.u.getStartAfterPadding()) {
                    if (i != Integer.MIN_VALUE) {
                        b2 += i;
                    }
                    this.f3083c = b2;
                    this.f3082b = b2;
                }
            }
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int startAfterPadding = StaggeredGridLayoutManager.this.u.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.u.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f3081a.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.u.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.u.getDecoratedEnd(view);
                boolean z4 = false;
                boolean z5 = !z3 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AnchorInfo {

        /* renamed from: a, reason: collision with root package name */
        int f3058a;

        /* renamed from: b, reason: collision with root package name */
        int f3059b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3060c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3061d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3062e;

        /* renamed from: f, reason: collision with root package name */
        int[] f3063f;

        AnchorInfo() {
            b();
        }

        void a(Span[] spanArr) {
            int length = spanArr.length;
            int[] iArr = this.f3063f;
            if (iArr == null || iArr.length < length) {
                this.f3063f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f3063f[i] = spanArr[i].b(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f3058a = -1;
            this.f3059b = Integer.MIN_VALUE;
            this.f3060c = false;
            this.f3061d = false;
            this.f3062e = false;
            int[] iArr = this.f3063f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a() {
            this.f3059b = this.f3060c ? StaggeredGridLayoutManager.this.u.getEndAfterPadding() : StaggeredGridLayoutManager.this.u.getStartAfterPadding();
        }

        void a(int i) {
            if (this.f3060c) {
                this.f3059b = StaggeredGridLayoutManager.this.u.getEndAfterPadding() - i;
            } else {
                this.f3059b = StaggeredGridLayoutManager.this.u.getStartAfterPadding() + i;
            }
        }
    }

    private int g(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private boolean l(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == k();
    }

    int h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    boolean d() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    boolean e() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    private void a(AnchorInfo anchorInfo) {
        int startAfterPadding;
        SavedState savedState = this.I;
        int i = savedState.f3075c;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].c();
                    SavedState savedState2 = this.I;
                    int i3 = savedState2.f3076d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        if (savedState2.i) {
                            startAfterPadding = this.u.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.u.getStartAfterPadding();
                        }
                        i3 += startAfterPadding;
                    }
                    this.t[i2].d(i3);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f3073a = savedState3.f3074b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.j;
        setReverseLayout(savedState4.f3080h);
        n();
        SavedState savedState5 = this.I;
        int i4 = savedState5.f3073a;
        if (i4 != -1) {
            this.C = i4;
            anchorInfo.f3060c = savedState5.i;
        } else {
            anchorInfo.f3060c = this.A;
        }
        SavedState savedState6 = this.I;
        if (savedState6.f3077e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f3067a = savedState6.f3078f;
            lazySpanLookup.f3068b = savedState6.f3079g;
        }
    }

    View b(boolean z) {
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.u.getDecoratedStart(childAt);
            if (this.u.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int k = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (k != Integer.MAX_VALUE && (startAfterPadding = k - this.u.getStartAfterPadding()) > 0) {
            int a2 = startAfterPadding - a(startAfterPadding, recycler, state);
            if (!z || a2 <= 0) {
                return;
            }
            this.u.offsetChildren(-a2);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.w = i2;
        setSpanCount(i);
        this.y = new LayoutState();
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r5, android.support.v7.widget.RecyclerView.State r6) {
        /*
            r4 = this;
            android.support.v7.widget.LayoutState r0 = r4.y
            r1 = 0
            r0.f2808b = r1
            r0.f2809c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.getTargetScrollPosition()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            android.support.v7.widget.OrientationHelper r5 = r4.u
            int r5 = r5.getTotalSpace()
            goto L2f
        L25:
            android.support.v7.widget.OrientationHelper r5 = r4.u
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            android.support.v7.widget.LayoutState r0 = r4.y
            android.support.v7.widget.OrientationHelper r3 = r4.u
            int r3 = r3.getStartAfterPadding()
            int r3 = r3 - r6
            r0.f2812f = r3
            android.support.v7.widget.LayoutState r6 = r4.y
            android.support.v7.widget.OrientationHelper r0 = r4.u
            int r0 = r0.getEndAfterPadding()
            int r0 = r0 + r5
            r6.f2813g = r0
            goto L5d
        L4d:
            android.support.v7.widget.LayoutState r0 = r4.y
            android.support.v7.widget.OrientationHelper r3 = r4.u
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.f2813g = r3
            android.support.v7.widget.LayoutState r5 = r4.y
            int r6 = -r6
            r5.f2812f = r6
        L5d:
            android.support.v7.widget.LayoutState r5 = r4.y
            r5.f2814h = r1
            r5.f2807a = r2
            android.support.v7.widget.OrientationHelper r6 = r4.u
            int r6 = r6.getMode()
            if (r6 != 0) goto L74
            android.support.v7.widget.OrientationHelper r6 = r4.u
            int r6 = r6.getEnd()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, android.support.v7.widget.RecyclerView$State):void");
    }

    private int j(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int f(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private void m(int i) {
        LayoutState layoutState = this.y;
        layoutState.f2811e = i;
        layoutState.f2810d = this.A != (i == -1) ? -1 : 1;
    }

    boolean a(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int startAfterPadding;
        if (!state.isPreLayout() && (i = this.C) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                SavedState savedState = this.I;
                if (savedState != null && savedState.f3073a != -1 && savedState.f3075c >= 1) {
                    anchorInfo.f3059b = Integer.MIN_VALUE;
                    anchorInfo.f3058a = this.C;
                } else {
                    View findViewByPosition = findViewByPosition(this.C);
                    if (findViewByPosition != null) {
                        anchorInfo.f3058a = this.A ? i() : h();
                        if (this.D != Integer.MIN_VALUE) {
                            if (anchorInfo.f3060c) {
                                anchorInfo.f3059b = (this.u.getEndAfterPadding() - this.D) - this.u.getDecoratedEnd(findViewByPosition);
                            } else {
                                anchorInfo.f3059b = (this.u.getStartAfterPadding() + this.D) - this.u.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.u.getDecoratedMeasurement(findViewByPosition) > this.u.getTotalSpace()) {
                            if (anchorInfo.f3060c) {
                                startAfterPadding = this.u.getEndAfterPadding();
                            } else {
                                startAfterPadding = this.u.getStartAfterPadding();
                            }
                            anchorInfo.f3059b = startAfterPadding;
                            return true;
                        }
                        int decoratedStart = this.u.getDecoratedStart(findViewByPosition) - this.u.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            anchorInfo.f3059b = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.u.getEndAfterPadding() - this.u.getDecoratedEnd(findViewByPosition);
                        if (endAfterPadding < 0) {
                            anchorInfo.f3059b = endAfterPadding;
                            return true;
                        }
                        anchorInfo.f3059b = Integer.MIN_VALUE;
                    } else {
                        anchorInfo.f3058a = this.C;
                        int i2 = this.D;
                        if (i2 == Integer.MIN_VALUE) {
                            anchorInfo.f3060c = b(anchorInfo.f3058a) == 1;
                            anchorInfo.a();
                        } else {
                            anchorInfo.a(i2);
                        }
                        anchorInfo.f3061d = true;
                    }
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.i()
            goto Ld
        L9:
            int r0 = r6.h()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.d(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r4)
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.a(r8, r4)
            goto L43
        L38:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r8)
            goto L43
        L3e:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.a(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.A
            if (r7 == 0) goto L4f
            int r7 = r6.h()
            goto L53
        L4f:
            int r7 = r6.i()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b(int, int, int):void");
    }

    private void b(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].c(view);
        }
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.u.getDecoratedEnd(childAt) > i || this.u.getTransformedEndWithDecoration(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3066f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f3081a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].h();
                }
            } else if (layoutParams.f3065e.f3081a.size() == 1) {
                return;
            } else {
                layoutParams.f3065e.h();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private int b(int i) {
        if (getChildCount() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < h()) != this.A ? -1 : 1;
    }

    void a(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.getMode());
    }

    private boolean c(RecyclerView.State state, AnchorInfo anchorInfo) {
        int f2;
        if (this.G) {
            f2 = g(state.getItemCount());
        } else {
            f2 = f(state.getItemCount());
        }
        anchorInfo.f3058a = f2;
        anchorInfo.f3059b = Integer.MIN_VALUE;
        return true;
    }

    private int a(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.a(state, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.b(state, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f3066f) {
            if (this.w == 1) {
                a(view, this.J, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                return;
            } else {
                a(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.J, z);
                return;
            }
        }
        if (this.w == 1) {
            a(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.x, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            a(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.x, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    private int c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private void c(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f3081a.isEmpty()) {
                a(this.t[i3], i, i2);
            }
        }
    }

    private int c(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE : this.w == 0 ? 1 : Integer.MIN_VALUE : this.w == 1 ? -1 : Integer.MIN_VALUE : this.w == 0 ? -1 : Integer.MIN_VALUE : (this.w != 1 && k()) ? -1 : 1 : (this.w != 1 && k()) ? 1 : -1;
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean a2;
        calculateItemDecorationsForChild(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int c2 = c(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int c3 = c(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z) {
            a2 = b(view, c2, c3, layoutParams);
        } else {
            a2 = a(view, c2, c3, layoutParams);
        }
        if (a2) {
            view.measure(c2, c3);
        }
    }

    View a(boolean z) {
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.u.getDecoratedStart(childAt);
            int decoratedEnd = this.u.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int h2 = h(Integer.MIN_VALUE);
        if (h2 != Integer.MIN_VALUE && (endAfterPadding = this.u.getEndAfterPadding() - h2) > 0) {
            int i = endAfterPadding - (-a(-endAfterPadding, recycler, state));
            if (!z || i <= 0) {
                return;
            }
            this.u.offsetChildren(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int i2;
        int startAfterPadding;
        int h2;
        Span span;
        int decoratedMeasurement;
        int i3;
        int i4;
        int decoratedMeasurement2;
        boolean e2;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i2 = layoutState.f2811e == 1 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : Integer.MIN_VALUE;
        } else {
            if (layoutState.f2811e == 1) {
                i = layoutState.f2813g + layoutState.f2808b;
            } else {
                i = layoutState.f2812f - layoutState.f2808b;
            }
            i2 = i;
        }
        c(layoutState.f2811e, i2);
        if (this.A) {
            startAfterPadding = this.u.getEndAfterPadding();
        } else {
            startAfterPadding = this.u.getStartAfterPadding();
        }
        int i5 = startAfterPadding;
        boolean z = false;
        while (layoutState.a(state) && (this.y.i || !this.B.isEmpty())) {
            View a2 = layoutState.a(recycler);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int c2 = this.E.c(viewLayoutPosition);
            boolean z2 = c2 == -1;
            if (z2) {
                span = layoutParams.f3066f ? this.t[r9] : a(layoutState);
                this.E.a(viewLayoutPosition, span);
            } else {
                span = this.t[c2];
            }
            Span span2 = span;
            layoutParams.f3065e = span2;
            if (layoutState.f2811e == 1) {
                addView(a2);
            } else {
                addView(a2, r9);
            }
            a(a2, layoutParams, (boolean) r9);
            if (layoutState.f2811e == 1) {
                int h3 = layoutParams.f3066f ? h(i5) : span2.a(i5);
                int decoratedMeasurement3 = this.u.getDecoratedMeasurement(a2) + h3;
                if (z2 && layoutParams.f3066f) {
                    LazySpanLookup.FullSpanItem d2 = d(h3);
                    d2.f3070b = -1;
                    d2.f3069a = viewLayoutPosition;
                    this.E.addFullSpanItem(d2);
                }
                i3 = decoratedMeasurement3;
                decoratedMeasurement = h3;
            } else {
                int k = layoutParams.f3066f ? k(i5) : span2.b(i5);
                decoratedMeasurement = k - this.u.getDecoratedMeasurement(a2);
                if (z2 && layoutParams.f3066f) {
                    LazySpanLookup.FullSpanItem e3 = e(k);
                    e3.f3070b = 1;
                    e3.f3069a = viewLayoutPosition;
                    this.E.addFullSpanItem(e3);
                }
                i3 = k;
            }
            if (layoutParams.f3066f && layoutState.f2810d == -1) {
                if (z2) {
                    this.M = true;
                } else {
                    if (layoutState.f2811e == 1) {
                        e2 = d();
                    } else {
                        e2 = e();
                    }
                    if (!e2) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.E.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.f3072d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, layoutParams, layoutState);
            if (k() && this.w == 1) {
                int endAfterPadding = layoutParams.f3066f ? this.v.getEndAfterPadding() : this.v.getEndAfterPadding() - (((this.s - 1) - span2.f3085e) * this.x);
                decoratedMeasurement2 = endAfterPadding;
                i4 = endAfterPadding - this.v.getDecoratedMeasurement(a2);
            } else {
                int startAfterPadding2 = layoutParams.f3066f ? this.v.getStartAfterPadding() : (span2.f3085e * this.x) + this.v.getStartAfterPadding();
                i4 = startAfterPadding2;
                decoratedMeasurement2 = this.v.getDecoratedMeasurement(a2) + startAfterPadding2;
            }
            if (this.w == 1) {
                layoutDecoratedWithMargins(a2, i4, decoratedMeasurement, decoratedMeasurement2, i3);
            } else {
                layoutDecoratedWithMargins(a2, decoratedMeasurement, i4, i3, decoratedMeasurement2);
            }
            if (layoutParams.f3066f) {
                c(this.y.f2811e, i2);
            } else {
                a(span2, this.y.f2811e, i2);
            }
            a(recycler, this.y);
            if (this.y.f2814h && a2.hasFocusable()) {
                if (layoutParams.f3066f) {
                    this.B.clear();
                } else {
                    this.B.set(span2.f3085e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(recycler, this.y);
        }
        if (this.y.f2811e == -1) {
            h2 = this.u.getStartAfterPadding() - k(this.u.getStartAfterPadding());
        } else {
            h2 = h(this.u.getEndAfterPadding()) - this.u.getEndAfterPadding();
        }
        if (h2 > 0) {
            return Math.min(layoutState.f2808b, h2);
        }
        return 0;
    }

    private void a(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.f2811e == 1) {
            if (layoutParams.f3066f) {
                a(view);
                return;
            } else {
                layoutParams.f3065e.a(view);
                return;
            }
        }
        if (layoutParams.f3066f) {
            b(view);
        } else {
            layoutParams.f3065e.c(view);
        }
    }

    private void a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (!layoutState.f2807a || layoutState.i) {
            return;
        }
        if (layoutState.f2808b == 0) {
            if (layoutState.f2811e == -1) {
                a(recycler, layoutState.f2813g);
                return;
            } else {
                b(recycler, layoutState.f2812f);
                return;
            }
        }
        if (layoutState.f2811e == -1) {
            int i = layoutState.f2812f;
            int i2 = i - i(i);
            if (i2 < 0) {
                min2 = layoutState.f2813g;
            } else {
                min2 = layoutState.f2813g - Math.min(i2, layoutState.f2808b);
            }
            a(recycler, min2);
            return;
        }
        int j = j(layoutState.f2813g) - layoutState.f2813g;
        if (j < 0) {
            min = layoutState.f2812f;
        } else {
            min = Math.min(j, layoutState.f2808b) + layoutState.f2812f;
        }
        b(recycler, min);
    }

    private void a(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void a(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.e() + deletedSize <= i2) {
                this.B.set(span.f3085e, false);
            }
        } else if (span.d() - deletedSize >= i2) {
            this.B.set(span.f3085e, false);
        }
    }

    private void a(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.u.getDecoratedStart(childAt) < i || this.u.getTransformedStartWithDecoration(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f3066f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f3081a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].g();
                }
            } else if (layoutParams.f3065e.f3081a.size() == 1) {
                return;
            } else {
                layoutParams.f3065e.g();
            }
            removeAndRecycleView(childAt, recycler);
        }
    }

    private Span a(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (l(layoutState.f2811e)) {
            i = this.s - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.s;
            i2 = 1;
        }
        Span span = null;
        if (layoutState.f2811e == 1) {
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int startAfterPadding = this.u.getStartAfterPadding();
            while (i != i3) {
                Span span2 = this.t[i];
                int a2 = span2.a(startAfterPadding);
                if (a2 < i4) {
                    span = span2;
                    i4 = a2;
                }
                i += i2;
            }
            return span;
        }
        int i5 = Integer.MIN_VALUE;
        int endAfterPadding = this.u.getEndAfterPadding();
        while (i != i3) {
            Span span3 = this.t[i];
            int b2 = span3.b(endAfterPadding);
            if (b2 > i5) {
                span = span3;
                i5 = b2;
            }
            i += i2;
        }
        return span;
    }

    void a(int i, RecyclerView.State state) {
        int h2;
        int i2;
        if (i > 0) {
            h2 = i();
            i2 = 1;
        } else {
            h2 = h();
            i2 = -1;
        }
        this.y.f2807a = true;
        b(h2, state);
        m(i2);
        LayoutState layoutState = this.y;
        layoutState.f2809c = h2 + layoutState.f2810d;
        layoutState.f2808b = Math.abs(i);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i, state);
        int a2 = a(recycler, this.y, state);
        if (this.y.f2808b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.u.offsetChildren(-i);
        this.G = this.A;
        LayoutState layoutState = this.y;
        layoutState.f2808b = 0;
        a(recycler, layoutState);
        return i;
    }
}
