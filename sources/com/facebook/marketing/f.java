package com.facebook.marketing;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ViewIndexer.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TimerTask f9437a;

    /* renamed from: b */
    final /* synthetic */ ViewIndexer f9438b;

    public f(ViewIndexer viewIndexer, TimerTask timerTask) {
        this.f9438b = viewIndexer;
        this.f9437a = timerTask;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Timer timer;
        Timer timer2;
        Timer timer3;
        try {
            timer = this.f9438b.indexingTimer;
            if (timer != null) {
                timer3 = this.f9438b.indexingTimer;
                timer3.cancel();
            }
            this.f9438b.previousDigest = null;
            this.f9438b.indexingTimer = new Timer();
            timer2 = this.f9438b.indexingTimer;
            timer2.scheduleAtFixedRate(this.f9437a, 0L, 1000L);
        } catch (Exception e2) {
            str = ViewIndexer.TAG;
            Log.e(str, "Error scheduling indexing job", e2);
        }
    }
}
