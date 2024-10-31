package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ma extends NexEditor.g {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Task f20218b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20219c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(VideoEditor videoEditor, Task task) {
        this.f20219c = videoEditor;
        this.f20218b = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.g
    public void a(NexEditor.b bVar) {
        if (bVar.c()) {
            this.f20218b.sendFailure(bVar);
        } else {
            this.f20218b.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}
