package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class La extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f20216c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20217d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(VideoEditor videoEditor, Task task) {
        this.f20217d = videoEditor;
        this.f20216c = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        this.f20216c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        this.f20216c.sendFailure(bVar);
    }
}
