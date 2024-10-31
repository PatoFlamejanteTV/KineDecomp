package com.nexstreaming.kinemaster.camcorder;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19997a;

    public i(CamcorderActivity camcorderActivity) {
        this.f19997a = camcorderActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        View view;
        boolean z2;
        TextView textView;
        Runnable runnable;
        StringBuilder sb;
        long j;
        TextView textView2;
        String str;
        boolean z3;
        TextView textView3;
        Runnable runnable2;
        CamcorderActivity camcorderActivity = this.f19997a;
        z = camcorderActivity.v;
        camcorderActivity.v = !z;
        view = this.f19997a.w;
        z2 = this.f19997a.v;
        view.setVisibility(z2 ? 0 : 4);
        textView = this.f19997a.o;
        runnable = this.f19997a.W;
        textView.removeCallbacks(runnable);
        CamcorderActivity camcorderActivity2 = this.f19997a;
        sb = camcorderActivity2.U;
        long nanoTime = System.nanoTime();
        j = this.f19997a.s;
        camcorderActivity2.J = DateUtils.formatElapsedTime(sb, (nanoTime - j) / 1000000000);
        textView2 = this.f19997a.o;
        str = this.f19997a.J;
        textView2.setText(str);
        z3 = this.f19997a.f19975g;
        if (z3) {
            textView3 = this.f19997a.o;
            runnable2 = this.f19997a.W;
            textView3.postDelayed(runnable2, 500L);
        }
    }
}
