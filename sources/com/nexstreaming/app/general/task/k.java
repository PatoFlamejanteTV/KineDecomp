package com.nexstreaming.app.general.task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f19748a;

    public k(Task task) {
        this.f19748a = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f19748a.isRunning()) {
            this.f19748a.sendFailure(Task.TIMEOUT);
        }
        this.f19748a.mTimeoutRunnable = null;
        this.f19748a.mHandler = null;
    }
}
