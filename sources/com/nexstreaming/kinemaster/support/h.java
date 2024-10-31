package com.nexstreaming.kinemaster.support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: SupportListAdapter.java */
/* loaded from: classes.dex */
public class h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    g f3637a;
    private Context b;

    public h(Context context, g gVar) {
        this.b = null;
        this.f3637a = null;
        this.b = context;
        this.f3637a = gVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3637a.e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g getItem(int i) {
        return this.f3637a.e.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a();
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.item_support, (ViewGroup) null);
            aVar2.f3638a = (TextView) view.findViewById(R.id.tv_item_support);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        g item = getItem(i);
        if (item != null) {
            aVar.f3638a.setText(item.f3636a);
        }
        return view;
    }

    public void a(g gVar) {
        this.f3637a = gVar;
        notifyDataSetChanged();
    }

    public g a() {
        return this.f3637a;
    }

    /* compiled from: SupportListAdapter.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private TextView f3638a;

        private a() {
            this.f3638a = null;
        }
    }
}
