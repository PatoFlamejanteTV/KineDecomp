package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultTask.java */
/* loaded from: classes.dex */
public class b implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask.OnResultAvailableListener f3188a;
    final /* synthetic */ ResultTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ResultTask resultTask, ResultTask.OnResultAvailableListener onResultAvailableListener) {
        this.b = resultTask;
        this.f3188a = onResultAvailableListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ResultTask resultTask = (ResultTask) task;
        this.f3188a.onResultAvailable(resultTask, event, resultTask.getResult());
    }
}
