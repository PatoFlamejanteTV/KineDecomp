package com.nexstreaming.kinemaster.ui.store.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.d.b.m.f;

/* loaded from: classes2.dex */
public class NestedGridLayoutManager extends GridLayoutManager {
    private int[] P;

    public NestedGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.P = new int[2];
        a(context);
    }

    private void a(Context context) {
        int a2 = f.a(context);
        if (a2 > 0) {
            setSpanCount(a2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = 0;
        while (i3 < getItemCount()) {
            a(recycler, i3, View.MeasureSpec.makeMeasureSpec(i3, 0), View.MeasureSpec.makeMeasureSpec(i3, 0), this.P);
            i3 += getSpanCount();
        }
        if (mode != 1073741824) {
            size = 0;
        }
        if (mode2 != 1073741824) {
            size2 = 0;
        }
        setMeasuredDimension(size, size2);
    }

    private void a(RecyclerView.Recycler recycler, int i, int i2, int i3, int[] iArr) {
        View viewForPosition;
        if (i < recycler.getScrapList().size() && (viewForPosition = recycler.getViewForPosition(i)) != null) {
            recycler.bindViewToPosition(viewForPosition, i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            viewForPosition.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = viewForPosition.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            iArr[1] = viewForPosition.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            recycler.recycleView(viewForPosition);
        }
    }

    public NestedGridLayoutManager(Context context, int i) {
        super(context, i);
        this.P = new int[2];
        a(context);
    }

    public NestedGridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
        this.P = new int[2];
        a(context);
    }
}
