package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bb extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3329a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(VideoEditor videoEditor, Task task) {
        this.b = videoEditor;
        this.f3329a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(int i) {
        this.f3329a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        this.f3329a.sendFailure(bVar);
    }
}
