package com.nexstreaming.kinemaster.codeccaps.ui;

import android.os.Handler;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20125a = capabilityTestRunnerActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        CapabilityChecker capabilityChecker;
        CapabilityChecker capabilityChecker2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f20125a.O;
        if (currentTimeMillis - j > 360000) {
            capabilityChecker = this.f20125a.H;
            if (capabilityChecker != null) {
                capabilityChecker2 = this.f20125a.H;
                capabilityChecker2.a(true);
            }
            int max = this.f20125a.M.getMax();
            for (int progress = this.f20125a.M.getProgress(); progress <= max; progress++) {
                this.f20125a.M.setProgress(progress);
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
            CapabilityTestIntroActivity.H = true;
            return;
        }
        handler = this.f20125a.N;
        handler.postDelayed(this, 1000L);
    }
}
