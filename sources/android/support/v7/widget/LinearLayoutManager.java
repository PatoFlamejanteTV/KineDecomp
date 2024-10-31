package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    int A;
    int B;
    private boolean C;
    SavedState D;
    final AnchorInfo E;
    private final LayoutChunkResult F;
    private int G;
    int s;
    private LayoutState t;
    OrientationHelper u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void a() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutState {

        /* renamed from: b, reason: collision with root package name */
        int f2829b;

        /* renamed from: c, reason: collision with root package name */
        int f2830c;

        /* renamed from: d, reason: collision with root package name */
        int f2831d;

        /* renamed from: e, reason: collision with root package name */
        int f2832e;

        /* renamed from: f, reason: collision with root package name */
        int f2833f;

        /* renamed from: g, reason: collision with root package name */
        int f2834g;
        int j;
        boolean l;

        /* renamed from: a, reason: collision with root package name */
        boolean f2828a = true;

        /* renamed from: h, reason: collision with root package name */
        int f2835h = 0;
        boolean i = false;
        List<RecyclerView.ViewHolder> k = null;

        LayoutState() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.State state) {
            int i = this.f2831d;
            return i >= 0 && i < state.getItemCount();
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.k.size();
            View view2 = null;
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.f2831d) * this.f2832e) >= 0 && viewLayoutPosition < i) {
                    if (viewLayoutPosition == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = viewLayoutPosition;
                }
            }
            return view2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.Recycler recycler) {
            if (this.k != null) {
                return a();
            }
            View viewForPosition = recycler.getViewForPosition(this.f2831d);
            this.f2831d += this.f2832e;
            return viewForPosition;
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.f2831d = -1;
            } else {
                this.f2831d = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }

        private View a() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = this.k.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f2831d == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
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
        int f2836a;

        /* renamed from: b, reason: collision with root package name */
        int f2837b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2838c;

        public SavedState() {
        }

        boolean a() {
            return this.f2836a >= 0;
        }

        void b() {
            this.f2836a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2836a);
            parcel.writeInt(this.f2837b);
            parcel.writeInt(this.f2838c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f2836a = parcel.readInt();
            this.f2837b = parcel.readInt();
            this.f2838c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f2836a = savedState.f2836a;
            this.f2837b = savedState.f2837b;
            this.f2838c = savedState.f2838c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void b(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (a(state, anchorInfo) || a(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.f2824b = this.y ? state.getItemCount() - 1 : 0;
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.a(state, this.u, b(!this.z, true), a(!this.z, true), this, this.z, this.x);
    }

    private void d(int i, int i2) {
        this.t.f2830c = this.u.getEndAfterPadding() - i2;
        this.t.f2832e = this.x ? -1 : 1;
        LayoutState layoutState = this.t;
        layoutState.f2831d = i;
        layoutState.f2833f = 1;
        layoutState.f2829b = i2;
        layoutState.f2834g = Integer.MIN_VALUE;
    }

    private void e(int i, int i2) {
        this.t.f2830c = i2 - this.u.getStartAfterPadding();
        LayoutState layoutState = this.t;
        layoutState.f2831d = i;
        layoutState.f2832e = this.x ? 1 : -1;
        LayoutState layoutState2 = this.t;
        layoutState2.f2833f = -1;
        layoutState2.f2829b = i2;
        layoutState2.f2834g = Integer.MIN_VALUE;
    }

    private View h() {
        return getChildAt(this.x ? 0 : getChildCount() - 1);
    }

    private View i() {
        return getChildAt(this.x ? getChildCount() - 1 : 0);
    }

    private void j() {
        if (this.s != 1 && f()) {
            this.x = !this.w;
        } else {
            this.x = this.w;
        }
    }

    protected int a(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.u.getTotalSpace();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.D == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.s == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.s == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.s != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        e();
        a(i > 0 ? 1 : -1, Math.abs(i), true, state);
        a(state, this.t, layoutPrefetchRegistry);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            SavedState savedState2 = this.D;
            z = savedState2.f2838c;
            i2 = savedState2.f2836a;
        } else {
            j();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        int i4 = i2;
        for (int i5 = 0; i5 < this.G && i4 >= 0 && i4 < i; i5++) {
            layoutPrefetchRegistry.addPosition(i4, 0);
            i4 += i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.x ? -1 : 1;
        if (this.s == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        return getLayoutDirection() == 1;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View a2 = a(0, getChildCount(), true, false);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    public int findFirstVisibleItemPosition() {
        View a2 = a(0, getChildCount(), false, true);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View a2 = a(getChildCount() - 1, -1, true, false);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    public int findLastVisibleItemPosition() {
        View a2 = a(getChildCount() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return getPosition(a2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    boolean g() {
        return this.u.getMode() == 0 && this.u.getEnd() == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getInitialPrefetchItemCount() {
        return this.G;
    }

    public int getOrientation() {
        return this.s;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.C;
    }

    public boolean getReverseLayout() {
        return this.w;
    }

    public boolean getStackFromEnd() {
        return this.y;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.z;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.C) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int a2;
        View e2;
        View h2;
        j();
        if (getChildCount() == 0 || (a2 = a(i)) == Integer.MIN_VALUE) {
            return null;
        }
        e();
        e();
        a(a2, (int) (this.u.getTotalSpace() * 0.33333334f), false, state);
        LayoutState layoutState = this.t;
        layoutState.f2834g = Integer.MIN_VALUE;
        layoutState.f2828a = false;
        a(recycler, layoutState, state, true);
        if (a2 == -1) {
            e2 = f(recycler, state);
        } else {
            e2 = e(recycler, state);
        }
        if (a2 == -1) {
            h2 = i();
        } else {
            h2 = h();
        }
        if (!h2.hasFocusable()) {
            return e2;
        }
        if (e2 == null) {
            return null;
        }
        return h2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int a2;
        int i6;
        View findViewByPosition;
        int decoratedStart;
        int i7;
        int i8 = -1;
        if ((this.D != null || this.A != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f2836a;
        }
        e();
        this.t.f2828a = false;
        j();
        View focusedChild = getFocusedChild();
        if (this.E.f2827e && this.A == -1 && this.D == null) {
            if (focusedChild != null && (this.u.getDecoratedStart(focusedChild) >= this.u.getEndAfterPadding() || this.u.getDecoratedEnd(focusedChild) <= this.u.getStartAfterPadding())) {
                this.E.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
            }
        } else {
            this.E.b();
            AnchorInfo anchorInfo = this.E;
            anchorInfo.f2826d = this.x ^ this.y;
            b(recycler, state, anchorInfo);
            this.E.f2827e = true;
        }
        int a3 = a(state);
        if (this.t.j >= 0) {
            i = a3;
            a3 = 0;
        } else {
            i = 0;
        }
        int startAfterPadding = a3 + this.u.getStartAfterPadding();
        int endPadding = i + this.u.getEndPadding();
        if (state.isPreLayout() && (i6 = this.A) != -1 && this.B != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.x) {
                i7 = this.u.getEndAfterPadding() - this.u.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.B;
            } else {
                decoratedStart = this.u.getDecoratedStart(findViewByPosition) - this.u.getStartAfterPadding();
                i7 = this.B;
            }
            int i9 = i7 - decoratedStart;
            if (i9 > 0) {
                startAfterPadding += i9;
            } else {
                endPadding -= i9;
            }
        }
        if (!this.E.f2826d ? !this.x : this.x) {
            i8 = 1;
        }
        a(recycler, state, this.E, i8);
        detachAndScrapAttachedViews(recycler);
        this.t.l = g();
        this.t.i = state.isPreLayout();
        AnchorInfo anchorInfo2 = this.E;
        if (anchorInfo2.f2826d) {
            b(anchorInfo2);
            LayoutState layoutState = this.t;
            layoutState.f2835h = startAfterPadding;
            a(recycler, layoutState, state, false);
            LayoutState layoutState2 = this.t;
            i3 = layoutState2.f2829b;
            int i10 = layoutState2.f2831d;
            int i11 = layoutState2.f2830c;
            if (i11 > 0) {
                endPadding += i11;
            }
            a(this.E);
            LayoutState layoutState3 = this.t;
            layoutState3.f2835h = endPadding;
            layoutState3.f2831d += layoutState3.f2832e;
            a(recycler, layoutState3, state, false);
            LayoutState layoutState4 = this.t;
            i2 = layoutState4.f2829b;
            int i12 = layoutState4.f2830c;
            if (i12 > 0) {
                e(i10, i3);
                LayoutState layoutState5 = this.t;
                layoutState5.f2835h = i12;
                a(recycler, layoutState5, state, false);
                i3 = this.t.f2829b;
            }
        } else {
            a(anchorInfo2);
            LayoutState layoutState6 = this.t;
            layoutState6.f2835h = endPadding;
            a(recycler, layoutState6, state, false);
            LayoutState layoutState7 = this.t;
            i2 = layoutState7.f2829b;
            int i13 = layoutState7.f2831d;
            int i14 = layoutState7.f2830c;
            if (i14 > 0) {
                startAfterPadding += i14;
            }
            b(this.E);
            LayoutState layoutState8 = this.t;
            layoutState8.f2835h = startAfterPadding;
            layoutState8.f2831d += layoutState8.f2832e;
            a(recycler, layoutState8, state, false);
            LayoutState layoutState9 = this.t;
            i3 = layoutState9.f2829b;
            int i15 = layoutState9.f2830c;
            if (i15 > 0) {
                d(i13, i2);
                LayoutState layoutState10 = this.t;
                layoutState10.f2835h = i15;
                a(recycler, layoutState10, state, false);
                i2 = this.t.f2829b;
            }
        }
        if (getChildCount() > 0) {
            if (this.x ^ this.y) {
                int a4 = a(i2, recycler, state, true);
                i4 = i3 + a4;
                i5 = i2 + a4;
                a2 = b(i4, recycler, state, false);
            } else {
                int b2 = b(i3, recycler, state, true);
                i4 = i3 + b2;
                i5 = i2 + b2;
                a2 = a(i5, recycler, state, false);
            }
            i3 = i4 + a2;
            i2 = i5 + a2;
        }
        a(recycler, state, i3, i2);
        if (!state.isPreLayout()) {
            this.u.onLayoutComplete();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.D;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            e();
            boolean z = this.v ^ this.x;
            savedState2.f2838c = z;
            if (z) {
                View h2 = h();
                savedState2.f2837b = this.u.getEndAfterPadding() - this.u.getDecoratedEnd(h2);
                savedState2.f2836a = getPosition(h2);
            } else {
                View i = i();
                savedState2.f2836a = getPosition(i);
                savedState2.f2837b = this.u.getDecoratedStart(i) - this.u.getStartAfterPadding();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        e();
        j();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.x) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.u.getEndAfterPadding() - (this.u.getDecoratedStart(view2) + this.u.getDecoratedMeasurement(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.u.getEndAfterPadding() - this.u.getDecoratedEnd(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.u.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.u.getDecoratedEnd(view2) - this.u.getDecoratedMeasurement(view));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 1) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.A = i;
        this.B = i2;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 0) {
            return 0;
        }
        return a(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.G = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.s || this.u == null) {
            this.u = OrientationHelper.createOrientationHelper(this, i);
            this.E.f2823a = this.u;
            this.s = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.C = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.z = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.D == null && this.v == this.y;
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        setOrientation(i);
        setReverseLayout(z);
    }

    private View f(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.x ? c(recycler, state) : a(recycler, state);
    }

    private View h(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.x ? d(recycler, state) : b(recycler, state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnchorInfo {

        /* renamed from: a, reason: collision with root package name */
        OrientationHelper f2823a;

        /* renamed from: b, reason: collision with root package name */
        int f2824b;

        /* renamed from: c, reason: collision with root package name */
        int f2825c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2826d;

        /* renamed from: e, reason: collision with root package name */
        boolean f2827e;

        AnchorInfo() {
            b();
        }

        void a() {
            int startAfterPadding;
            if (this.f2826d) {
                startAfterPadding = this.f2823a.getEndAfterPadding();
            } else {
                startAfterPadding = this.f2823a.getStartAfterPadding();
            }
            this.f2825c = startAfterPadding;
        }

        public void assignFromView(View view, int i) {
            if (this.f2826d) {
                this.f2825c = this.f2823a.getDecoratedEnd(view) + this.f2823a.getTotalSpaceChange();
            } else {
                this.f2825c = this.f2823a.getDecoratedStart(view);
            }
            this.f2824b = i;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i) {
            int totalSpaceChange = this.f2823a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i);
                return;
            }
            this.f2824b = i;
            if (this.f2826d) {
                int endAfterPadding = (this.f2823a.getEndAfterPadding() - totalSpaceChange) - this.f2823a.getDecoratedEnd(view);
                this.f2825c = this.f2823a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.f2825c - this.f2823a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.f2823a.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.f2823a.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.f2825c += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.f2823a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.f2823a.getStartAfterPadding();
            this.f2825c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.f2823a.getEndAfterPadding() - Math.min(0, (this.f2823a.getEndAfterPadding() - totalSpaceChange) - this.f2823a.getDecoratedEnd(view))) - (decoratedStart + this.f2823a.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.f2825c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        void b() {
            this.f2824b = -1;
            this.f2825c = Integer.MIN_VALUE;
            this.f2826d = false;
            this.f2827e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2824b + ", mCoordinate=" + this.f2825c + ", mLayoutFromEnd=" + this.f2826d + ", mValid=" + this.f2827e + '}';
        }

        boolean a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        if (!state.willRunPredictiveAnimations() || getChildCount() == 0 || state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
        int size = scrapList.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.ViewHolder viewHolder = scrapList.get(i5);
            if (!viewHolder.i()) {
                if (((viewHolder.getLayoutPosition() < position) != this.x ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.u.getDecoratedMeasurement(viewHolder.itemView);
                } else {
                    i4 += this.u.getDecoratedMeasurement(viewHolder.itemView);
                }
            }
        }
        this.t.k = scrapList;
        if (i3 > 0) {
            e(getPosition(i()), i);
            LayoutState layoutState = this.t;
            layoutState.f2835h = i3;
            layoutState.f2830c = 0;
            layoutState.assignPositionFromScrapList();
            a(recycler, this.t, state, false);
        }
        if (i4 > 0) {
            d(getPosition(h()), i2);
            LayoutState layoutState2 = this.t;
            layoutState2.f2835h = i4;
            layoutState2.f2830c = 0;
            layoutState2.assignPositionFromScrapList();
            a(recycler, this.t, state, false);
        }
        this.t.k = null;
    }

    private View g(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.x ? b(recycler, state) : d(recycler, state);
    }

    private int b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.u.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -a(startAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.u.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.u.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    private View c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return c(getChildCount() - 1, -1);
    }

    LayoutState d() {
        return new LayoutState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.t == null) {
            this.t = d();
        }
    }

    private int d(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.b(state, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    View c(int i, int i2) {
        int i3;
        int i4;
        e();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.u.getDecoratedStart(getChildAt(i)) < this.u.getStartAfterPadding()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.s == 0) {
            return this.f2907e.a(i, i2, i3, i4);
        }
        return this.f2908f.a(i, i2, i3, i4);
    }

    private void b(AnchorInfo anchorInfo) {
        e(anchorInfo.f2824b, anchorInfo.f2825c);
    }

    private View e(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.x ? a(recycler, state) : c(recycler, state);
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.a(state, this.u, b(!this.z, true), a(!this.z, true), this, this.z);
    }

    private View d(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        if (i < 0) {
            return;
        }
        int childCount = getChildCount();
        if (!this.x) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (this.u.getDecoratedEnd(childAt) > i || this.u.getTransformedEndWithDecoration(childAt) > i) {
                    a(recycler, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            if (this.u.getDecoratedEnd(childAt2) > i || this.u.getTransformedEndWithDecoration(childAt2) > i) {
                a(recycler, i3, i4);
                return;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    boolean b() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !a()) ? false : true;
    }

    private boolean a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View h2;
        int startAfterPadding;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.a(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.v != this.y) {
            return false;
        }
        if (anchorInfo.f2826d) {
            h2 = g(recycler, state);
        } else {
            h2 = h(recycler, state);
        }
        if (h2 == null) {
            return false;
        }
        anchorInfo.assignFromView(h2, getPosition(h2));
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.u.getDecoratedStart(h2) >= this.u.getEndAfterPadding() || this.u.getDecoratedEnd(h2) < this.u.getStartAfterPadding()) {
                if (anchorInfo.f2826d) {
                    startAfterPadding = this.u.getEndAfterPadding();
                } else {
                    startAfterPadding = this.u.getStartAfterPadding();
                }
                anchorInfo.f2825c = startAfterPadding;
            }
        }
        return true;
    }

    private View b(boolean z, boolean z2) {
        if (this.x) {
            return a(getChildCount() - 1, -1, z, z2);
        }
        return a(0, getChildCount(), z, z2);
    }

    private View b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private boolean a(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        int decoratedStart;
        if (!state.isPreLayout() && (i = this.A) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                anchorInfo.f2824b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    anchorInfo.f2826d = this.D.f2838c;
                    if (anchorInfo.f2826d) {
                        anchorInfo.f2825c = this.u.getEndAfterPadding() - this.D.f2837b;
                    } else {
                        anchorInfo.f2825c = this.u.getStartAfterPadding() + this.D.f2837b;
                    }
                    return true;
                }
                if (this.B == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.A);
                    if (findViewByPosition != null) {
                        if (this.u.getDecoratedMeasurement(findViewByPosition) > this.u.getTotalSpace()) {
                            anchorInfo.a();
                            return true;
                        }
                        if (this.u.getDecoratedStart(findViewByPosition) - this.u.getStartAfterPadding() < 0) {
                            anchorInfo.f2825c = this.u.getStartAfterPadding();
                            anchorInfo.f2826d = false;
                            return true;
                        }
                        if (this.u.getEndAfterPadding() - this.u.getDecoratedEnd(findViewByPosition) < 0) {
                            anchorInfo.f2825c = this.u.getEndAfterPadding();
                            anchorInfo.f2826d = true;
                            return true;
                        }
                        if (anchorInfo.f2826d) {
                            decoratedStart = this.u.getDecoratedEnd(findViewByPosition) + this.u.getTotalSpaceChange();
                        } else {
                            decoratedStart = this.u.getDecoratedStart(findViewByPosition);
                        }
                        anchorInfo.f2825c = decoratedStart;
                    } else {
                        if (getChildCount() > 0) {
                            anchorInfo.f2826d = (this.A < getPosition(getChildAt(0))) == this.x;
                        }
                        anchorInfo.a();
                    }
                    return true;
                }
                boolean z = this.x;
                anchorInfo.f2826d = z;
                if (z) {
                    anchorInfo.f2825c = this.u.getEndAfterPadding() - this.B;
                } else {
                    anchorInfo.f2825c = this.u.getStartAfterPadding() + this.B;
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.u.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -a(-endAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.u.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.u.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    private void a(AnchorInfo anchorInfo) {
        d(anchorInfo.f2824b, anchorInfo.f2825c);
    }

    private void a(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        this.t.l = g();
        this.t.f2835h = a(state);
        LayoutState layoutState = this.t;
        layoutState.f2833f = i;
        if (i == 1) {
            layoutState.f2835h += this.u.getEndPadding();
            View h2 = h();
            this.t.f2832e = this.x ? -1 : 1;
            LayoutState layoutState2 = this.t;
            int position = getPosition(h2);
            LayoutState layoutState3 = this.t;
            layoutState2.f2831d = position + layoutState3.f2832e;
            layoutState3.f2829b = this.u.getDecoratedEnd(h2);
            startAfterPadding = this.u.getDecoratedEnd(h2) - this.u.getEndAfterPadding();
        } else {
            View i3 = i();
            this.t.f2835h += this.u.getStartAfterPadding();
            this.t.f2832e = this.x ? 1 : -1;
            LayoutState layoutState4 = this.t;
            int position2 = getPosition(i3);
            LayoutState layoutState5 = this.t;
            layoutState4.f2831d = position2 + layoutState5.f2832e;
            layoutState5.f2829b = this.u.getDecoratedStart(i3);
            startAfterPadding = (-this.u.getDecoratedStart(i3)) + this.u.getStartAfterPadding();
        }
        LayoutState layoutState6 = this.t;
        layoutState6.f2830c = i2;
        if (z) {
            layoutState6.f2830c -= startAfterPadding;
        }
        this.t.f2834g = startAfterPadding;
    }

    void a(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.f2831d;
        if (i < 0 || i >= state.getItemCount()) {
            return;
        }
        layoutPrefetchRegistry.addPosition(i, Math.max(0, layoutState.f2834g));
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.t.f2828a = true;
        e();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        LayoutState layoutState = this.t;
        int a2 = layoutState.f2834g + a(recycler, layoutState, state, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.u.offsetChildren(-i);
        this.t.j = i;
        return i;
    }

    private void a(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, recycler);
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int end = this.u.getEnd() - i;
        if (this.x) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (this.u.getDecoratedStart(childAt) < end || this.u.getTransformedStartWithDecoration(childAt) < end) {
                    a(recycler, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            if (this.u.getDecoratedStart(childAt2) < end || this.u.getTransformedStartWithDecoration(childAt2) < end) {
                a(recycler, i3, i4);
                return;
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f2828a || layoutState.l) {
            return;
        }
        if (layoutState.f2833f == -1) {
            a(recycler, layoutState.f2834g);
        } else {
            b(recycler, layoutState.f2834g);
        }
    }

    int a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i = layoutState.f2830c;
        int i2 = layoutState.f2834g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                layoutState.f2834g = i2 + i;
            }
            a(recycler, layoutState);
        }
        int i3 = layoutState.f2830c + layoutState.f2835h;
        LayoutChunkResult layoutChunkResult = this.F;
        while (true) {
            if ((!layoutState.l && i3 <= 0) || !layoutState.a(state)) {
                break;
            }
            layoutChunkResult.a();
            a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.f2829b += layoutChunkResult.mConsumed * layoutState.f2833f;
                if (!layoutChunkResult.mIgnoreConsumed || this.t.k != null || !state.isPreLayout()) {
                    int i4 = layoutState.f2830c;
                    int i5 = layoutChunkResult.mConsumed;
                    layoutState.f2830c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = layoutState.f2834g;
                if (i6 != Integer.MIN_VALUE) {
                    layoutState.f2834g = i6 + layoutChunkResult.mConsumed;
                    int i7 = layoutState.f2830c;
                    if (i7 < 0) {
                        layoutState.f2834g += i7;
                    }
                    a(recycler, layoutState);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.f2830c;
    }

    void a(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int decoratedMeasurementInOther;
        View a2 = layoutState.a(recycler);
        if (a2 == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (layoutState.k == null) {
            if (this.x == (layoutState.f2833f == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.x == (layoutState.f2833f == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        layoutChunkResult.mConsumed = this.u.getDecoratedMeasurement(a2);
        if (this.s == 1) {
            if (f()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                i4 = decoratedMeasurementInOther - this.u.getDecoratedMeasurementInOther(a2);
            } else {
                i4 = getPaddingLeft();
                decoratedMeasurementInOther = this.u.getDecoratedMeasurementInOther(a2) + i4;
            }
            if (layoutState.f2833f == -1) {
                int i5 = layoutState.f2829b;
                i3 = i5;
                i2 = decoratedMeasurementInOther;
                i = i5 - layoutChunkResult.mConsumed;
            } else {
                int i6 = layoutState.f2829b;
                i = i6;
                i2 = decoratedMeasurementInOther;
                i3 = layoutChunkResult.mConsumed + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.u.getDecoratedMeasurementInOther(a2) + paddingTop;
            if (layoutState.f2833f == -1) {
                int i7 = layoutState.f2829b;
                i2 = i7;
                i = paddingTop;
                i3 = decoratedMeasurementInOther2;
                i4 = i7 - layoutChunkResult.mConsumed;
            } else {
                int i8 = layoutState.f2829b;
                i = paddingTop;
                i2 = layoutChunkResult.mConsumed + i8;
                i3 = decoratedMeasurementInOther2;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(a2, i4, i, i2, i3);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = a2.hasFocusable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && f()) ? -1 : 1 : (this.s != 1 && f()) ? 1 : -1;
    }

    private View a(boolean z, boolean z2) {
        if (this.x) {
            return a(0, getChildCount(), z, z2);
        }
        return a(getChildCount() - 1, -1, z, z2);
    }

    View a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        e();
        int startAfterPadding = this.u.getStartAfterPadding();
        int endAfterPadding = this.u.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.u.getDecoratedStart(childAt) < endAfterPadding && this.u.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return c(0, getChildCount());
    }

    View a(int i, int i2, boolean z, boolean z2) {
        e();
        int i3 = ModuleDescriptor.MODULE_VERSION;
        int i4 = z ? 24579 : ModuleDescriptor.MODULE_VERSION;
        if (!z2) {
            i3 = 0;
        }
        if (this.s == 0) {
            return this.f2907e.a(i, i2, i4, i3);
        }
        return this.f2908f.a(i, i2, i4, i3);
    }
}
