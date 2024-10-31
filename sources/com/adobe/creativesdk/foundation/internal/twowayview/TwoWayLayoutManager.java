package com.adobe.creativesdk.foundation.internal.twowayview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.a.a.b.j;
import java.util.List;

/* loaded from: classes.dex */
public abstract class TwoWayLayoutManager extends RecyclerView.LayoutManager {
    private RecyclerView s;
    private boolean t;
    private a u;
    private int v;
    private int w;
    private int x;
    private int y;

    /* loaded from: classes.dex */
    public enum Direction {
        START,
        END
    }

    /* loaded from: classes.dex */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes.dex */
    public static class a implements Parcelable {

        /* renamed from: b */
        private final Parcelable f6811b;

        /* renamed from: c */
        private int f6812c;

        /* renamed from: d */
        private Bundle f6813d;

        /* renamed from: a */
        protected static final a f6810a = new a();
        public static final Parcelable.Creator<a> CREATOR = new e();

        private a() {
            this.f6811b = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6812c);
            parcel.writeParcelable(this.f6813d, i);
        }

        public a(Parcelable parcelable) {
            if (parcelable != null) {
                this.f6811b = parcelable == f6810a ? null : parcelable;
                return;
            }
            throw new IllegalArgumentException("superState must not be null");
        }

        public Parcelable a() {
            return this.f6811b;
        }

        public a(Parcel parcel) {
            this.f6811b = f6810a;
            this.f6812c = parcel.readInt();
            this.f6813d = (Bundle) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public TwoWayLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Direction direction, RecyclerView.Recycler recycler) {
        if (direction == Direction.END) {
            b(direction, recycler);
        } else {
            a(direction, recycler);
        }
    }

    private int e(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int min;
        int childCount = getChildCount();
        if (childCount != 0 && i != 0) {
            int i2 = i();
            int d2 = d();
            int e2 = e();
            int l = l();
            if (i < 0) {
                min = Math.max(-(l - 1), i);
            } else {
                min = Math.min(l - 1, i);
            }
            boolean z = e2 == 0 && this.x >= i2 && min <= 0;
            if (!(e2 + childCount == state.getItemCount() && this.y <= d2 && min >= 0) && !z) {
                b(-min);
                Direction direction = min > 0 ? Direction.END : Direction.START;
                c(direction, recycler);
                int abs = Math.abs(min);
                if (a(Direction.START, i2 - abs) || a(Direction.END, d2 + abs)) {
                    a(direction, recycler, state);
                }
                return min;
            }
        }
        return 0;
    }

    private void j() {
        if (getChildCount() == 0) {
            return;
        }
        int i = this.x - i();
        if (i < 0) {
            i = 0;
        }
        if (i != 0) {
            b(-i);
        }
    }

    private Bundle k() {
        a aVar = this.u;
        if (aVar != null) {
            return aVar.f6813d;
        }
        return null;
    }

    private int l() {
        int width;
        int paddingLeft;
        if (this.t) {
            width = getHeight() - getPaddingBottom();
            paddingLeft = getPaddingTop();
        } else {
            width = getWidth() - getPaddingRight();
            paddingLeft = getPaddingLeft();
        }
        return width - paddingLeft;
    }

    private void m() {
        int e2 = e();
        View findViewByPosition = findViewByPosition(e2);
        if (findViewByPosition != null) {
            c(e2, b(findViewByPosition));
        } else {
            c(-1, 0);
        }
    }

    private void n() {
        this.x = i();
        this.y = this.x;
    }

    protected void a(View view, Direction direction) {
    }

    protected abstract boolean a(Direction direction, int i);

    public int b(View view) {
        return this.t ? getDecoratedTop(view) : getDecoratedLeft(view);
    }

    protected abstract void b(View view, Direction direction);

