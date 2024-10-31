package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bc extends NexEditor.g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3330a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(VideoEditor videoEditor, Task task) {
        this.b = videoEditor;
        this.f3330a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.g
    public void a(NexEditor.b bVar) {
        if (bVar.a()) {
            this.f3330a.sendFailure(bVar);
        } else {
            this.f3330a.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}
