package com.nexstreaming.app.general.util;

import android.os.SystemClock;
import android.view.View;

/* compiled from: OnSingleClickListener.java */
/* loaded from: classes2.dex */
public abstract class A implements View.OnClickListener {

    /* renamed from: a */
    private long f19797a = 0;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.f19797a;
        this.f19797a = uptimeMillis;
        if (j <= 600) {
            return;
        }
        a(view);
    }
}
