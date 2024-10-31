package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.y;
import java.util.List;

/* compiled from: FontCollectionListAdapter.java */
/* loaded from: classes.dex */
public class k extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f4635a;
    private List<y> b;

    public k(Context context, List<y> list) {
        this.f4635a = context;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = view == null ? (ViewGroup) ((LayoutInflater) this.f4635a.getSystemService("layout_inflater")).inflate(R.layout.panel_font_browser_category_item, (ViewGroup) null) : (ViewGroup) view;
        ((TextView) viewGroup2.findViewById(R.id.textview_category)).setText(((y) getItem(i)).a(this.f4635a));
        return viewGroup2;
    }
}
