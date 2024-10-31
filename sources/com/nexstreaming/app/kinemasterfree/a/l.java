package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: DeviceCapabilityProfileImporterBindingImpl.java */
/* loaded from: classes2.dex */
public class l extends k {
    private static final ViewDataBinding.b D = null;
    private static final SparseIntArray E = new SparseIntArray();
    private final LinearLayout F;
    private long G;

    static {
        E.put(R.id.toolbar_settings, 1);
        E.put(R.id.container, 2);
        E.put(R.id.db_list, 3);
        E.put(R.id.file_list, 4);
        E.put(R.id.progress, 5);
    }

    public l(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 6, D, E));
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        synchronized (this) {
            long j = this.G;
            this.G = 0L;
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
            this.G = 1L;
        }
        g();
    }

    private l(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (CoordinatorLayout) objArr[2], (RecyclerView) objArr[3], (RecyclerView) objArr[4], (ProgressBar) objArr[5], (Toolbar) objArr[1]);
        this.G = -1L;
        this.F = (LinearLayout) objArr[0];
        this.F.setTag(null);
        b(view);
        h();
    }
}
