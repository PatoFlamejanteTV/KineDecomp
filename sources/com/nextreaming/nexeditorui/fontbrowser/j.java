package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: FontCollectionListAdapter.java */
/* loaded from: classes2.dex */
public class j extends BaseAdapter {

    /* renamed from: a */
    private Context f24272a;

    /* renamed from: b */
    private List<com.nexstreaming.kinemaster.fonts.c> f24273b;

    public j(Context context, List<com.nexstreaming.kinemaster.fonts.c> list) {
        this.f24272a = context;
        this.f24273b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24273b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24273b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater;
        ViewGroup viewGroup2 = (ViewGroup) view;
        if (view == null && (layoutInflater = (LayoutInflater) this.f24272a.getSystemService("layout_inflater")) != null) {
            viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.panel_font_browser_category_item, (ViewGroup) null);
        }
        ((TextView) viewGroup2.findViewById(R.id.textview_category)).setText(((com.nexstreaming.kinemaster.fonts.c) getItem(i)).getName(this.f24272a));
        return viewGroup2;
    }
}
