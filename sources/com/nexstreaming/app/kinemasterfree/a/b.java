package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.design.widget.CoordinatorLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: ActivityAssetUpdateBindingImpl.java */
/* loaded from: classes2.dex */
public class b extends a {
    private static final ViewDataBinding.b A = null;
    private static final SparseIntArray B = new SparseIntArray();
    private final CoordinatorLayout C;
    private long D;

    static {
        B.put(R.id.container, 1);
        B.put(R.id.progress, 2);
    }

    public b(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 3, A, B));
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        synchronized (this) {
            long j = this.D;
            this.D = 0L;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.D != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.D = 1L;
        }
        g();
    }

    private b(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (LinearLayout) objArr[1], (ProgressBar) objArr[2]);
        this.D = -1L;
        this.C = (CoordinatorLayout) objArr[0];
        this.C.setTag(null);
        b(view);
        h();
    }
}
