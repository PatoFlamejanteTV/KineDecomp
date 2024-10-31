package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
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
public class StaggeredGridLayoutManager extends GridLayoutManager {

    /* loaded from: classes.dex */
    public static class b extends BaseLayoutManager.a {
        public static final Parcelable.Creator<b> CREATOR = new h();

        /* renamed from: d */
        private final int f6826d;

        /* renamed from: e */
        private int f6827e;

        /* renamed from: f */
        private int f6828f;

        public b(int i, int i2, int i3) {
            super(i, i2);
            this.f6826d = i3;
        }

        @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6826d);
            parcel.writeInt(this.f6827e);
            parcel.writeInt(this.f6828f);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.f6826d = parcel.readInt();
            this.f6827e = parcel.readInt();
            this.f6828f = parcel.readInt();
        }
    }

    public StaggeredGridLayoutManager(Context context) {
        this(context, null);
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

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    int c(View view) {
        return ((a) view.getLayoutParams()).f6825e;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        boolean checkLayoutParams = super.checkLayoutParams(layoutParams);
        if (!(layoutParams instanceof a)) {
            return checkLayoutParams;
        }
        int i = ((a) layoutParams).f6825e;
        return checkLayoutParams & (i >= 1 && i <= k());
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
            e.a aVar = this.H;
            b bVar2 = new b(aVar.f6841a, aVar.f6842b, c(view));
            a(position, bVar2);
            return bVar2;
        }
        bVar.a(this.H);
        return bVar;
    }

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public int f6825e;

        public a(int i, int i2) {
            super(i, i2);
            this.f6825e = 1;
        }

        private void a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof a) {
                this.f6825e = ((a) layoutParams).f6825e;
            } else {
                this.f6825e = 1;
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.adobe_csdk_twowayview_StaggeredGridViewChild);
            this.f6825e = Math.max(1, obtainStyledAttributes.getInt(j.adobe_csdk_twowayview_StaggeredGridViewChild_adobe_csdk_twowayview_span, -1));
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            a(marginLayoutParams);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public a generateDefaultLayoutParams() {
        if (m()) {
            return new a(-1, -2);
        }
        return new a(-2, -1);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 2, 2);
    }

    int c(int i) {
        b bVar = (b) a(i);
        if (bVar != null) {
            return bVar.f6826d;
        }
        throw new IllegalStateException("Could not find span for position " + i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a aVar = new a((ViewGroup.MarginLayoutParams) layoutParams);
        if (m()) {
            ((ViewGroup.MarginLayoutParams) aVar).width = -1;
            ((ViewGroup.MarginLayoutParams) aVar).height = layoutParams.height;
        } else {
            ((ViewGroup.MarginLayoutParams) aVar).width = layoutParams.width;
            ((ViewGroup.MarginLayoutParams) aVar).height = -1;
        }
        if (layoutParams instanceof a) {
            aVar.f6825e = Math.max(1, Math.min(((a) layoutParams).f6825e, k()));
        }
        return aVar;
    }

    public StaggeredGridLayoutManager(TwoWayLayoutManager.Orientation orientation, int i, int i2) {
        super(orientation, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    public void a(e.a aVar, View view, TwoWayLayoutManager.Direction direction) {
        super.a(aVar, view, direction);
        if (aVar.a()) {
            l().a(aVar, c(view), direction);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager, com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        b bVar;
        boolean m = m();
        e l = l();
        l.b(0);
        for (int i3 = 0; i3 <= i; i3++) {
            b bVar2 = (b) a(i3);
            if (bVar2 != null) {
                this.H.a(bVar2.f6814a, bVar2.f6815b);
                if (this.H.a()) {
                    l.a(this.H, c(i3), TwoWayLayoutManager.Direction.END);
                    bVar2.a(this.H);
                }
                l.a(this.G, bVar2.f6827e, bVar2.f6828f, this.H, TwoWayLayoutManager.Direction.END);
                bVar = bVar2;
            } else {
                View viewForPosition = recycler.getViewForPosition(i3);
                c(viewForPosition, TwoWayLayoutManager.Direction.END);
                b bVar3 = (b) a(i3);
                this.H.a(bVar3.f6814a, bVar3.f6815b);
                l.a(this.G, getDecoratedMeasuredWidth(viewForPosition), getDecoratedMeasuredHeight(viewForPosition), this.H, TwoWayLayoutManager.Direction.END);
                a(bVar3, this.G);
                bVar = bVar3;
            }
            if (i3 != i) {
                a(bVar, this.G, bVar.f6814a, bVar.f6826d, TwoWayLayoutManager.Direction.END);
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

    void a(b bVar, Rect rect) {
        bVar.f6827e = rect.right - rect.left;
        bVar.f6828f = rect.bottom - rect.top;
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    BaseLayoutManager.a a(View view, Rect rect) {
        b bVar = (b) a(getPosition(view));
        if (bVar != null) {
            a(bVar, rect);
            return bVar;
        }
        throw new IllegalStateException("Tried to cache frame on undefined item");
    }
}
