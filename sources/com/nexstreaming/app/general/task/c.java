package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultTask.java */
/* loaded from: classes.dex */
public final class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3189a;
    final /* synthetic */ Map b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResultTask resultTask, Map map) {
        this.f3189a = resultTask;
        this.b = map;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3189a.sendFailure(taskError);
        this.b.clear();
    }
}