    protected abstract void c(View view, Direction direction);

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !this.t;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.t;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return getChildCount();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return e();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return state.getItemCount();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return getChildCount();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return e();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return state.getItemCount();
    }

    protected int d() {
        int width;
        int paddingRight;
        if (this.t) {
            width = getHeight();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth();
            paddingRight = getPaddingRight();
        }
        return width - paddingRight;
    }

    public int f() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int g() {
        if (this.u != null) {
            return 0;
        }
        return this.w;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.t) {
            return new RecyclerView.LayoutParams(-1, -2);
        }
        return new RecyclerView.LayoutParams(-2, -1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedMeasuredHeight(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return super.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedMeasuredWidth(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return super.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public Orientation getOrientation() {
        return this.t ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    public int h() {
        a aVar = this.u;
        if (aVar != null) {
            return aVar.f6812c;
        }
        return this.v;
    }

    protected int i() {
        return this.t ? getPaddingTop() : getPaddingLeft();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        super.layoutDecorated(view, i + marginLayoutParams.leftMargin, i2 + marginLayoutParams.topMargin, i3 - marginLayoutParams.rightMargin, i4 - marginLayoutParams.bottomMargin);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        super.onAdapterChanged(adapter, adapter2);
        ItemSelectionSupport a2 = ItemSelectionSupport.a(this.s);
        if (adapter == null || a2 == null) {
            return;
        }
        a2.a();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.s = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.s = null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        m();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        m();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        ItemSelectionSupport a2 = ItemSelectionSupport.a(this.s);
        if (a2 != null) {
            Bundle k = k();
            if (k != null) {
                a2.a(k);
            }
            if (state.didStructureChange()) {
                a2.b();
            }
        }
        int a3 = a(state);
        detachAndScrapAttachedViews(recycler);
        d(a3, recycler, state);
        a(recycler, state);
        c(-1, 0);
        this.u = null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        super.onMeasure(recycler, state, i, i2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.u = (a) parcelable;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        a aVar = new a(a.f6810a);
        int h2 = h();
        if (h2 == -1) {
            h2 = e();
        }
        aVar.f6812c = h2;
        ItemSelectionSupport a2 = ItemSelectionSupport.a(this.s);
        if (a2 != null) {
            aVar.f6813d = a2.c();
        } else {
            aVar.f6813d = Bundle.EMPTY;
        }
        return aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.t) {
            return 0;
        }
        return e(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        scrollToPositionWithOffset(i, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        c(i, i2);
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.t) {
            return e(i, recycler, state);
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        d dVar = new d(this, recyclerView.getContext());
        dVar.setTargetPosition(i);
        startSmoothScroll(dVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public TwoWayLayoutManager(Context context, AttributeSet attributeSet, int i) {
        int i2;
        this.t = true;
        this.u = null;
        this.v = -1;
        this.w = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.adobe_csdk_twowayview_TwoWayLayoutManager, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == j.adobe_csdk_twowayview_TwoWayLayoutManager_android_orientation && (i2 = obtainStyledAttributes.getInt(index, -1)) >= 0) {
                a(Orientation.values()[i2]);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void b(int i) {
        if (this.t) {
            offsetChildrenVertical(i);
        } else {
            offsetChildrenHorizontal(i);
        }
        this.x += i;
        this.y += i;
    }

    protected int a(View view) {
        return this.t ? getDecoratedBottom(view) : getDecoratedRight(view);
    }

    private void a(Direction direction, RecyclerView.Recycler recycler) {
        int d2 = d();
        int i = 0;
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (b(childAt) <= d2) {
                break;
            }
            i++;
            a(childAt, direction);
            i2 = childCount;
        }
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            View childAt2 = getChildAt(i2);
            removeAndRecycleViewAt(i2, recycler);
            e(childAt2, direction);
        }
    }

    private void c(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        a(i, recycler, state, 0);
    }

    private void d(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            return;
        }
        a(i, Direction.END, recycler);
        int b2 = b(state);
        int i2 = 0;
        if (state.getTargetScrollPosition() >= i) {
            i2 = b2;
            b2 = 0;
        }
        a(i - 1, recycler, b2);
        j();
        a(i + 1, recycler, state, i2);
        a(getChildCount(), recycler, state);
    }

    private void c(View view) {
        int b2 = b(view);
        if (b2 < this.x) {
            this.x = b2;
        }
        int a2 = a(view);
        if (a2 > this.y) {
            this.y = a2;
        }
    }

    private void b(Direction direction, RecyclerView.Recycler recycler) {
        int childCount = getChildCount();
        int i = i();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (a(childAt) >= i) {
                break;
            }
            i2++;
            a(childAt, direction);
        }
        while (true) {
            i2--;
            if (i2 < 0) {
                return;
            }
            View childAt2 = getChildAt(0);
            removeAndRecycleView(childAt2, recycler);
            e(childAt2, direction);
        }
    }

    private void a(Direction direction, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int childCount = getChildCount();
        int b2 = b(state);
        int e2 = e();
        if (direction == Direction.END) {
            a(e2 + childCount, recycler, state, b2);
            a(childCount, recycler, state);
        } else {
            a(e2 - 1, recycler, b2);
            b(childCount, recycler, state);
        }
    }

    public void c(int i, int i2) {
        this.v = i;
        this.w = i2;
    }

    private void d(View view, Direction direction) {
        ItemSelectionSupport a2 = ItemSelectionSupport.a(this.s);
        if (a2 != null) {
            a2.a(view, a2.a(getPosition(view)));
        }
        c(view, direction);
        b(view, direction);
    }

    public TwoWayLayoutManager(Orientation orientation) {
        this.t = true;
        this.u = null;
        this.v = -1;
        this.w = 0;
        this.t = orientation == Orientation.VERTICAL;
    }

    private void b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (e() != 0 || i == 0) {
            return;
        }
        int i2 = i();
        int d2 = d();
        int itemCount = state.getItemCount();
        int f2 = f();
        int i3 = this.x - i2;
        if (i3 > 0) {
            int i4 = itemCount - 1;
            if (f2 >= i4 && this.y <= d2) {
                if (f2 == i4) {
                    j();
                    return;
                }
                return;
            }
            if (f2 == i4) {
                i3 = Math.min(i3, this.y - d2);
            }
            b(-i3);
            if (f2 < i4) {
                c(f2 + 1, recycler, state);
                j();
            }
        }
    }

    private void e(View view, Direction direction) {
        int i;
        int childCount = getChildCount();
        if (childCount == 0) {
            n();
            return;
        }
        int b2 = b(view);
        int a2 = a(view);
        if (b2 <= this.x || a2 >= this.y) {
            if (direction == Direction.END) {
                this.x = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                b2 = a2;
                i = 0;
            } else {
                this.y = Integer.MIN_VALUE;
                i = childCount - 1;
            }
            while (i >= 0 && i <= childCount - 1) {
                View childAt = getChildAt(i);
                if (direction == Direction.END) {
                    int b3 = b(childAt);
                    if (b3 < this.x) {
                        this.x = b3;
                    }
                    if (b3 >= b2) {
                        return;
                    } else {
                        i++;
                    }
                } else {
                    int a3 = a(childAt);
                    if (a3 > this.y) {
                        this.y = a3;
                    }
                    if (a3 <= b2) {
                        return;
                    } else {
                        i--;
                    }
                }
            }
        }
    }

    private void a(int i, RecyclerView.Recycler recycler) {
        a(i, recycler, 0);
    }

    private void a(int i, RecyclerView.Recycler recycler, int i2) {
        int i3 = i() - i2;
        while (a(Direction.START, i3) && i >= 0) {
            a(i, Direction.START, recycler);
            i--;
        }
    }

    private void a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        int d2 = d() + i2;
        int itemCount = state.getItemCount();
        while (a(Direction.END, d2) && i < itemCount) {
            a(i, Direction.END, recycler);
            i++;
        }
    }

    private void a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (f() != state.getItemCount() - 1 || i == 0) {
            return;
        }
        int i2 = i();
        int d2 = d();
        int e2 = e();
        int i3 = d2 - this.y;
        if (i3 > 0) {
            if (e2 > 0 || this.x < i2) {
                if (e2 == 0) {
                    i3 = Math.min(i3, i2 - this.x);
                }
                b(i3);
                if (e2 > 0) {
                    a(e2 - 1, recycler);
                    j();
                }
            }
        }
    }

    protected int b(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return l();
        }
        return 0;
    }

    public int e() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private static View a(List<RecyclerView.ViewHolder> list, Direction direction, int i) {
        int abs;
        int size = list.size();
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        RecyclerView.ViewHolder viewHolder = null;
        while (true) {
            if (i3 >= size) {
                break;
            }
            RecyclerView.ViewHolder viewHolder2 = list.get(i3);
            int position = viewHolder2.getPosition() - i;
            if ((position >= 0 || direction != Direction.END) && ((position <= 0 || direction != Direction.START) && (abs = Math.abs(position)) < i2)) {
                if (position == 0) {
                    viewHolder = viewHolder2;
                    break;
                }
                viewHolder = viewHolder2;
                i2 = abs;
            }
            i3++;
        }
        if (viewHolder != null) {
            return viewHolder.itemView;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:4:0x000d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001d -> B:4:0x000d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.List<android.support.v7.widget.RecyclerView.ViewHolder> r4, com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager.Direction r5) {
        /*
            r3 = this;
            int r0 = r3.e()
            com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager$Direction r1 = com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager.Direction.END
            r2 = 1
            if (r5 != r1) goto Lf
            int r1 = r3.getChildCount()
        Ld:
            int r0 = r0 + r1
            goto L10
        Lf:
            int r0 = r0 - r2
        L10:
            android.view.View r1 = a(r4, r5, r0)
            if (r1 == 0) goto L21
            r3.d(r1, r5)
            com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager$Direction r1 = com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager.Direction.END
            if (r5 != r1) goto L1f
            r1 = 1
            goto Ld
        L1f:
            r1 = -1
            goto Ld
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager.a(java.util.List, com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager$Direction):void");
    }

    private View a(int i, Direction direction, RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(i);
        boolean isItemRemoved = ((RecyclerView.LayoutParams) viewForPosition.getLayoutParams()).isItemRemoved();
        if (!isItemRemoved) {
            addView(viewForPosition, direction == Direction.END ? -1 : 0);
        }
        d(viewForPosition, direction);
        if (!isItemRemoved) {
            c(viewForPosition);
        }
        return viewForPosition;
    }

    public int a(RecyclerView.State state) {
        int itemCount = state.getItemCount();
        int h2 = h();
        if (h2 != -1 && (h2 < 0 || h2 >= itemCount)) {
            h2 = -1;
        }
        if (h2 != -1) {
            return h2;
        }
        if (getChildCount() > 0) {
            return a(itemCount);
        }
        return 0;
    }

    private int a(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    public void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
        a(scrapList, Direction.START);
        a(scrapList, Direction.END);
    }

    public void a(Orientation orientation) {
        boolean z = orientation == Orientation.VERTICAL;
        if (this.t == z) {
            return;
        }
        this.t = z;
        requestLayout();
    }
}
