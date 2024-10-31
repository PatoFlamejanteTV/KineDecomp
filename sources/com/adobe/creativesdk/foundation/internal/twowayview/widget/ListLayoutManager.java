package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.e;

/* loaded from: classes.dex */
public class ListLayoutManager extends BaseLayoutManager {
    public ListLayoutManager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(e.a aVar, int i, TwoWayLayoutManager.Direction direction) {
        aVar.a(0, 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    int k() {
        return 1;
    }

    public ListLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager
    void a(int i, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        l().b(i2);
    }

    public ListLayoutManager(Context context, TwoWayLayoutManager.Orientation orientation) {
        super(orientation);
    }
}
