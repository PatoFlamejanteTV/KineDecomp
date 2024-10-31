package com.nexstreaming.kinemaster.camcorder;

import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ c f19989a;

    public b(c cVar) {
        this.f19989a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageButton imageButton;
        imageButton = this.f19989a.f19990a.f19971c;
        imageButton.setEnabled(true);
    }
}
