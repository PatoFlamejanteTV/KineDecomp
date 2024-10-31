package com.nexstreaming.kinemaster.codeccaps.ui;

import com.nexstreaming.app.general.task.Task;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class j implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f20131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(l lVar) {
        this.f20131a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20131a.f20133a.log("!! Result registration failed: " + taskError.getMessage());
    }
}
