package com.nexstreaming.kinemaster.camcorder;

import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f20000a;

    public k(CamcorderActivity camcorderActivity) {
        this.f20000a = camcorderActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageButton imageButton;
        imageButton = this.f20000a.f19971c;
        imageButton.setEnabled(true);
    }
}
