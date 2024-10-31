package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
class q implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task.MultiplexTask.OnAllTasksSignalledListener f19759a;

    /* renamed from: b */
    final /* synthetic */ Task.MultiplexTask f19760b;

    public q(Task.MultiplexTask multiplexTask, Task.MultiplexTask.OnAllTasksSignalledListener onAllTasksSignalledListener) {
        this.f19760b = multiplexTask;
        this.f19759a = onAllTasksSignalledListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task.MultiplexTask.OnAllTasksSignalledListener onAllTasksSignalledListener = this.f19759a;
        Task.MultiplexTask multiplexTask = this.f19760b;
        onAllTasksSignalledListener.onAllTasksSignalled(multiplexTask, multiplexTask.tasks, event);
    }
}
