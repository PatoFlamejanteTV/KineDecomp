package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;

/* compiled from: EffectMenuAdapter.java */
/* loaded from: classes.dex */
public class x extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f4119a;

    public x(ArrayList<String> arrayList) {
        this.f4119a = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4119a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f4119a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str = this.f4119a.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        IconView iconView = (IconView) view.findViewById(R.id.icon);
        iconView.setIconColorStateList(R.color.optmenu_item_text_color);
        iconView.setImageResource(R.drawable.material_radio);
        view.findViewById(R.id.opt_depth_indicator).setVisibility(8);
        ((TextView) view.findViewById(R.id.text)).setText(str);
        return view;
    }
}
