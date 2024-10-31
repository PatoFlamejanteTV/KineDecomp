package com.nexstreaming.kinemaster.codeccaps.ui;

import com.nexstreaming.app.general.task.Task;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class i implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityTestRunnerActivity f20130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CapabilityTestRunnerActivity capabilityTestRunnerActivity) {
        this.f20130a = capabilityTestRunnerActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f20130a.M.setMax(i2);
        this.f20130a.M.setProgress(i);
    }
}
