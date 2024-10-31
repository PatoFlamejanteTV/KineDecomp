package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class bb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NexVideoClipItem nexVideoClipItem) {
        this.f24216a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f24216a.k = false;
        if (taskError == NexEditor.b.D || taskError == NexEditor.b.L) {
            return;
        }
        this.f24216a.l = true;
    }
}
