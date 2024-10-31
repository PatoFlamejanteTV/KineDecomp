package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class f implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ Task f19744a;

    public f(Task task) {
        this.f19744a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19744a.sendFailure(taskError);
    }
}
