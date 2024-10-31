package com.nexstreaming.kinemaster.camcorder;

import android.widget.ImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CamcorderActivity camcorderActivity) {
        this.f3273a = camcorderActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageButton imageButton;
        imageButton = this.f3273a.c;
        imageButton.setEnabled(true);
    }
}
