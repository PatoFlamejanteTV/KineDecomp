package com.adobe.creativesdk.foundation.internal.storage.controllers.b;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* compiled from: DesignLibrarySpacingItemDecoration.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    int f5948a;

    /* renamed from: b, reason: collision with root package name */
    int f5949b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5950c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f5951d = 0;

    public b(int i, int i2) {
        i = (i & 1) == 0 ? i : i + 1;
        i2 = (i2 & 1) == 0 ? i2 : i2 + 1;
        this.f5948a = i;
        this.f5949b = i2;
    }

    public void a(int i) {
        this.f5950c = true;
        this.f5951d = i;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childPosition = recyclerView.getChildPosition(view);
        int i = this.f5948a / 2;
        rect.left = i;
        rect.right = i;
        int i2 = this.f5949b / 2;
        rect.bottom = i2;
        rect.top = i2;
        boolean z = false;
        if (this.f5950c && childPosition < this.f5951d) {
            z = true;
        }
        if (childPosition == 0 || z) {
            rect.top = this.f5948a;
        }
    }

    public void a() {
        this.f5950c = false;
    }
}
