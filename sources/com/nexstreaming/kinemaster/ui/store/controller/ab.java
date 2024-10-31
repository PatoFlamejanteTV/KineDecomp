package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GridPageStoreSubCategoryAdapter.java */
/* loaded from: classes2.dex */
public class ab extends BaseAdapter {

    /* renamed from: a */
    private final List<com.nexstreaming.kinemaster.network.m> f23529a;

    /* renamed from: b */
    private int f23530b;

    public ab() {
        this(new ArrayList());
    }

    public void a(List<com.nexstreaming.kinemaster.network.m> list) {
        this.f23529a.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23529a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f23529a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.sub_category_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.subCategoryTitle);
        String a2 = com.nexstreaming.app.general.util.J.a(viewGroup.getContext(), this.f23529a.get(i).getSubcategoryName());
        if (a2 != null) {
            textView.setText(a2);
        } else {
            textView.setText("Font");
        }
        if (this.f23530b == i) {
            view.setSelected(true);
            textView.setPressed(true);
        } else {
            view.setSelected(false);
            textView.setPressed(false);
        }
        return view;
    }

    public ab(List<com.nexstreaming.kinemaster.network.m> list) {
        this.f23530b = -1;
        this.f23529a = new ArrayList();
        this.f23529a.addAll(list);
    }

    public void a(int i) {
        this.f23530b = i;
        notifyDataSetChanged();
    }

    public int a() {
        return this.f23530b;
    }
}
