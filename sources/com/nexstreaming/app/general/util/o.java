package com.nexstreaming.app.general.util;

import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

/* compiled from: ViewUtil.java */
/* loaded from: classes2.dex */
public class O {
    public static boolean a(View view) {
        if ((view instanceof ListView) || (view instanceof ScrollView) || (view instanceof GridView) || (view instanceof AbsListView)) {
            return true;
        }
        return view != null && (view.isScrollContainer() || a(view.getParent()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(ViewParent viewParent) {
        if ((viewParent instanceof ListView) || (viewParent instanceof ScrollView) || (viewParent instanceof GridView) || (viewParent instanceof AbsListView)) {
            return true;
        }
        return viewParent != 0 && (((viewParent instanceof View) && ((View) viewParent).isScrollContainer()) || a(viewParent.getParent()));
    }
}
