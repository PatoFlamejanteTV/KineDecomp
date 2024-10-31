package com.adobe.creativesdk.foundation.internal.storage.controllers.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: GridSpacesItemDecoration.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private int f6494a;

    public d(int i, Context context) {
        this.f6494a = a(i, context);
    }

    public int a(int i, Context context) {
        return Math.round(i * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int i = this.f6494a;
        rect.set(i, i, i, i);
    }
}
