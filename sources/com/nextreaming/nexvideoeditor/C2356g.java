package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2356g implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f24711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2356g(NexEditor nexEditor) {
        this.f24711a = nexEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Task task2;
        task2 = this.f24711a.Y;
        task2.sendFailure(taskError);
    }
}
