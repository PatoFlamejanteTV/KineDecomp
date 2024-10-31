package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes.dex */
class p implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.MultiplexTask.OnAllTasksSignalledListener f3199a;
    final /* synthetic */ Task.MultiplexTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Task.MultiplexTask multiplexTask, Task.MultiplexTask.OnAllTasksSignalledListener onAllTasksSignalledListener) {
        this.b = multiplexTask;
        this.f3199a = onAllTasksSignalledListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3199a.onAllTasksSignalled(this.b, this.b.tasks, event);
    }
}
