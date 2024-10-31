package com.bumptech.glide.load.engine.c;

import android.os.Process;
import android.os.StrictMode;
import com.bumptech.glide.load.engine.c.b;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
class a extends Thread {

    /* renamed from: a */
    final /* synthetic */ b.a f8869a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a aVar, Runnable runnable, String str) {
        super(runnable, str);
        this.f8869a = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(9);
        if (this.f8869a.f8875c) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.f8869a.f8874b.a(th);
        }
    }
}
