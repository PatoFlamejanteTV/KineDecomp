package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class at implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4528a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(af afVar, ResultTask resultTask) {
        this.b = afVar;
        this.f4528a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4528a.setTaskError(taskError);
        this.f4528a.signalEvent(Task.Event.FAIL);
        this.b.m = false;
    }
}
