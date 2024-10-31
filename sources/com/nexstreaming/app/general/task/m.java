package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class m implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task f19751a;

    /* renamed from: b */
    final /* synthetic */ Task f19752b;

    public m(Task task, Task task2) {
        this.f19752b = task;
        this.f19751a = task2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f19751a.sendFailure(this.f19752b.getTaskError());
    }
}
