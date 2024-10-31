package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.b.a.a;

/* compiled from: ItemDbProfileListBindingImpl.java */
/* loaded from: classes2.dex */
public class r extends q implements a.InterfaceC0101a {
    private static final ViewDataBinding.b B = null;
    private static final SparseIntArray C = null;
    private final CoordinatorLayout D;
    private final CardView E;
    private final View.OnClickListener F;
    private long G;

    public r(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 3, B, C));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.q
    public void a(View.OnClickListener onClickListener) {
        this.z = onClickListener;
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
        View.OnClickListener onClickListener = this.z;
        String str = this.A;
        long j2 = 6 & j;
        if ((j & 4) != 0) {
            this.E.setOnClickListener(this.F);
        }
        if (j2 != 0) {
            android.databinding.a.a.a(this.y, str);
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
            this.G = 4L;
        }
        g();
    }

    private r(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[2]);
        this.G = -1L;
        this.D = (CoordinatorLayout) objArr[0];
        this.D.setTag(null);
        this.E = (CardView) objArr[1];
        this.E.setTag(null);
        this.y.setTag(null);
        b(view);
        this.F = new com.nexstreaming.app.kinemasterfree.b.a.a(this, 1);
        h();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.q
    public void a(String str) {
        this.A = str;
        synchronized (this) {
            this.G |= 2;
        }
        notifyPropertyChanged(3);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.b.a.a.InterfaceC0101a
    public final void a(int i, View view) {
        View.OnClickListener onClickListener = this.z;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
