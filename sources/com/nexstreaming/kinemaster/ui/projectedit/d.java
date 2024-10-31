package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: AudioEffectAdapter.java */
/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private int[] f3834a;
    private int b;
    private boolean c;
    private boolean d;
    private Context e;

    public d(int[] iArr, Context context) {
        this.f3834a = iArr;
        this.e = context;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3834a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.f3834a[i]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String string = this.e.getString(this.f3834a[i]);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        }
        IconView iconView = (IconView) view.findViewById(R.id.icon);
        if (this.c && this.d && i == this.b && i != 0) {
            iconView.setIconColorStateList(0);
            iconView.setImageResource(R.drawable.material_pause_dis);
        } else if (this.c && !this.d && i == this.b && i != 0) {
            iconView.setImageResource(R.drawable.material_pause);
        } else if (!this.c && !this.d && i == this.b && i != 0) {
            iconView.setImageResource(R.drawable.material_play);
        } else {
            iconView.setIconColorStateList(R.color.optmenu_item_text_color);
            iconView.setImageResource(R.drawable.material_radio);
        }
        view.findViewById(R.id.opt_depth_indicator).setVisibility(8);
        ((TextView) view.findViewById(R.id.text)).setText(string);
        return view;
    }
}
