package com.nexstreaming.kinemaster.ui.store.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/* compiled from: ItemSpacing.java */
/* loaded from: classes2.dex */
public class c extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private int f23689a;

    public c(int i) {
        this.f23689a = i;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = childAdapterPosition % spanCount;
            int i2 = this.f23689a;
            rect.left = (i * i2) / spanCount;
            rect.right = i2 - (((i + 1) * i2) / spanCount);
            if (childAdapterPosition >= spanCount) {
                rect.top = i2;
                return;
            }
            return;
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            int childAdapterPosition2 = recyclerView.getChildAdapterPosition(view);
            int childCount = recyclerView.getChildCount();
            rect.left = childAdapterPosition2 == 0 ? 0 : this.f23689a;
            rect.right = childAdapterPosition2 == childCount ? this.f23689a : 0;
        }
    }

    public c(Context context, int i, int i2) {
        this.f23689a = (int) TypedValue.applyDimension(i2, i, context.getResources().getDisplayMetrics());
    }
}
