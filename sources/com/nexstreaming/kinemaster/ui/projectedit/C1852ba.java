package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.BlendMode;

/* compiled from: BlendModeAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1852ba extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private BlendMode[] f22271a;

    /* renamed from: b, reason: collision with root package name */
    private Context f22272b;

    public C1852ba(BlendMode[] blendModeArr, Context context) {
        this.f22271a = blendModeArr;
        this.f22272b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f22271a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f22271a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String string = this.f22272b.getString(this.f22271a[i].getResid());
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        IconView iconView = (IconView) view.findViewById(R.id.icon);
        iconView.setIconColorStateList(R.color.optmenu_item_text_color);
        iconView.setImageResource(R.drawable.material_radio);
        view.findViewById(R.id.opt_depth_indicator).setVisibility(8);
        ((TextView) view.findViewById(R.id.text)).setText(string);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_free);
        if (this.f22271a[i].getPaidType() == IABManager.BillingType.PREMIUM) {
            imageView.setImageResource(R.drawable.premium_03);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        return view;
    }
}
