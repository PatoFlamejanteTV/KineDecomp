package com.nexstreaming.kinemaster.ui.widget;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShareSpinnerAdapter.java */
/* loaded from: classes.dex */
public abstract class m<T> extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<T> f4398a;

    protected abstract int a(T t);

    protected abstract String a(Resources resources, T t);

    public m(List<T> list) {
        this.f4398a = list;
    }

    public m(T[] tArr) {
        this.f4398a = Arrays.asList(tArr);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4398a.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.f4398a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, false);
    }

    private View a(int i, View view, ViewGroup viewGroup, boolean z) {
        int color;
        T t = this.f4398a.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.share_spinner_adapter, viewGroup, false);
        }
        if (z) {
            color = view.getResources().getColor(R.color.sns_spinner_popup_text_color);
        } else {
            color = view.getResources().getColor(R.color.sns_spinner_text_color);
        }
        TextView textView = (TextView) view.findViewById(R.id.labelTV);
        IconView iconView = (IconView) view.findViewById(R.id.iconView);
        String a2 = a(view.getResources(), t);
        int a3 = a(t);
        if (a3 == 0) {
            iconView.setVisibility(8);
        } else {
            iconView.setVisibility(0);
            iconView.setIconColor(color);
            iconView.setImageResource(a3);
        }
        textView.setTextColor(color);
        textView.setText(a2);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, true);
    }
}
