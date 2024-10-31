package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class pb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f20344a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f20345b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pb(VideoEditor videoEditor, NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f20346c = videoEditor;
        this.f20344a = nexVideoClipItem;
        this.f20345b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        NexVideoClipItem nexVideoClipItem;
        nexVideoClipItem = this.f20346c.W;
        if (nexVideoClipItem == this.f20344a) {
            this.f20346c.W = null;
        }
        this.f20345b.sendFailure(taskError);
    }
}
