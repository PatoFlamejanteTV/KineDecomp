package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: AudioPageSubCategoryAdapter.java */
/* loaded from: classes2.dex */
public class Pa extends BaseAdapter {

    /* renamed from: a */
    private List<com.nexstreaming.kinemaster.network.m> f23475a;

    public Pa(List<com.nexstreaming.kinemaster.network.m> list) {
        this.f23475a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23475a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f23475a.get(i);
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
        ((TextView) view.findViewById(R.id.subCategoryTitle)).setText(com.nexstreaming.app.general.util.J.a(viewGroup.getContext(), this.f23475a.get(i).getSubcategoryName()));
        return view;
    }
}
