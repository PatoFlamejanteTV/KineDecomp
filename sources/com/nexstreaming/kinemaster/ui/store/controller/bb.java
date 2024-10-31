package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: MyAssetCategoryAdapter.java */
/* loaded from: classes2.dex */
public class bb extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<com.nexstreaming.kinemaster.ui.store.model.d> f23533a;

    /* renamed from: b, reason: collision with root package name */
    private int f23534b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f23535c = -1;

    /* renamed from: d, reason: collision with root package name */
    private Context f23536d;

    public bb(List<com.nexstreaming.kinemaster.ui.store.model.d> list, Context context) {
        this.f23533a = list;
        this.f23536d = context;
    }

    public void a(int i) {
        this.f23533a.remove(i);
        notifyDataSetInvalidated();
    }

    public void b(int i) {
        this.f23535c = i;
        notifyDataSetChanged();
    }

    public void c(int i) {
        this.f23534b = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23533a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f23533a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.asset_category_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.categoryIconView);
        com.bumptech.glide.c.b(this.f23536d).a(Integer.valueOf(this.f23533a.get(i).a())).a(imageView);
        if (i == this.f23534b) {
            imageView.setColorFilter(ContextCompat.getColor(this.f23536d, R.color.km_red), PorterDuff.Mode.SRC_IN);
        } else {
            imageView.setColorFilter(ContextCompat.getColor(this.f23536d, R.color.km_white), PorterDuff.Mode.SRC_IN);
        }
        return view;
    }

    public int a() {
        return this.f23534b;
    }
}
