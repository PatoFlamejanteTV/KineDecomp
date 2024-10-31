package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraceLog.java */
/* loaded from: classes.dex */
public final class p implements Task.OnFailListener {
    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task task2;
        task2 = o.f3218a;
        task2.sendFailure(taskError);
    }
}
