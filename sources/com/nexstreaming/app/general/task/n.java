package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Task.java */
/* loaded from: classes2.dex */
public class n implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ Task.OnProgressListener f19753a;

    /* renamed from: b */
    final /* synthetic */ Task f19754b;

    public n(Task task, Task.OnProgressListener onProgressListener) {
        this.f19754b = task;
        this.f19753a = onProgressListener;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f19753a.onProgress(task, event, this.f19754b.getProgress(), this.f19754b.getMaxProgress());
    }
}
