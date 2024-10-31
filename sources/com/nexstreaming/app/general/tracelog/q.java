package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraceLog.java */
/* loaded from: classes.dex */
public final class q implements ResultTask.OnResultAvailableListener<RegisterAppResponse> {
    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<RegisterAppResponse> resultTask, Task.Event event, RegisterAppResponse registerAppResponse) {
        Task task;
        task = o.f3218a;
        task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
