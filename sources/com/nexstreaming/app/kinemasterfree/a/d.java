package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;

/* compiled from: ActivityPermissionRationaleBindingImpl.java */
/* loaded from: classes2.dex */
public class d extends c {
    private static final ViewDataBinding.b E = null;
    private static final SparseIntArray F = new SparseIntArray();
    private final RelativeLayout G;
    private long H;

    static {
        F.put(R.id.permission_container, 1);
        F.put(R.id.permission_contentPrimary, 2);
        F.put(R.id.permission_contentSecondary, 3);
        F.put(R.id.permission_buttonCancel, 4);
        F.put(R.id.permission_buttonAppInfo, 5);
        F.put(R.id.permission_buttonAllow, 6);
    }

    public d(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 7, E, F));
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        synchronized (this) {
            long j = this.H;
            this.H = 0L;
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.H != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.H = 1L;
        }
        g();
    }

    private d(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TransparentTextButton) objArr[6], (TransparentTextButton) objArr[5], (TransparentTextButton) objArr[4], (LinearLayout) objArr[1], (TextView) objArr[2], (TextView) objArr[3]);
        this.H = -1L;
        this.G = (RelativeLayout) objArr[0];
        this.G.setTag(null);
        b(view);
        h();
    }
}
