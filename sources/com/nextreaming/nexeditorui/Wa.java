package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class Wa implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f24185a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24186b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f24186b = nexVideoClipItem;
        this.f24185a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f24185a.sendFailure(taskError);
    }
}
