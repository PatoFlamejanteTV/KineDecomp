package com.nexstreaming.kinemaster.ui.store.controller;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;

/* compiled from: AssetDetailPreviewImagePagerAdapter.java */
/* loaded from: classes2.dex */
public class Ha extends RecyclerView.Adapter<a> {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f23446c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentManager f23447d;

    /* renamed from: e, reason: collision with root package name */
    private int f23448e;

    /* compiled from: AssetDetailPreviewImagePagerAdapter.java */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.ViewHolder {
        public final View s;
        public final ImageView t;

        public a(View view) {
            super(view);
            this.s = view.findViewById(R.id.layout_asset_thumbnail_item);
            this.t = (ImageView) view.findViewById(R.id.iv_asset_thumbnail_item_image);
        }
    }

    public Ha(ArrayList<String> arrayList, FragmentManager fragmentManager) {
        this.f23446c = arrayList;
        this.f23447d = fragmentManager;
    }

    public String getItem(int i) {
        return this.f23446c.get(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23446c.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        if (aVar != null) {
            com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.c.b(aVar.t.getContext()).a(getItem(i) + "_s");
            a2.b(0.1f);
            a2.a(aVar.t);
            aVar.t.setOnClickListener(new Ga(this, i));
            ViewGroup.LayoutParams layoutParams = aVar.s.getLayoutParams();
            double d2 = this.f23448e;
            Double.isNaN(d2);
            layoutParams.width = (int) (d2 * 1.78d);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_asset_thumbnail_item, (ViewGroup) null));
        this.f23448e = viewGroup.getHeight();
        return aVar;
    }
}
