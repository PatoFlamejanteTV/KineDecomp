package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ResultTask.java */
/* loaded from: classes2.dex */
public class a implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ ResultTask.OnResultAvailableListener f19733a;

    /* renamed from: b */
    final /* synthetic */ ResultTask f19734b;

    public a(ResultTask resultTask, ResultTask.OnResultAvailableListener onResultAvailableListener) {
        this.f19734b = resultTask;
        this.f19733a = onResultAvailableListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ResultTask resultTask = (ResultTask) task;
        this.f19733a.onResultAvailable(resultTask, event, resultTask.getResult());
        this.f19734b.removeListenerForFail();
    }
}
