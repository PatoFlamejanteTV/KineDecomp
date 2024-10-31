package com.nexstreaming.kinemaster.camcorder;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3272a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CamcorderActivity camcorderActivity) {
        this.f3272a = camcorderActivity;
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
        CamcorderActivity camcorderActivity = this.f3272a;
        z = this.f3272a.v;
        camcorderActivity.v = !z;
        view = this.f3272a.w;
        z2 = this.f3272a.v;
        view.setVisibility(z2 ? 0 : 4);
        textView = this.f3272a.o;
        runnable = this.f3272a.Q;
        textView.removeCallbacks(runnable);
        CamcorderActivity camcorderActivity2 = this.f3272a;
        sb = this.f3272a.P;
        long nanoTime = System.nanoTime();
        j = this.f3272a.s;
        camcorderActivity2.J = DateUtils.formatElapsedTime(sb, (nanoTime - j) / 1000000000);
        textView2 = this.f3272a.o;
        str = this.f3272a.J;
        textView2.setText(str);
        z3 = this.f3272a.g;
        if (z3) {
            textView3 = this.f3272a.o;
            runnable2 = this.f3272a.Q;
            textView3.postDelayed(runnable2, 500L);
        }
    }
}
