package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Qa extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f20246a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20247b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(VideoEditor videoEditor, Task task) {
        this.f20247b = videoEditor;
        this.f20246a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        if (bVar.c()) {
            this.f20246a.sendFailure(bVar);
        } else {
            this.f20246a.signalEvent(Task.Event.SUCCESS);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a() {
        this.f20246a.signalEvent(Task.Event.COMPLETE);
    }
}
