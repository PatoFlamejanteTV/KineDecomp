package com.nexstreaming.app.general.task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Task task) {
        this.f3193a = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3193a.isRunning()) {
            this.f3193a.sendFailure(Task.TIMEOUT);
        }
        this.f3193a.mTimeoutRunnable = null;
        this.f3193a.mHandler = null;
    }
}
