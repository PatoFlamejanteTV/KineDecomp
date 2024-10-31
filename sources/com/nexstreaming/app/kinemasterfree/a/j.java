package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.C2073xd;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ClipInfoPopupBindingImpl.java */
/* loaded from: classes2.dex */
public class j extends i implements a.InterfaceC0101a {
    private static final ViewDataBinding.b E = null;
    private static final SparseIntArray F = new SparseIntArray();
    private final CoordinatorLayout G;
    private final View.OnClickListener H;
    private final View.OnClickListener I;
    private long J;

    static {
        F.put(R.id.container, 4);
    }

    public j(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 5, E, F));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.i
    public void a(NexTimelineItem nexTimelineItem) {
        this.D = nexTimelineItem;
        synchronized (this) {
            this.J |= 1;
        }
        notifyPropertyChanged(2);
        super.g();
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        long j;
        synchronized (this) {
            j = this.J;
            this.J = 0L;
        }
        NexTimelineItem nexTimelineItem = this.D;
        View.OnClickListener onClickListener = this.C;
        if ((5 & j) != 0) {
            C2073xd.a(this.z, nexTimelineItem);
            C2073xd.b(this.A, nexTimelineItem);
        }
        if ((j & 4) != 0) {
            this.A.setOnClickListener(this.I);
            this.B.setOnClickListener(this.H);
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.J != 0;
        }
    }

    public void i() {
        synchronized (this) {
            this.J = 4L;
        }
        g();
    }

    private j(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (CardView) objArr[4], (TextView) objArr[2], (TextView) objArr[1], (LinearLayout) objArr[3]);
        this.J = -1L;
        this.z.setTag(null);
        this.A.setTag(null);
        this.G = (CoordinatorLayout) objArr[0];
        this.G.setTag(null);
        this.B.setTag(null);
        b(view);
        this.H = new com.nexstreaming.app.kinemasterfree.b.a.a(this, 2);
        this.I = new com.nexstreaming.app.kinemasterfree.b.a.a(this, 1);
        i();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.i
    public void a(View.OnClickListener onClickListener) {
        this.C = onClickListener;
        synchronized (this) {
            this.J |= 2;
        }
        notifyPropertyChanged(5);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.b.a.a.InterfaceC0101a
    public final void a(int i, View view) {
        if (i == 1) {
            View.OnClickListener onClickListener = this.C;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        View.OnClickListener onClickListener2 = this.C;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }
}
