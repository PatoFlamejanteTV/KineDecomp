package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import c.a.a.a.b.j;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.e;

/* loaded from: classes.dex */
public class GridLayoutManager extends BaseLayoutManager {
    private int I;
    private int J;

    public GridLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(e.a aVar, int i, TwoWayLayoutManager.Direction direction) {
        int k = i % k();
        aVar.a(k, k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    public int k() {
        return m() ? this.I : this.J;
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 2, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.adobe_csdk_twowayview_GridLayoutManager, i, 0);
        this.I = Math.max(1, obtainStyledAttributes.getInt(j.adobe_csdk_twowayview_GridLayoutManager_adobe_csdk_twowayview_numColumns, i2));
        this.J = Math.max(1, obtainStyledAttributes.getInt(j.adobe_csdk_twowayview_GridLayoutManager_adobe_csdk_twowayview_numRows, i3));
        obtainStyledAttributes.recycle();
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        e l = l();
        l.b(i2);
        a(this.H, i, TwoWayLayoutManager.Direction.END);
        int i3 = this.H.f6841a;
        if (i3 == 0) {
            return;
        }
        View viewForPosition = recycler.getViewForPosition(i);
        c(viewForPosition, TwoWayLayoutManager.Direction.END);
        int decoratedMeasuredHeight = m() ? getDecoratedMeasuredHeight(viewForPosition) : getDecoratedMeasuredWidth(viewForPosition);
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            l.a(i4, decoratedMeasuredHeight);
        }
    }

    public GridLayoutManager(TwoWayLayoutManager.Orientation orientation, int i, int i2) {
        super(orientation);
        this.I = i;
        this.J = i2;
        if (this.I >= 1) {
            if (this.J < 1) {
                throw new IllegalArgumentException("GridLayoutManager must have at least 1 row");
            }
            return;
        }
        throw new IllegalArgumentException("GridLayoutManager must have at least 1 column");
    }
}
