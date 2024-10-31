package com.adobe.creativesdk.foundation.internal.storage.controllers.utils;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: DividerDecoration.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6490a = {R.attr.listDivider};

    /* renamed from: b, reason: collision with root package name */
    private Drawable f6491b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f6492c;

    /* renamed from: d, reason: collision with root package name */
    private int f6493d;

    public c(Context context, int i) {
        this.f6491b = context.getResources().getDrawable(c.a.a.a.b.d.sectional_list_divider_white);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f6490a);
        this.f6492c = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.f6493d = i;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            int intrinsicHeight = this.f6491b.getIntrinsicHeight() + bottom;
            this.f6491b.setBounds(paddingLeft, bottom, this.f6493d + paddingLeft, intrinsicHeight);
            this.f6491b.draw(canvas);
            this.f6492c.setBounds(this.f6493d + paddingLeft, bottom, width, intrinsicHeight);
            this.f6492c.draw(canvas);
        }
    }
}
