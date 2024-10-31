package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class dk implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f4600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(NexVideoClipItem nexVideoClipItem) {
        this.f4600a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4600a.l = false;
        this.f4600a.m = true;
    }
}
