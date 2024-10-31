package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class c implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f4828a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NexEditor nexEditor) {
        this.f4828a = nexEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task task2;
        task2 = this.f4828a.P;
        task2.sendFailure(taskError);
    }
}
