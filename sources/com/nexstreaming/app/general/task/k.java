package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class k implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.OnFailListener f3194a;
    final /* synthetic */ Task b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Task task, Task.OnFailListener onFailListener) {
        this.b = task;
        this.f3194a = onFailListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3194a.onFail(task, event, this.b.getTaskError());
    }
}
