package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: DeviceCapabilityProfileImporterBinding.java */
/* loaded from: classes2.dex */
public abstract class k extends ViewDataBinding {
    public final RecyclerView A;
    public final ProgressBar B;
    public final Toolbar C;
    public final CoordinatorLayout y;
    public final RecyclerView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(Object obj, View view, int i, CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ProgressBar progressBar, Toolbar toolbar) {
        super(obj, view, i);
        this.y = coordinatorLayout;
        this.z = recyclerView;
        this.A = recyclerView2;
        this.B = progressBar;
        this.C = toolbar;
    }
}
