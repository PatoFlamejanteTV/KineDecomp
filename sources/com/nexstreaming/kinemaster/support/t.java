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
public class t extends BaseAdapter {

    /* renamed from: a */
    private Context f21262a;

    /* renamed from: b */
    r f21263b;

    /* compiled from: SupportListAdapter.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a */
        private TextView f21264a;

        private a() {
            this.f21264a = null;
        }

        /* synthetic */ a(s sVar) {
            this();
        }
    }

    public t(Context context, r rVar) {
        this.f21262a = null;
        this.f21263b = null;
        this.f21262a = context;
        this.f21263b = rVar;
    }

    public void a(r rVar) {
        this.f21263b = rVar;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21263b.f21259e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.f21262a).inflate(R.layout.item_support, (ViewGroup) null);
            aVar.f21264a = (TextView) view2.findViewById(R.id.tv_item_support);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        r item = getItem(i);
        if (item != null) {
            aVar.f21264a.setText(item.f21255a);
        }
        return view2;
    }

    @Override // android.widget.Adapter
    public r getItem(int i) {
        return this.f21263b.f21259e.get(i);
    }

    public r a() {
        return this.f21263b;
    }
}
