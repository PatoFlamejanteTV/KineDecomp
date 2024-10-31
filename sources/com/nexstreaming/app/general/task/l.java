package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.OnProgressListener f3195a;
    final /* synthetic */ Task b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Task task, Task.OnProgressListener onProgressListener) {
        this.b = task;
        this.f3195a = onProgressListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3195a.onProgress(task, event, this.b.getProgress(), this.b.getMaxProgress());
    }
}
