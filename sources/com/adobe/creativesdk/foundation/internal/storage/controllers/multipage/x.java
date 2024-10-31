package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: MarginDecoration.java */
/* loaded from: classes.dex */
public class x extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private int f6337a;

    public x(Context context) {
        this.f6337a = context.getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_asset_multipage_spacing);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.f6337a;
        rect.set(i, i, i, i);
    }
}
