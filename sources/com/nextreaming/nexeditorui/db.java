package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class db implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f4591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(NexVideoClipItem nexVideoClipItem) {
        this.f4591a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4591a.i = false;
        if (taskError != NexEditor.b.C) {
            this.f4591a.j = true;
        }
    }
}
