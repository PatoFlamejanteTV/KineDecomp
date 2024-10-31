package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: CategoryAdapter.java */
/* loaded from: classes.dex */
public class o extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    AudioCategory[] f3681a;

    public o(AudioCategory... audioCategoryArr) {
        this.f3681a = audioCategoryArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3681a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3681a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f3681a[i].label_id;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AudioCategory audioCategory = this.f3681a[i];
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n2_amediabrowser_cat_text, viewGroup, false);
        }
        if (view.findViewById(R.id.sfx) != null) {
            ((TextView) view.findViewById(R.id.sfx)).setText(audioCategory.label_id);
        }
        ((ImageView) view.findViewById(R.id.iconView)).setImageResource(audioCategory.icon_id);
        return view;
    }
}
