package com.nexstreaming.kinemaster.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;

/* compiled from: SectionAdapter.java */
/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: a */
    ArrayList<f> f20416a;

    public g(ArrayList<f> arrayList) {
        this.f20416a = arrayList;
    }

    public int a(int i, Context context) {
        for (int i2 = 0; i2 < this.f20416a.size(); i2++) {
            if (this.f20416a.get(i2).e() == context.getString(i)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20416a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f20416a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        f fVar = this.f20416a.get(i);
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(fVar.a() != null ? R.layout.help_sub_section_item : R.layout.help_section_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iconView);
        if (fVar.a() != null) {
            imageView.setImageDrawable(fVar.a());
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R.id.sectionTextView);
        textView.setTag(fVar.e());
        textView.setText(fVar.e());
        return view;
    }
}
