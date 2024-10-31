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

    /* renamed from: a, reason: collision with root package name */
    ArrayList<f> f3402a;

    public g(ArrayList<f> arrayList) {
        this.f3402a = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3402a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3402a.get(i);
    }

    public int a(int i, Context context) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f3402a.size()) {
                if (this.f3402a.get(i3).a() != context.getString(i)) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return -1;
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        Context context = viewGroup.getContext();
        f fVar = this.f3402a.get(i);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
            if (fVar.c() != null) {
                i2 = R.layout.help_sub_section_item;
            } else {
                i2 = R.layout.help_section_item;
            }
            view = layoutInflater.inflate(i2, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iconView);
        if (fVar.c() != null) {
            imageView.setImageDrawable(fVar.c());
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R.id.sectionTextView);
        textView.setTag(fVar.a());
        textView.setText(fVar.a());
        return view;
    }
}
