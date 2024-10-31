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
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StoreMainCategoryAdapter.java */
/* loaded from: classes2.dex */
public class pb extends BaseAdapter {

    /* renamed from: c, reason: collision with root package name */
    private Context f23605c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f23606d;

    /* renamed from: b, reason: collision with root package name */
    private int f23604b = -1;

    /* renamed from: a, reason: collision with root package name */
    private final List<InterfaceC1822k> f23603a = new ArrayList();

    /* compiled from: StoreMainCategoryAdapter.java */
    /* loaded from: classes2.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f23607a;

        a() {
        }
    }

    public pb(Context context) {
        this.f23605c = context;
        this.f23606d = (LayoutInflater) this.f23605c.getSystemService("layout_inflater");
    }

    public pb a(List<InterfaceC1822k> list) {
        this.f23603a.addAll(list);
        return this;
    }

    public int b() {
        return this.f23604b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23603a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f23606d.inflate(R.layout.asset_category_item, viewGroup, false);
            aVar = new a();
            aVar.f23607a = (ImageView) view.findViewById(R.id.categoryIconView);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        InterfaceC1822k interfaceC1822k = this.f23603a.get(i);
        com.bumptech.glide.c.b(this.f23605c).a(interfaceC1822k.getIconURL()).a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().b(a(interfaceC1822k.getCategoryAliasName())).b()).a(aVar.f23607a);
        if (i == this.f23604b) {
            aVar.f23607a.setColorFilter(ContextCompat.getColor(this.f23605c, R.color.km_red), PorterDuff.Mode.SRC_IN);
        } else {
            aVar.f23607a.setColorFilter(ContextCompat.getColor(this.f23605c, R.color.km_white), PorterDuff.Mode.SRC_IN);
        }
        return view;
    }

    public pb a() {
        this.f23603a.clear();
        return this;
    }

    @Override // android.widget.Adapter
    public InterfaceC1822k getItem(int i) {
        return this.f23603a.get(i);
    }

    public void a(int i) {
        this.f23604b = i;
        notifyDataSetChanged();
    }

    private int a(String str) {
        if ("Featured".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_featured;
        }
        if ("Effect".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_effect;
        }
        if ("Transition".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_transition;
        }
        if ("Overlay".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_overlay;
        }
        if ("Font".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_font;
        }
        if ("Audio".equalsIgnoreCase(str)) {
            return R.drawable.ic_asset_audio;
        }
        if ("Fandoms".equalsIgnoreCase(str) || "Media".equalsIgnoreCase(str)) {
            return R.drawable.normal_fandoms_icon;
        }
        return 0;
    }
}
