package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class l implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task.OnFailListener f19749a;

    /* renamed from: b */
    final /* synthetic */ Task f19750b;

    public l(Task task, Task.OnFailListener onFailListener) {
        this.f19750b = task;
        this.f19749a = onFailListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f19749a.onFail(task, event, this.f19750b.getTaskError());
    }
}
