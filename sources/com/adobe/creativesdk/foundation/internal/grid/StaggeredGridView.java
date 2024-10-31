package com.adobe.creativesdk.foundation.internal.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.adobe.creativesdk.foundation.internal.grid.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public class StaggeredGridView extends e {
    private int L;
    private int M;
    private int N;
    private boolean O;
    private int P;
    private int Q;
    private SparseArray<a> R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int[] W;
    private int[] aa;
    private int[] ba;
    private int ca;

    /* loaded from: classes.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new i();

        /* renamed from: a */
        int f5011a;

        /* renamed from: b */
        double f5012b;

        /* renamed from: c */
        boolean f5013c;

        public /* synthetic */ a(Parcel parcel, h hVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "GridItemRecord.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " column:" + this.f5011a + " heightRatio:" + this.f5012b + " isHeaderFooter:" + this.f5013c + "}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5011a);
            parcel.writeDouble(this.f5012b);
            parcel.writeByte(this.f5013c ? (byte) 1 : (byte) 0);
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a(Parcel parcel) {
            this.f5011a = parcel.readInt();
            this.f5012b = parcel.readDouble();
            this.f5013c = parcel.readByte() == 1;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e.C0025e {
        public static final Parcelable.Creator<c> CREATOR = new j();
        int i;
        int[] j;
        SparseArray k;

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.adobe.creativesdk.foundation.internal.grid.e.C0025e
        public String toString() {
            return "StaggeredGridView.GridListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }

        @Override // com.adobe.creativesdk.foundation.internal.grid.e.C0025e, com.adobe.creativesdk.foundation.internal.grid.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.i);
            parcel.writeIntArray(this.j);
            parcel.writeSparseArray(this.k);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.i = parcel.readInt();
            int i = this.i;
            this.j = new int[i < 0 ? 0 : i];
            parcel.readIntArray(this.j);
            this.k = parcel.readSparseArray(a.class.getClassLoader());
        }
    }

    public StaggeredGridView(Context context) {
        this(context, null);
    }

    private void b(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        int highestPositionedTop;
        int c2;
        if (z) {
            c2 = getLowestPositionedBottom();
            highestPositionedTop = c(view) + c2;
        } else {
            highestPositionedTop = getHighestPositionedTop();
            c2 = highestPositionedTop - c(view);
        }
        int i6 = c2;
        int i7 = highestPositionedTop;
        for (int i8 = 0; i8 < this.L; i8++) {
            k(i8, i6);
            j(i8, i7);
        }
        super.a(view, i, z, i2, i6, i4, i7);
    }

    private void c(View view, int i, boolean z, int i2, int i3) {
        int t;
        int c2;
        int r = r(i);
        int p = p(i);
        int childBottomMargin = getChildBottomMargin() + p;
        if (z) {
            c2 = s(r);
            t = c(view) + childBottomMargin + c2;
        } else {
            t = t(r);
            c2 = t - (c(view) + childBottomMargin);
        }
        ((b) view.getLayoutParams()).f5014e = r;
        j(r, t);
        k(r, c2);
        super.a(view, i, z, i2, c2 + p);
    }

    private void d(View view, int i, boolean z, int i2, int i3) {
        int highestPositionedTop;
        int c2;
        if (z) {
            c2 = getLowestPositionedBottom();
            highestPositionedTop = c(view) + c2;
        } else {
            highestPositionedTop = getHighestPositionedTop();
            c2 = highestPositionedTop - c(view);
        }
        int i4 = c2;
        for (int i5 = 0; i5 < this.L; i5++) {
            k(i5, i4);
            j(i5, highestPositionedTop);
        }
        super.a(view, i, z, i2, i4);
    }

    private int getChildBottomMargin() {
        return this.M;
    }

    private int[] getHighestNonHeaderTops() {
        int[] iArr = new int[this.L];
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof b)) {
                    b bVar = (b) childAt.getLayoutParams();
                    if (bVar.f5037d != -2) {
                        int top = childAt.getTop();
                        int i2 = bVar.f5014e;
                        if (top < iArr[i2]) {
                            iArr[i2] = childAt.getTop();
                        }
                    }
                }
            }
        }
        return iArr;
    }

    private int getHighestPositionedBottom() {
        return this.aa[getHighestPositionedBottomColumn()];
    }

    private int getHighestPositionedBottomColumn() {
        int i = 0;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i3 = 0; i3 < getMinColumnCount(); i3++) {
            int i4 = this.aa[i3];
            if (Integer.MIN_VALUE != i4 && i4 < i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getHighestPositionedTop() {
        return this.W[getHighestPositionedTopColumn()];
    }

    private int getHighestPositionedTopColumn() {
        int i = 0;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i3 = 0; i3 < getMinColumnCount(); i3++) {
            int i4 = this.W[i3];
            if (Integer.MAX_VALUE != i4 && i4 < i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getLowestPositionedBottom() {
        return this.aa[getLowestPositionedBottomColumn()];
    }

    private int getLowestPositionedBottomColumn() {
        int i = 0;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < getMinColumnCount(); i3++) {
            int i4 = this.aa[i3];
            if (Integer.MIN_VALUE != i4 && i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getLowestPositionedTop() {
        return this.W[getLowestPositionedTopColumn()];
    }

    private int getLowestPositionedTopColumn() {
        int i = 0;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < getMinColumnCount(); i3++) {
            int i4 = this.W[i3];
            if (Integer.MAX_VALUE != i4 && i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private int getMinColumnCount() {
        return Math.min(getCount(), this.L);
    }

    private void h(int i, int i2) {
        q(i).f5011a = i2;
    }

    private void i(int i, int i2) {
        a q = q(i);
        double d2 = i2;
        double d3 = this.N;
        Double.isNaN(d2);
        Double.isNaN(d3);
        q.f5012b = d2 / d3;
    }

    private void j(int i, int i2) {
        int[] iArr = this.aa;
        if (i2 > iArr[i]) {
            iArr[i] = i2;
        }
    }

    private void k(int i, int i2) {
        int[] iArr = this.W;
        if (i2 < iArr[i]) {
            iArr[i] = i2;
        }
    }

    private int n(int i) {
        int rowPaddingLeft = getRowPaddingLeft();
        int i2 = this.M;
        return rowPaddingLeft + i2 + ((i2 + this.N) * i);
    }

    private void o() {
        if (this.p == getHeaderViewsCount()) {
            int[] highestNonHeaderTops = getHighestNonHeaderTops();
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            boolean z = true;
            int i2 = -1;
            for (int i3 = 0; i3 < highestNonHeaderTops.length; i3++) {
                if (z && i3 > 0 && highestNonHeaderTops[i3] != i) {
                    z = false;
                }
                if (highestNonHeaderTops[i3] < i) {
                    i = highestNonHeaderTops[i3];
                    i2 = i3;
                }
            }
            if (z) {
                return;
            }
            for (int i4 = 0; i4 < highestNonHeaderTops.length; i4++) {
                if (i4 != i2) {
                    c(i - highestNonHeaderTops[i4], i4);
                }
            }
            invalidate();
        }
    }

    private int p(int i) {
        if (i < getHeaderViewsCount() + this.L) {
            return this.M;
        }
        return 0;
    }

    private a q(int i) {
        a aVar = this.R.get(i, null);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.R.append(i, aVar2);
        return aVar2;
    }

    private int r(int i) {
        a aVar = this.R.get(i, null);
        if (aVar != null) {
            return aVar.f5011a;
        }
        return -1;
    }

    private int s(int i) {
        int i2 = this.aa[i];
        return Integer.MIN_VALUE != i2 ? i2 : getLowestPositionedBottom();
    }

    private void setPositionIsHeaderFooter(int i) {
        q(i).f5013c = true;
    }

    private int t(int i) {
        int i2 = this.W[i];
        return Integer.MAX_VALUE != i2 ? i2 : getHighestPositionedTop();
    }

    private void u() {
        if (!this.O) {
            Arrays.fill(this.aa, 0);
        } else {
            this.O = false;
        }
        System.arraycopy(this.W, 0, this.aa, 0, this.L);
    }

    private void v() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.requestLayout();
            }
        }
    }

    private void w(int i) {
        this.ca += i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(View view, e.d dVar) {
        int makeMeasureSpec;
        int i = dVar.f5037d;
        int i2 = dVar.f5035b;
        if (i != -2 && i != -1) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.N, 1073741824);
            if (((AbsListView.LayoutParams) dVar).height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((AbsListView.LayoutParams) dVar).height, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            }
            view.measure(makeMeasureSpec2, makeMeasureSpec);
        } else {
            super.a(view, dVar);
        }
        i(i2, c(view));
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int e(int i) {
        if (u(i)) {
            return super.e(i);
        }
        return getLowestPositionedTop();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void f(int i) {
        super.f(i);
        v(i);
        w(i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void g() {
        int i = this.L;
        if (i > 0) {
            if (this.W == null) {
                this.W = new int[i];
            }
            if (this.aa == null) {
                this.aa = new int[this.L];
            }
            s();
            this.R.clear();
            this.O = false;
            this.ca = 0;
            setSelection(0);
        }
    }

    public int getColumnWidth() {
        return this.N;
    }

    public int getDistanceToTop() {
        return this.ca;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int getFirstChildTop() {
        if (u(this.p)) {
            return super.getFirstChildTop();
        }
        return getLowestPositionedTop();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int getHighestChildTop() {
        if (u(this.p)) {
            return super.getHighestChildTop();
        }
        return getHighestPositionedTop();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int getLastChildBottom() {
        if (u(this.p + (getChildCount() - 1))) {
            return super.getLastChildBottom();
        }
        return getHighestPositionedBottom();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int getLowestChildBottom() {
        if (u(this.p + (getChildCount() - 1))) {
            return super.getLowestChildBottom();
        }
        return getLowestPositionedBottom();
    }

    public int getRowPaddingBottom() {
        return getListPaddingBottom() + this.V;
    }

    public int getRowPaddingLeft() {
        return getListPaddingLeft() + this.S;
    }

    public int getRowPaddingRight() {
        return getListPaddingRight() + this.T;
    }

    public int getRowPaddingTop() {
        return getListPaddingTop() + this.U;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e, android.widget.AbsListView
    public void layoutChildren() {
        u();
        super.layoutChildren();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.L <= 0) {
            this.L = getMeasuredWidth() > getMeasuredHeight() ? this.Q : this.P;
        }
        this.N = o(getMeasuredWidth());
        int[] iArr = this.W;
        if (iArr == null || iArr.length != this.L) {
            this.W = new int[this.L];
            r();
        }
        int[] iArr2 = this.aa;
        if (iArr2 == null || iArr2.length != this.L) {
            this.aa = new int[this.L];
            p();
        }
        int[] iArr3 = this.ba;
        if (iArr3 == null || iArr3.length != this.L) {
            this.ba = new int[this.L];
            q();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        c cVar = (c) parcelable;
        this.L = cVar.i;
        this.W = cVar.j;
        this.aa = new int[this.L];
        this.R = cVar.k;
        this.O = true;
        super.onRestoreInstanceState(cVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e, android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        e.C0025e c0025e = (e.C0025e) super.onSaveInstanceState();
        c cVar = new c(c0025e.a());
        cVar.f5038d = c0025e.f5038d;
        cVar.f5039e = c0025e.f5039e;
        cVar.f5040f = c0025e.f5040f;
        cVar.f5041g = c0025e.f5041g;
        cVar.f5042h = c0025e.f5042h;
        if ((getChildCount() > 0 && getCount() > 0) && this.p > 0) {
            cVar.i = this.L;
            cVar.j = this.W;
            cVar.k = this.R;
        } else {
            int i = this.L;
            if (i < 0) {
                i = 0;
            }
            cVar.i = i;
            cVar.j = new int[cVar.i];
            cVar.k = new SparseArray();
        }
        return cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b(i, i2);
    }

    public void setColumnCount(int i) {
        this.P = i;
        this.Q = i;
        b(getWidth(), getHeight());
        v();
    }

    public void setColumnCountLandscape(int i) {
        this.Q = i;
        b(getWidth(), getHeight());
        v();
    }

    public void setColumnCountPortrait(int i) {
        this.P = i;
        b(getWidth(), getHeight());
        v();
    }

    /* loaded from: classes.dex */
    public static class b extends e.d {

        /* renamed from: e */
        int f5014e;

        public b(int i, int i2) {
            super(i, i2);
            a();
        }

        private void a() {
            if (((AbsListView.LayoutParams) this).width != -1) {
                ((AbsListView.LayoutParams) this).width = -1;
            }
            if (((AbsListView.LayoutParams) this).height == -1) {
                ((AbsListView.LayoutParams) this).height = -2;
            }
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            a();
        }
    }

    public StaggeredGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StaggeredGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.P = 2;
        this.Q = 3;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.a.a.b.j.adobe_csdk_StaggeredGridView, i, 0);
            this.L = obtainStyledAttributes.getInteger(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_column_count, 0);
            int i2 = this.L;
            if (i2 > 0) {
                this.P = i2;
                this.Q = i2;
            } else {
                this.P = obtainStyledAttributes.getInteger(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_column_count_portrait, 2);
                this.Q = obtainStyledAttributes.getInteger(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_column_count_landscape, 3);
            }
            this.M = obtainStyledAttributes.getDimensionPixelSize(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_item_margin, 0);
            this.S = obtainStyledAttributes.getDimensionPixelSize(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_grid_paddingLeft, 0);
            this.T = obtainStyledAttributes.getDimensionPixelSize(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_grid_paddingRight, 0);
            this.U = obtainStyledAttributes.getDimensionPixelSize(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_grid_paddingTop, 0);
            this.V = obtainStyledAttributes.getDimensionPixelSize(c.a.a.a.b.j.adobe_csdk_StaggeredGridView_adobe_csdk_grid_paddingBottom, 0);
            obtainStyledAttributes.recycle();
        }
        this.L = 0;
        this.W = new int[0];
        this.aa = new int[0];
        this.ba = new int[0];
        this.R = new SparseArray<>();
    }

    private void p() {
        Arrays.fill(this.aa, getPaddingTop() + this.U);
    }

    private void r() {
        Arrays.fill(this.W, getPaddingTop() + this.U);
    }

    private void s() {
        r();
        p();
    }

    private void t() {
        int min = Math.min(this.F, getCount() - 1);
        SparseArray sparseArray = new SparseArray(min);
        for (int i = 0; i < min; i++) {
            a aVar = this.R.get(i);
            if (aVar == null) {
                break;
            }
            Log.d("StaggeredGridView", "onColumnSync:" + i + " ratio:" + aVar.f5012b);
            sparseArray.append(i, Double.valueOf(aVar.f5012b));
        }
        this.R.clear();
        for (int i2 = 0; i2 < min; i2++) {
            a q = q(i2);
            double doubleValue = ((Double) sparseArray.get(i2)).doubleValue();
            double d2 = this.N;
            Double.isNaN(d2);
            int i3 = (int) (d2 * doubleValue);
            q.f5012b = doubleValue;
            if (u(i2)) {
                int lowestPositionedBottom = getLowestPositionedBottom();
                int i4 = i3 + lowestPositionedBottom;
                for (int i5 = 0; i5 < this.L; i5++) {
                    this.W[i5] = lowestPositionedBottom;
                    this.aa[i5] = i4;
                }
            } else {
                int highestPositionedBottomColumn = getHighestPositionedBottomColumn();
                int i6 = this.aa[highestPositionedBottomColumn];
                int p = i3 + i6 + p(i2) + getChildBottomMargin();
                this.W[highestPositionedBottomColumn] = i6;
                this.aa[highestPositionedBottomColumn] = p;
                q.f5011a = highestPositionedBottomColumn;
            }
        }
        int highestPositionedBottomColumn2 = getHighestPositionedBottomColumn();
        h(min, highestPositionedBottomColumn2);
        int i7 = -this.aa[highestPositionedBottomColumn2];
        v(this.G + i7);
        this.ca = i7;
        System.arraycopy(this.aa, 0, this.W, 0, this.L);
    }

    private void q() {
        for (int i = 0; i < this.L; i++) {
            this.ba[i] = n(i);
        }
    }

    private void v(int i) {
        if (i != 0) {
            for (int i2 = 0; i2 < this.L; i2++) {
                g(i, i2);
            }
        }
    }

    private boolean u(int i) {
        return this.i.getItemViewType(i) == -2;
    }

    private void b(View view, int i, boolean z, int i2, int i3) {
        int t;
        int c2;
        int r = r(i);
        int p = p(i);
        int childBottomMargin = getChildBottomMargin();
        int i4 = p + childBottomMargin;
        if (z) {
            c2 = s(r);
            t = c(view) + i4 + c2;
        } else {
            t = t(r);
            c2 = t - (c(view) + i4);
        }
        ((b) view.getLayoutParams()).f5014e = r;
        j(r, t);
        k(r, c2);
        view.layout(i2, c2 + p, i3, t - childBottomMargin);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int d(int i) {
        if (u(i)) {
            return super.d(i);
        }
        return getHighestPositionedBottom();
    }

    private void g(int i, int i2) {
        if (i != 0) {
            int[] iArr = this.W;
            if (iArr[i2] != Integer.MAX_VALUE) {
                iArr[i2] = iArr[i2] + i;
            }
            int[] iArr2 = this.aa;
            if (iArr2[i2] != Integer.MIN_VALUE) {
                iArr2[i2] = iArr2[i2] + i;
            }
        }
    }

    private int o(int i) {
        int rowPaddingLeft = i - (getRowPaddingLeft() + getRowPaddingRight());
        int i2 = this.M;
        int i3 = this.L;
        return (rowPaddingLeft - (i2 * (i3 + 1))) / i3;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(int i, boolean z) {
        super.a(i, z);
        if (!u(i)) {
            h(i, b(i, z));
        } else {
            setPositionIsHeaderFooter(i);
        }
    }

    private int c(View view) {
        return view.getMeasuredHeight();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int c(int i) {
        if (u(i)) {
            return super.c(i);
        }
        int r = r(i);
        if (r == -1) {
            return getHighestPositionedBottom();
        }
        return this.aa[r];
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        if (u(i)) {
            b(view, i, z, i2, i3, i4, i5);
        } else {
            b(view, i, z, i2, i4);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(View view, int i, boolean z, int i2, int i3) {
        if (u(i)) {
            d(view, i, z, i2, i3);
        } else {
            c(view, i, z, i2, i3);
        }
    }

    protected void c(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof b) && ((b) childAt.getLayoutParams()).f5014e == i2) {
                childAt.offsetTopAndBottom(i);
            }
        }
        g(i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int b(int i) {
        if (u(i)) {
            return super.b(i);
        }
        return this.ba[r(i)];
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    protected e.d a(View view) {
        b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = null;
        } else if (layoutParams instanceof b) {
            bVar = (b) layoutParams;
        } else {
            bVar = new b(layoutParams);
        }
        return bVar == null ? new b(this.N, -2) : bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void b(int i, int i2) {
        super.b(i, i2);
        int i3 = i > i2 ? this.Q : this.P;
        if (this.L != i3) {
            this.L = i3;
            this.N = o(i);
            int i4 = this.L;
            this.W = new int[i4];
            this.aa = new int[i4];
            this.ba = new int[i4];
            this.ca = 0;
            s();
            q();
            if (getCount() > 0 && this.R.size() > 0) {
                t();
            }
            requestLayout();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public int a(int i) {
        if (u(i)) {
            return super.a(i);
        }
        int r = r(i);
        if (r == -1) {
            return getLowestPositionedTop();
        }
        return this.W[r];
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    protected boolean c() {
        return getLowestPositionedTop() > (this.A ? getRowPaddingTop() : 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(boolean z) {
        super.a(z);
        if (z) {
            return;
        }
        o();
    }

    @Override // com.adobe.creativesdk.foundation.internal.grid.e
    public void a(int i, int i2) {
        super.a(i, i2);
        Arrays.fill(this.W, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        Arrays.fill(this.aa, Integer.MIN_VALUE);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                e.d dVar = (e.d) childAt.getLayoutParams();
                if (dVar.f5037d != -2 && (dVar instanceof b)) {
                    b bVar = (b) dVar;
                    int i4 = bVar.f5014e;
                    int i5 = bVar.f5035b;
                    int top = childAt.getTop();
                    int[] iArr = this.W;
                    if (top < iArr[i4]) {
                        iArr[i4] = top - p(i5);
                    }
                    int bottom = childAt.getBottom();
                    int[] iArr2 = this.aa;
                    if (bottom > iArr2[i4]) {
                        iArr2[i4] = bottom + getChildBottomMargin();
                    }
                } else {
                    int top2 = childAt.getTop();
                    int bottom2 = childAt.getBottom();
                    for (int i6 = 0; i6 < this.L; i6++) {
                        int[] iArr3 = this.W;
                        if (top2 < iArr3[i6]) {
                            iArr3[i6] = top2;
                        }
                        int[] iArr4 = this.aa;
                        if (bottom2 > iArr4[i6]) {
                            iArr4[i6] = bottom2;
                        }
                    }
                }
            }
        }
    }

    private int b(int i, boolean z) {
        int r = r(i);
        int i2 = this.L;
        if (r >= 0 && r < i2) {
            return r;
        }
        if (z) {
            return getHighestPositionedBottomColumn();
        }
        return getLowestPositionedTopColumn();
    }
}
