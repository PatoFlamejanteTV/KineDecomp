package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PopupListAdatper.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a */
    Context f24210a;

    /* renamed from: b */
    private List<MenuItem> f24211b = new ArrayList();

    public c(Context context, Menu menu) {
        this.f24210a = context;
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isVisible()) {
                this.f24211b.add(item);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24211b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24211b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f24211b.get(i).getItemId();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f24211b.get(i).getActionView() != null) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MenuItem menuItem = this.f24211b.get(i);
        if (view == null && (view = menuItem.getActionView()) == null) {
            view = LayoutInflater.from(this.f24210a).inflate(R.layout.layout_popup_menu_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView_popup_menu_title);
        if (textView != null) {
            textView.setText(menuItem.getTitle());
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_popup_menu_icon);
        if (imageView != null) {
            imageView.setImageDrawable(menuItem.getIcon());
        }
        return view;
    }
}
