package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ItemFileProfileListBinding.java */
/* loaded from: classes2.dex */
public abstract class s extends ViewDataBinding {
    protected View.OnClickListener A;
    protected String B;
    protected String C;
    public final TextView y;
    public final TextView z;

    public s(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.y = textView;
        this.z = textView2;
    }

    public static s a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a(layoutInflater, viewGroup, z, android.databinding.e.a());
    }

    public abstract void a(View.OnClickListener onClickListener);

    public abstract void a(String str);

    public abstract void b(String str);

    @Deprecated
    public static s a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (s) ViewDataBinding.a(layoutInflater, R.layout.item_file_profile_list, viewGroup, z, obj);
    }
}
