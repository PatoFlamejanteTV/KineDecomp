package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ItemDbProfileListBinding.java */
/* loaded from: classes2.dex */
public abstract class q extends ViewDataBinding {
    protected String A;
    public final TextView y;
    protected View.OnClickListener z;

    public q(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.y = textView;
    }

    public static q a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a(layoutInflater, viewGroup, z, android.databinding.e.a());
    }

    public abstract void a(View.OnClickListener onClickListener);

    public abstract void a(String str);

    @Deprecated
    public static q a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (q) ViewDataBinding.a(layoutInflater, R.layout.item_db_profile_list, viewGroup, z, obj);
    }
}
