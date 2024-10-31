package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class cj implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f3363a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ VideoEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(VideoEditor videoEditor, NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.c = videoEditor;
        this.f3363a = nexVideoClipItem;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        NexVideoClipItem nexVideoClipItem;
        nexVideoClipItem = this.c.Q;
        if (nexVideoClipItem == this.f3363a) {
            this.c.Q = null;
        }
        this.b.sendFailure(taskError);
    }
}
