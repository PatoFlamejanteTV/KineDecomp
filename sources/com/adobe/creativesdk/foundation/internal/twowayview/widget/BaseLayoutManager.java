package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.e;

/* loaded from: classes.dex */
public abstract class BaseLayoutManager extends AdobeCSDKBaseLayoutManager {
    private e B;
    private e C;
    private d D;
    private d E;
    protected final Rect F;
    protected final Rect G;
    protected final e.a H;

    /* loaded from: classes.dex */
    public enum UpdateOp {
        ADD,
        REMOVE,
        UPDATE,
        MOVE
    }

    /* loaded from: classes.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new com.adobe.creativesdk.foundation.internal.twowayview.widget.b();

        /* renamed from: a */
        public int f6814a;

        /* renamed from: b */
        public int f6815b;

        /* renamed from: c */
        private int[] f6816c;

        public a(int i, int i2) {
            this.f6814a = i;
            this.f6815b = i2;
        }

        public boolean b() {
            return this.f6816c != null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f6814a);
            parcel.writeInt(this.f6815b);
            int[] iArr = this.f6816c;
            int length = iArr != null ? iArr.length : 0;
            parcel.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                parcel.writeInt(this.f6816c[i2]);
            }
        }

        public a(Parcel parcel) {
            this.f6814a = parcel.readInt();
            this.f6815b = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.f6816c = new int[readInt];
                for (int i = 0; i < readInt; i++) {
                    this.f6816c[i] = parcel.readInt();
                }
            }
        }

        public void a(e.a aVar) {
            this.f6814a = aVar.f6841a;
            this.f6815b = aVar.f6842b;
        }

        public void a() {
            this.f6814a = -1;
            this.f6815b = -1;
            this.f6816c = null;
        }

        public int a(int i) {
            int[] iArr = this.f6816c;
            if (iArr == null) {
                return 0;
            }
            return iArr[i];
        }

        public void a(int i, int i2, int i3) {
            if (this.f6816c == null) {
                this.f6816c = new int[i3];
            }
            this.f6816c[i] = i2;
        }
    }

    /* loaded from: classes.dex */
    protected static class b extends TwoWayLayoutManager.a {
        public static final Parcelable.Creator<b> CREATOR = new c();

        /* renamed from: e */
        private TwoWayLayoutManager.Orientation f6817e;

        /* renamed from: f */
        private Rect[] f6818f;

        /* renamed from: g */
        private int f6819g;

        /* renamed from: h */
        private d f6820h;

        public /* synthetic */ b(Parcel parcel, com.adobe.creativesdk.foundation.internal.twowayview.widget.a aVar) {
            this(parcel);
        }

        @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6817e.ordinal());
            parcel.writeInt(this.f6819g);
            Rect[] rectArr = this.f6818f;
            int length = rectArr != null ? rectArr.length : 0;
            parcel.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                this.f6818f[i2].writeToParcel(parcel, 1);
            }
            d dVar = this.f6820h;
            int b2 = dVar != null ? dVar.b() : 0;
            parcel.writeInt(b2);
            for (int i3 = 0; i3 < b2; i3++) {
                parcel.writeParcelable(this.f6820h.a(i3), i);
            }
        }

        protected b(Parcelable parcelable) {
            super(parcelable);
        }

        private b(Parcel parcel) {
            super(parcel);
            this.f6817e = TwoWayLayoutManager.Orientation.values()[parcel.readInt()];
            this.f6819g = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.f6818f = new Rect[readInt];
                for (int i = 0; i < readInt; i++) {
                    Rect rect = new Rect();
                    rect.readFromParcel(parcel);
                    this.f6818f[i] = rect;
                }
            }
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                this.f6820h = new d();
                for (int i2 = 0; i2 < readInt2; i2++) {
                    this.f6820h.b(i2, (a) parcel.readParcelable(b.class.getClassLoader()));
                }
            }
        }
    }

    public BaseLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(a aVar, Rect rect, int i, int i2, TwoWayLayoutManager.Direction direction) {
        for (int i3 = i; i3 < i + i2; i3++) {
            this.B.a(rect, i3, (aVar == null || direction == TwoWayLayoutManager.Direction.END) ? 0 : aVar.a(i3 - i), direction);
        }
    }

    private int f(View view) {
        if (!m()) {
            return 0;
        }
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (l().d() * c(view));
    }

    private boolean q() {
        int k = k();
        if (k == 0 || getWidth() == 0 || getHeight() == 0 || a(this.B)) {
            return false;
        }
        e eVar = this.B;
        this.B = new e(this, k);
        r();
        if (this.D == null) {
            this.D = new d();
        }
        if (eVar != null && eVar.e() == this.B.e() && eVar.d() == this.B.d()) {
            b(0);
            return true;
        }
        this.D.a();
        return true;
    }

    private void r() {
        if (h() != -1) {
            return;
        }
        int e2 = e();
        View findViewByPosition = findViewByPosition(e2);
        c(e2, findViewByPosition != null ? b(findViewByPosition) : 0);
    }

    a a(View view, Rect rect) {
        return null;
    }

    abstract void a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state);

    public void a(a aVar, Rect rect, int i, int i2, TwoWayLayoutManager.Direction direction) {
        boolean z = (direction != TwoWayLayoutManager.Direction.END || aVar == null || aVar.b()) ? false : true;
        for (int i3 = i; i3 < i + i2; i3++) {
            int b2 = this.B.b(rect, i3, (aVar == null || direction == TwoWayLayoutManager.Direction.END) ? 0 : aVar.a(i3 - i), direction);
            if (i2 > 1 && z) {
                aVar.a(i3 - i, b2, i2);
            }
        }
    }

    abstract void a(e.a aVar, int i, TwoWayLayoutManager.Direction direction);

    int c(View view) {
        return 1;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager
    public void c(View view, TwoWayLayoutManager.Direction direction) {
        d(view, direction);
        d(view);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return m() ? ((ViewGroup.MarginLayoutParams) layoutParams).width == -1 : ((ViewGroup.MarginLayoutParams) layoutParams).height == -1;
    }

    a d(View view, TwoWayLayoutManager.Direction direction) {
        return null;
    }

    void d(int i, int i2) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.a(i, i2);
        }
    }

    void e(int i, int i2) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.b(i, i2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (m()) {
            return new RecyclerView.LayoutParams(-1, -2);
        }
        return new RecyclerView.LayoutParams(-2, -1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        if (m()) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = layoutParams.width;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
        }
        return layoutParams2;
    }

    void j() {
        d dVar = this.D;
        if (dVar != null) {
            dVar.a();
        }
    }

    abstract int k();

    public e l() {
        return this.B;
    }

    public boolean m() {
        return getOrientation() == TwoWayLayoutManager.Orientation.VERTICAL;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        if (!m()) {
            this.B.a(i);
        }
        super.offsetChildrenHorizontal(i);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        if (m()) {
            this.B.a(i);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        a(i, i2, UpdateOp.ADD);
        super.onItemsAdded(recyclerView, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        j();
        super.onItemsChanged(recyclerView);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        a(i, i2, UpdateOp.MOVE);
        super.onItemsMoved(recyclerView, i, i2, i3);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        a(i, i2, UpdateOp.REMOVE);
        super.onItemsRemoved(recyclerView, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        a(i, i2, UpdateOp.UPDATE);
        super.onItemsUpdated(recyclerView, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = this.C != null;
        if (z) {
            this.B = this.C;
            this.D = this.E;
            this.C = null;
            this.E = null;
        }
        boolean q = q();
        if (this.B == null) {
            return;
        }
        int itemCount = state.getItemCount();
        d dVar = this.D;
        if (dVar != null) {
            dVar.c(itemCount);
        }
        c(state);
        int a2 = a(state);
        if (a2 > 0 && (q || !z)) {
            a(a2, g(), recycler, state);
        }
        this.B.a(TwoWayLayoutManager.Direction.START);
        super.onLayoutChildren(recycler, state);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        if (bVar.f6818f != null && bVar.f6819g > 0) {
            this.C = new e(this, bVar.f6817e, bVar.f6818f, bVar.f6819g);
            this.E = bVar.f6820h;
        }
        super.onRestoreInstanceState(bVar.a());
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        e eVar = this.B;
        int a2 = eVar != null ? eVar.a() : 0;
        bVar.f6818f = new Rect[a2];
        for (int i = 0; i < a2; i++) {
            Rect rect = new Rect();
            this.B.a(i, rect);
            bVar.f6818f[i] = rect;
        }
        bVar.f6817e = getOrientation();
        e eVar2 = this.B;
        bVar.f6819g = eVar2 != null ? eVar2.d() : 0;
        bVar.f6820h = this.D;
        return bVar;
    }

    public BaseLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new Rect();
        this.G = new Rect();
        this.H = new e.a();
    }

    private int e(View view) {
        if (m()) {
            return 0;
        }
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (l().d() * c(view));
    }

    void d(View view) {
        measureChildWithMargins(view, f(view), e(view));
    }

    void b(View view, Rect rect) {
        rect.left = getDecoratedLeft(view);
        rect.top = getDecoratedTop(view);
        rect.right = getDecoratedRight(view);
        rect.bottom = getDecoratedBottom(view);
    }

    public BaseLayoutManager(TwoWayLayoutManager.Orientation orientation) {
        super(orientation);
        this.F = new Rect();
        this.G = new Rect();
        this.H = new e.a();
    }

    public void a(int i, a aVar) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.a(i, aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    void b(int i) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.b(i);
        }
    }

    public a a(int i) {
        d dVar = this.D;
        if (dVar != null) {
            return dVar.a(i);
        }
        return null;
    }

    private boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        int k = k();
        return eVar.e() == getOrientation() && eVar.a() == k && eVar.d() == e.a(this, k);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager
    protected void b(View view, TwoWayLayoutManager.Direction direction) {
        a(this.H, view, direction);
        this.B.a(this.F, getDecoratedMeasuredWidth(view), getDecoratedMeasuredHeight(view), this.H, direction);
        a a2 = a(view, this.F);
        Rect rect = this.F;
        layoutDecorated(view, rect.left, rect.top, rect.right, rect.bottom);
        if (((RecyclerView.LayoutParams) view.getLayoutParams()).isItemRemoved()) {
            return;
        }
        a(a2, this.F, this.H.f6841a, c(view), direction);
    }

    private void a(int i, int i2, UpdateOp updateOp) {
        b(i);
        int i3 = com.adobe.creativesdk.foundation.internal.twowayview.widget.a.f6829a[updateOp.ordinal()];
        if (i3 == 1) {
            d(i, i2);
        } else if (i3 == 2) {
            e(i, i2);
        } else if (i3 == 3) {
            e(i, 1);
            d(i2, 1);
        }
        if (i2 + i > e() && i <= f()) {
            requestLayout();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.B.g();
        super.a(recycler, state);
        this.B.f();
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager
    protected boolean a(TwoWayLayoutManager.Direction direction, int i) {
        return direction == TwoWayLayoutManager.Direction.START ? this.B.c() > i : this.B.b() < i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager
    protected void a(View view, TwoWayLayoutManager.Direction direction) {
        int position = getPosition(view);
        a(this.H, position, direction);
        b(view, this.F);
        b(a(position), this.F, this.H.f6841a, c(view), direction);
    }

    public void a(e.a aVar, View view, TwoWayLayoutManager.Direction direction) {
        a(aVar, getPosition(view), direction);
    }
}
