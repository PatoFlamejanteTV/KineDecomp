package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleClipPreview.java */
/* loaded from: classes.dex */
public class au extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3322a;
    final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, Task task) {
        this.b = atVar;
        this.f3322a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(int i) {
        this.f3322a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        this.f3322a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
