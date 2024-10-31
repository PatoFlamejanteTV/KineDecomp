package com.nexstreaming.kinemaster.ui.widget;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.PopoutBookmarkListMenu;
import java.util.List;

/* compiled from: PopoutBookmarkListMenu.java */
/* loaded from: classes2.dex */
public class i extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ PopoutBookmarkListMenu f23870a;

    public i(PopoutBookmarkListMenu popoutBookmarkListMenu) {
        this.f23870a = popoutBookmarkListMenu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.f23870a.f23796h;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        list = this.f23870a.f23796h;
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List list;
        list = this.f23870a.f23796h;
        return ((PopoutBookmarkListMenu.a) list.get(i)).f23797a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        List list2;
        boolean z;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popout_list_menu_item, viewGroup, false);
            z = this.f23870a.j;
            if (z) {
                view.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.popout_menu_item_white_bg));
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.label);
        list = this.f23870a.f23796h;
        textView.setText(((PopoutBookmarkListMenu.a) list.get(i)).f23798b);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        list2 = this.f23870a.f23796h;
        Drawable drawable = ((PopoutBookmarkListMenu.a) list2.get(i)).f23799c;
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
        return view;
    }
}
