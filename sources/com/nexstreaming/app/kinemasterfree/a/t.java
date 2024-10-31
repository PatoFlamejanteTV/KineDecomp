package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.b.a.a;

/* compiled from: ItemFileProfileListBindingImpl.java */
/* loaded from: classes2.dex */
public class t extends s implements a.InterfaceC0101a {
    private static final ViewDataBinding.b D = null;
    private static final SparseIntArray E = null;
    private final LinearLayout F;
    private final LinearLayout G;
    private final View.OnClickListener H;
    private long I;

    public t(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 4, D, E));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.s
    public void a(View.OnClickListener onClickListener) {
        this.A = onClickListener;
        synchronized (this) {
            this.I |= 2;
        }
        notifyPropertyChanged(5);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.s
    public void b(String str) {
        this.C = str;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(1);
        super.g();
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        long j;
        synchronized (this) {
            j = this.I;
            this.I = 0L;
        }
        String str = this.C;
        View.OnClickListener onClickListener = this.A;
        String str2 = this.B;
        long j2 = 9 & j;
        long j3 = 12 & j;
        if ((j & 8) != 0) {
            this.G.setOnClickListener(this.H);
        }
        if (j3 != 0) {
            android.databinding.a.a.a(this.y, str2);
        }
        if (j2 != 0) {
            android.databinding.a.a.a(this.z, str);
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.I != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.I = 8L;
        }
        g();
    }

    private t(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[2], (TextView) objArr[3]);
        this.I = -1L;
        this.F = (LinearLayout) objArr[0];
        this.F.setTag(null);
        this.G = (LinearLayout) objArr[1];
        this.G.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        b(view);
        this.H = new com.nexstreaming.app.kinemasterfree.b.a.a(this, 1);
        h();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.s
    public void a(String str) {
        this.B = str;
        synchronized (this) {
            this.I |= 4;
        }
        notifyPropertyChanged(3);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.b.a.a.InterfaceC0101a
    public final void a(int i, View view) {
        View.OnClickListener onClickListener = this.A;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
