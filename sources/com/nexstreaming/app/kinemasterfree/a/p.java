package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* compiled from: FragmentTrackOptionBindingImpl.java */
/* loaded from: classes2.dex */
public class p extends o {
    private static final ViewDataBinding.b y = null;
    private static final SparseIntArray z = null;
    private final FrameLayout A;
    private final LinearLayout B;
    private long C;

    public p(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 2, y, z));
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        synchronized (this) {
            long j = this.C;
            this.C = 0L;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.C != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.C = 1L;
        }
        g();
    }

    private p(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0);
        this.C = -1L;
        this.A = (FrameLayout) objArr[0];
        this.A.setTag(null);
        this.B = (LinearLayout) objArr[1];
        this.B.setTag(null);
        b(view);
        h();
    }
}
