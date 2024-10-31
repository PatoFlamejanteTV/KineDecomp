package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.a.a.b.j;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.e;

/* loaded from: classes.dex */
public class SpannableGridLayoutManager extends GridLayoutManager {
    private boolean K;

    public SpannableGridLayoutManager(Context context) {
        this(context, null);
    }

    private static int a(a aVar, boolean z) {
        return z ? aVar.f6822f : aVar.f6821e;
    }

    private int d(int i) {
        return l().d() * i;
    }

    private int e(int i) {
        return l().d() * i;
    }

    private int g(View view) {
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) - d(((a) view.getLayoutParams()).f6821e);
    }

    private int h(View view) {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - e(((a) view.getLayoutParams()).f6822f);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    int c(View view) {
        return a((a) view.getLayoutParams(), m());
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally() && !this.K;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return super.canScrollVertically() && !this.K;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        int i;
        int i2;
        if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1 || !(layoutParams instanceof a)) {
            return false;
        }
        a aVar = (a) layoutParams;
        return m() ? aVar.f6821e >= 1 && (i2 = aVar.f6822f) >= 1 && i2 <= k() : aVar.f6822f >= 1 && (i = aVar.f6821e) >= 1 && i <= k();
    }

    public SpannableGridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int a(b bVar, boolean z) {
        return z ? bVar.f6823d : bVar.f6824e;
    }

    int c(int i) {
        b bVar = (b) a(i);
        if (bVar != null) {
            return a(bVar, m());
        }
        throw new IllegalStateException("Could not find span for position " + i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void d(View view) {
        this.K = true;
        measureChildWithMargins(view, h(view), g(view));
        this.K = false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public a generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public int f6821e;

        /* renamed from: f */
        public int f6822f;

        public a(int i, int i2) {
            super(i, i2);
            this.f6821e = 1;
            this.f6822f = 1;
        }

        private void a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof a) {
                a aVar = (a) layoutParams;
                this.f6821e = aVar.f6821e;
                this.f6822f = aVar.f6822f;
            } else {
                this.f6821e = 1;
                this.f6822f = 1;
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.adobe_csdk_twowayview_SpannableGridViewChild);
            this.f6822f = Math.max(1, obtainStyledAttributes.getInt(j.adobe_csdk_twowayview_SpannableGridViewChild_adobe_csdk_twowayview_colSpan, -1));
            this.f6821e = Math.max(1, obtainStyledAttributes.getInt(j.adobe_csdk_twowayview_SpannableGridViewChild_adobe_csdk_twowayview_rowSpan, -1));
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            a(marginLayoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BaseLayoutManager.a {
        public static final Parcelable.Creator<b> CREATOR = new g();

        /* renamed from: d */
        private final int f6823d;

        /* renamed from: e */
        private final int f6824e;

        public b(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.f6823d = i3;
            this.f6824e = i4;
        }

        @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6823d);
            parcel.writeInt(this.f6824e);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f6823d = parcel.readInt();
            this.f6824e = parcel.readInt();
        }
    }

    public SpannableGridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 3, 3);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager, com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(e.a aVar, int i, TwoWayLayoutManager.Direction direction) {
        b bVar = (b) a(i);
        if (bVar != null) {
            aVar.a(bVar.f6814a, bVar.f6815b);
        } else {
            aVar.b();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a aVar = new a((ViewGroup.MarginLayoutParams) layoutParams);
        ((ViewGroup.MarginLayoutParams) aVar).width = -1;
        ((ViewGroup.MarginLayoutParams) aVar).height = -1;
        if (layoutParams instanceof a) {
            a aVar2 = (a) layoutParams;
            if (m()) {
                aVar.f6822f = Math.max(1, Math.min(aVar2.f6822f, k()));
                aVar.f6821e = Math.max(1, aVar2.f6821e);
            } else {
                aVar.f6822f = Math.max(1, aVar2.f6822f);
                aVar.f6821e = Math.max(1, Math.min(aVar2.f6821e, k()));
            }
        }
        return aVar;
    }

    public SpannableGridLayoutManager(TwoWayLayoutManager.Orientation orientation, int i, int i2) {
        super(orientation, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    BaseLayoutManager.a d(View view, TwoWayLayoutManager.Direction direction) {
        int position = getPosition(view);
        this.H.b();
        b bVar = (b) a(position);
        if (bVar != null) {
            this.H.a(bVar.f6814a, bVar.f6815b);
        }
        if (this.H.a()) {
            a(this.H, view, direction);
        }
        if (bVar == null) {
            a aVar = (a) view.getLayoutParams();
            e.a aVar2 = this.H;
            b bVar2 = new b(aVar2.f6841a, aVar2.f6842b, aVar.f6822f, aVar.f6821e);
            a(position, bVar2);
            return bVar2;
        }
        bVar.a(this.H);
        return bVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    public void a(e.a aVar, View view, TwoWayLayoutManager.Direction direction) {
        super.a(aVar, view, direction);
        if (aVar.a()) {
            l().a(aVar, c(view), direction);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager, com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    protected void a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean m = m();
        e l = l();
        l.b(0);
        for (int i3 = 0; i3 <= i; i3++) {
            b bVar = (b) a(i3);
            if (bVar == null) {
                bVar = (b) d(recycler.getViewForPosition(i3), TwoWayLayoutManager.Direction.END);
            }
            b bVar2 = bVar;
            this.H.a(bVar2.f6814a, bVar2.f6815b);
            if (this.H.a()) {
                l.a(this.H, c(i3), TwoWayLayoutManager.Direction.END);
                bVar2.a(this.H);
            }
            l.a(this.G, e(bVar2.f6823d), d(bVar2.f6824e), this.H, TwoWayLayoutManager.Direction.END);
            if (i3 != i) {
                a(bVar2, this.G, bVar2.f6814a, a(bVar2, m), TwoWayLayoutManager.Direction.END);
            }
        }
        l.a(this.H.f6841a, this.G);
        l.a(TwoWayLayoutManager.Direction.END);
        l.a(i2 - (m ? this.G.bottom : this.G.right));
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public a generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}
