package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ResultTask.java */
/* loaded from: classes2.dex */
public class b implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ ResultTask.OnResultAvailableListener f19735a;

    /* renamed from: b */
    final /* synthetic */ ResultTask f19736b;

    public b(ResultTask resultTask, ResultTask.OnResultAvailableListener onResultAvailableListener) {
        this.f19736b = resultTask;
        this.f19735a = onResultAvailableListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ResultTask resultTask = (ResultTask) task;
        this.f19735a.onResultAvailable(resultTask, event, resultTask.getResult());
    }
}
