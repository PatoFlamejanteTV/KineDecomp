package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bf extends NexEditor.o {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3333a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(VideoEditor videoEditor, Task task) {
        this.b = videoEditor;
        this.f3333a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.o
    public void a(NexEditor.b bVar) {
        if (bVar.a()) {
            this.f3333a.sendFailure(bVar);
        } else {
            this.f3333a.signalEvent(Task.Event.SUCCESS);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.o
    public void a() {
        this.f3333a.signalEvent(Task.Event.COMPLETE);
    }
}
