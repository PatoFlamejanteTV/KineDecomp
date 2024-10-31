package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: PopupListAdatper.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    Context f4507a;
    private Menu b;

    public c(Context context, Menu menu) {
        this.f4507a = context;
        this.b = menu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.b.getItem(i).getItemId();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f4507a).inflate(R.layout.layout_popup_menu_item, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.textView_popup_menu_title)).setText(this.b.getItem(i).getTitle());
        ((ImageView) view.findViewById(R.id.imageView_popup_menu_icon)).setImageDrawable(this.b.getItem(i).getIcon());
        return view;
    }
}
