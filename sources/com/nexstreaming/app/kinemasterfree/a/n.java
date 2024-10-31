package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.CardView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b.a.a;

/* compiled from: FragmentAdviewAdmobBindingImpl.java */
/* loaded from: classes2.dex */
public class n extends m implements a.InterfaceC0101a {
    private static final ViewDataBinding.b C = null;
    private static final SparseIntArray D = new SparseIntArray();
    private final RelativeLayout E;
    private final View.OnClickListener F;
    private long G;

    static {
        D.put(R.id.popup, 2);
        D.put(R.id.container, 3);
    }

    public n(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 4, C, D));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.m
    public void a(View.OnClickListener onClickListener) {
        this.B = onClickListener;
        synchronized (this) {
            this.G |= 1;
        }
        notifyPropertyChanged(5);
        super.g();
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        long j;
        synchronized (this) {
            j = this.G;
            this.G = 0L;
        }
        View.OnClickListener onClickListener = this.B;
        if ((j & 2) != 0) {
            this.y.setOnClickListener(this.F);
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.G != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.G = 2L;
        }
        g();
    }

    private n(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageButton) objArr[1], (RelativeLayout) objArr[3], (CardView) objArr[2]);
        this.G = -1L;
        this.y.setTag(null);
        this.E = (RelativeLayout) objArr[0];
        this.E.setTag(null);
        b(view);
        this.F = new com.nexstreaming.app.kinemasterfree.b.a.a(this, 1);
        h();
    }

    @Override // com.nexstreaming.app.kinemasterfree.b.a.a.InterfaceC0101a
    public final void a(int i, View view) {
        View.OnClickListener onClickListener = this.B;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
