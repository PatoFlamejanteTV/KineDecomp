package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

/* compiled from: WheelRecycle.java */
/* loaded from: classes2.dex */
public class z {

    /* renamed from: a */
    private List<View> f23900a;

    /* renamed from: b */
    private List<View> f23901b;

    /* renamed from: c */
    private WheelPicker f23902c;

    public z(WheelPicker wheelPicker) {
        this.f23902c = wheelPicker;
    }

    public int a(LinearLayout linearLayout, int i, h hVar) {
        int i2 = 0;
        int i3 = i;
        while (i2 < linearLayout.getChildCount()) {
            if (hVar.a(i3)) {
                i2++;
            } else {
                a(linearLayout.getChildAt(i2), i3);
                linearLayout.removeViewAt(i2);
                if (i2 == 0) {
                    i++;
                }
            }
            i3++;
        }
        return i;
    }

    public View b() {
        return a(this.f23901b);
    }

    public View c() {
        return a(this.f23900a);
    }

    public void a() {
        List<View> list = this.f23900a;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.f23901b;
        if (list2 != null) {
            list2.clear();
        }
    }

    private List<View> a(View view, List<View> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(view);
        return list;
    }

    private void a(View view, int i) {
        int a2 = this.f23902c.getViewAdapter().a();
        if (i >= 0 && i < a2) {
            while (i < 0) {
                i += a2;
            }
            int i2 = i % a2;
            this.f23900a = a(view, this.f23900a);
            return;
        }
        this.f23901b = a(view, this.f23901b);
    }

    private View a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = list.get(0);
        list.remove(0);
        return view;
    }
}
