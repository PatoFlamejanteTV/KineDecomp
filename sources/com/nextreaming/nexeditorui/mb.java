package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Process;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RelaunchActivity.java */
/* loaded from: classes.dex */
public class mb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RelaunchActivity f24317a;

    public mb(RelaunchActivity relaunchActivity) {
        this.f24317a = relaunchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        i = this.f24317a.f24166a;
        Process.killProcess(i);
        handler = this.f24317a.f24167b;
        handler.postDelayed(new lb(this), 500L);
    }
}
