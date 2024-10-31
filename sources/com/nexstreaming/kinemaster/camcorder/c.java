package com.nexstreaming.kinemaster.camcorder;

import android.widget.ImageButton;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3267a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageButton imageButton;
        imageButton = this.f3267a.f3266a.c;
        imageButton.setEnabled(true);
    }
}
