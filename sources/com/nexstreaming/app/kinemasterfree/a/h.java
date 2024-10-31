package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.AudioLevelMeter;

/* compiled from: CamcorderMainActivityBindingImpl.java */
/* loaded from: classes2.dex */
public class h extends g {
    private static final ViewDataBinding.b Q = null;
    private static final SparseIntArray R = new SparseIntArray();
    private final RelativeLayout S;
    private long T;

    static {
        R.put(R.id.camera_preview_holder, 3);
        R.put(R.id.levelContainer, 4);
        R.put(R.id.btn_rec, 5);
        R.put(R.id.btn_switch, 6);
        R.put(R.id.btn_flash, 7);
        R.put(R.id.cur_resolution_holder, 8);
        R.put(R.id.settings_icon, 9);
        R.put(R.id.cur_resolution, 10);
        R.put(R.id.record_time_holder, 11);
        R.put(R.id.rec_icon, 12);
        R.put(R.id.record_time, 13);
        R.put(R.id.touch_blocker, 14);
        R.put(R.id.res_list, 15);
        R.put(R.id.busyCover, 16);
    }

    public h(android.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.a(dVar, view, 17, Q, R));
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.g
    public void a(int i) {
        this.O = i;
        synchronized (this) {
            this.T |= 1;
        }
        notifyPropertyChanged(4);
        super.g();
    }

    @Override // com.nexstreaming.app.kinemasterfree.a.g
    public void b(int i) {
        this.P = i;
        synchronized (this) {
            this.T |= 2;
        }
        notifyPropertyChanged(6);
        super.g();
    }

    @Override // android.databinding.ViewDataBinding
    protected void c() {
        long j;
        synchronized (this) {
            j = this.T;
            this.T = 0L;
        }
        int i = this.O;
        int i2 = this.P;
        long j2 = 5 & j;
        long j3 = j & 6;
        if (j2 != 0) {
            this.F.setLevel(i);
        }
        if (j3 != 0) {
            this.L.setLevel(i2);
        }
    }

    @Override // android.databinding.ViewDataBinding
    public boolean f() {
        synchronized (this) {
            return this.T != 0;
        }
    }

    public void h() {
        synchronized (this) {
            this.T = 4L;
        }
        g();
    }

    private h(android.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageButton) objArr[7], (ImageButton) objArr[5], (ImageButton) objArr[6], (View) objArr[16], (FrameLayout) objArr[3], (TextView) objArr[10], (LinearLayout) objArr[8], (AudioLevelMeter) objArr[1], (LinearLayout) objArr[4], (ImageView) objArr[12], (TextView) objArr[13], (LinearLayout) objArr[11], (ListView) objArr[15], (AudioLevelMeter) objArr[2], (ImageView) objArr[9], (View) objArr[14]);
        this.T = -1L;
        this.F.setTag(null);
        this.S = (RelativeLayout) objArr[0];
        this.S.setTag(null);
        this.L.setTag(null);
        b(view);
        h();
    }
}
