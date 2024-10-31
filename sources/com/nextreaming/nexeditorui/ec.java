package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Process;

/* compiled from: RelaunchActivity.java */
/* loaded from: classes.dex */
class ec implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RelaunchActivity f4619a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(RelaunchActivity relaunchActivity) {
        this.f4619a = relaunchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        i = this.f4619a.f4503a;
        Process.killProcess(i);
        handler = this.f4619a.b;
        handler.postDelayed(new ed(this), 500L);
    }
}
