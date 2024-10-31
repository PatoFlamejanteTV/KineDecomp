package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.Button;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4096a;
    final /* synthetic */ mh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mo(mh mhVar, String str) {
        this.b = mhVar;
        this.f4096a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Button button;
        boolean z;
        Button button2;
        Button button3;
        button = this.b.f4089a.e;
        if (button != null) {
            button2 = this.b.f4089a.e;
            button2.setText(this.f4096a);
            button3 = this.b.f4089a.e;
            button3.setEnabled(true);
        }
        z = this.b.f4089a.n;
        if (z) {
            this.b.f4089a.m = false;
        }
    }
}
