package com.nexstreaming.kinemaster.codeccaps.ui;

import com.nexstreaming.app.general.task.Task;

/* compiled from: CapabilityTestRunnerActivity.java */
/* loaded from: classes.dex */
class k implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f20132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar) {
        this.f20132a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20132a.f20133a.log(">> RESULTS REGISTERED: OK <<");
    }
}
