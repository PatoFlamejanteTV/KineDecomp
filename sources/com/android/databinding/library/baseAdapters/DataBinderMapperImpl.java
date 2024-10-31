package com.android.databinding.library.baseAdapters;

import android.databinding.ViewDataBinding;
import android.databinding.c;
import android.databinding.d;
import android.util.SparseIntArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends c {

    /* renamed from: a */
    private static final SparseIntArray f7971a = new SparseIntArray(0);

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View view, int i) {
        if (f7971a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f7971a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // android.databinding.c
    public List<c> a() {
        return new ArrayList(0);
    }
}
