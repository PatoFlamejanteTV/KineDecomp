package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public final class f implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Task task) {
        this.f3191a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3191a.sendFailure(taskError);
    }
}
