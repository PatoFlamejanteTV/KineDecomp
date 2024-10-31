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
/* loaded from: classes.dex */
public class y extends BaseAdapter {

    /* renamed from: a */
    private LayerExpression[] f4120a;

    public y(LayerExpression.Type type, NexLayerItem nexLayerItem) {
        this.f4120a = LayerExpression.values(type, nexLayerItem);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4120a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f4120a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f4120a[i].getId();
    }

    public int a(long j) {
        for (int i = 0; i < this.f4120a.length; i++) {
            if (this.f4120a[i].getId() == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayerExpression layerExpression = this.f4120a[i];
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
