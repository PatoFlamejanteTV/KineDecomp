package com.nexstreaming.kinemaster.ui.widget;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

/* compiled from: WheelPickerAdapter.java */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: a */
    private String[] f23894a;

    /* renamed from: b */
    private List<DataSetObserver> f23895b;

    /* renamed from: c */
    private LayoutInflater f23896c;

    /* renamed from: d */
    private Context f23897d;

    /* renamed from: e */
    private int f23898e = R.color.white;

    /* renamed from: f */
    private float f23899f;

    public y(Context context, String[] strArr) {
        this.f23897d = context;
        this.f23894a = strArr;
        this.f23899f = context.getResources().getDimensionPixelSize(com.nexstreaming.app.kinemasterfree.R.dimen.picker_focused_text_size);
        this.f23896c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int a() {
        String[] strArr = this.f23894a;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list = this.f23895b;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (i < 0 || i >= a()) {
            return null;
        }
        if (view == null) {
            view = a(com.nexstreaming.app.kinemasterfree.R.layout.wheel_picker_item, viewGroup);
        }
        TextView textView = (TextView) view.findViewById(com.nexstreaming.app.kinemasterfree.R.id.text);
        if (textView != null) {
            CharSequence a2 = a(i);
            if (a2 == null) {
                a2 = "";
            }
            textView.setText(a2);
            textView.setTextSize(0, this.f23899f);
        }
        return view;
    }

    private CharSequence a(int i) {
        String[] strArr = this.f23894a;
        if (strArr == null || strArr.length <= i) {
            return null;
        }
        return strArr[i];
    }

    private View a(int i, ViewGroup viewGroup) {
        return this.f23896c.inflate(i, viewGroup, false);
    }

    public View a(View view, ViewGroup viewGroup) {
        return view == null ? a(com.nexstreaming.app.kinemasterfree.R.layout.wheel_picker_item, viewGroup) : view;
    }

    public void a(DataSetObserver dataSetObserver) {
        if (this.f23895b == null) {
            this.f23895b = new LinkedList();
        }
        this.f23895b.add(dataSetObserver);
    }
}
