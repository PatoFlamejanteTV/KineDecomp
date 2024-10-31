package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;

/* compiled from: ExpressionMenuAdapter.java */
/* loaded from: classes2.dex */
public class Ca extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private LayerExpression[] f21797a;

    public Ca(LayerExpression.Type type, NexLayerItem nexLayerItem) {
        this.f21797a = LayerExpression.values(type, nexLayerItem);
    }

    public int a(long j) {
        int i = 0;
        while (true) {
            if (i >= this.f21797a.length) {
                return -1;
            }
            if (r1[i].getId() == j) {
                return i;
            }
            i++;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21797a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f21797a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f21797a[i].getId();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayerExpression layerExpression = this.f21797a[i];
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        IconView iconView = (IconView) view.findViewById(R.id.icon);
        iconView.setIconColorStateList(R.color.optmenu_item_text_color);
        iconView.setImageResource(R.drawable.material_radio);
        view.findViewById(R.id.opt_depth_indicator).setVisibility(8);
        ((TextView) view.findViewById(R.id.text)).setText(layerExpression.getLabelResource());
        return view;
    }
}
