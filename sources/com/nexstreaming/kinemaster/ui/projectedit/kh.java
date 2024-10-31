package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class kh implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f4032a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kh(ProjectEditActivity projectEditActivity, Task task) {
        this.b = projectEditActivity;
        this.f4032a = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4032a.signalEvent(Task.Event.FAIL);
    }
}
