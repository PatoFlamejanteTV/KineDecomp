package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultTask.java */
/* loaded from: classes.dex */
public class a implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask.OnResultAvailableListener f3187a;
    final /* synthetic */ ResultTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ResultTask resultTask, ResultTask.OnResultAvailableListener onResultAvailableListener) {
        this.b = resultTask;
        this.f3187a = onResultAvailableListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ResultTask resultTask = (ResultTask) task;
        this.f3187a.onResultAvailable(resultTask, event, resultTask.getResult());
        this.b.removeListenerForFail();
    }
}
