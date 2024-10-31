package com.nexstreaming.kinemaster.ui.store.controller;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* compiled from: AssetDetailPreviewImageListAdapter.java */
/* loaded from: classes2.dex */
public class Da extends PagerAdapter {

    /* renamed from: c, reason: collision with root package name */
    private List<String> f23428c;

    public Da(List<String> list) {
        this.f23428c = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f23428c.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.c.b(viewGroup.getContext()).a(this.f23428c.get(i));
        a2.b(0.1f);
        a2.a(imageView);
        viewGroup.addView(imageView);
        return imageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
