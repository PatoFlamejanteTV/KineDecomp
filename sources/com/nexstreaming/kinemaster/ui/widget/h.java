package com.nexstreaming.kinemaster.ui.widget;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.g;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PopoutListMenu.java */
/* loaded from: classes.dex */
public class h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f4393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f4393a = gVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        list = this.f4393a.f;
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        list = this.f4393a.f;
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List list;
        list = this.f4393a.f;
        return ((g.a) list.get(i)).f4392a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        List list2;
        boolean z;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popout_list_menu_item, viewGroup, false);
            z = this.f4393a.h;
            if (z) {
                view.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.popout_menu_item_white_bg));
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.label);
        list = this.f4393a.f;
        textView.setText(((g.a) list.get(i)).b);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        list2 = this.f4393a.f;
        Drawable drawable = ((g.a) list2.get(i)).c;
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
        return view;
    }
}
