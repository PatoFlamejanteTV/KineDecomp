package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.nexstreaming.kinemaster.ui.projectedit.AudioLevelMeter;

/* compiled from: AudioLevelMeterFragmentBindingImpl.java */
/* loaded from: classes2.dex */
public class f extends e {
    private static final ViewDataBinding.b D = null;
    private static final SparseIntArray E = null;
    private long F;

    public f(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 3, D, E));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.e
    public void a(int i) {
        this.B = i;
        synchronized (this) {
            this.F |= 2;
        }
        notifyPropertyChanged(4);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.e
    public void b(int i) {
        this.C = i;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(6);
        super.g();
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        long j;
        synchronized (this) {
            j = this.F;
            this.F = 0L;
        }
        int i = this.C;
        int i2 = this.B;
        long j2 = 5 & j;
        if ((j & 6) != 0) {
            this.y.setLevel(i2);
        }
        if (j2 != 0) {
            this.A.setLevel(i);
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.F != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.F = 4L;
        }
        g();
    }

    private f(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (AudioLevelMeter) objArr[1], (LinearLayout) objArr[0], (AudioLevelMeter) objArr[2]);
        this.F = -1L;
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        b(view);
        h();
    }
}
