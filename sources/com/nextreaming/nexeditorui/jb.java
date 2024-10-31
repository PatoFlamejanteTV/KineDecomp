package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class jb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f24303a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24304b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jb(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f24304b = nexVideoClipItem;
        this.f24303a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f24303a.sendFailure(taskError);
    }
}
