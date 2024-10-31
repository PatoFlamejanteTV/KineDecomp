package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class AutofitRecyclerView extends RecyclerView {
    private GridLayoutManager Ia;
    private int Ja;

    public AutofitRecyclerView(Context context) {
        super(context);
        this.Ja = -1;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.columnWidth});
            this.Ja = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            obtainStyledAttributes.recycle();
        }
        this.Ia = new GridLayoutManager(getContext(), 1);
        setLayoutManager(this.Ia);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Ja > 0) {
            this.Ia.setSpanCount(Math.max(1, getMeasuredWidth() / this.Ja));
        }
    }

    public AutofitRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ja = -1;
        a(context, attributeSet);
    }

    public AutofitRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ja = -1;
        a(context, attributeSet);
    }
}
