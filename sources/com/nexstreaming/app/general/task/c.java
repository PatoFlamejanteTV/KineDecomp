package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Map;

/* compiled from: ResultTask.java */
/* loaded from: classes2.dex */
public class c implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ ResultTask f19737a;

    /* renamed from: b */
    final /* synthetic */ Map f19738b;

    public c(ResultTask resultTask, Map map) {
        this.f19737a = resultTask;
        this.f19738b = map;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19737a.sendFailure(taskError);
        this.f19738b.clear();
    }
}
