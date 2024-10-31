package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bd extends NexEditor.o {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3331a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(VideoEditor videoEditor, Task task) {
        this.b = videoEditor;
        this.f3331a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.o
    public void a(NexEditor.b bVar) {
        if (bVar.a()) {
            this.f3331a.sendFailure(bVar);
        } else {
            this.f3331a.signalEvent(Task.Event.SUCCESS);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.o
    public void a() {
        a aVar;
        aVar = this.b.M;
        aVar.a(new be(this), 3);
        this.f3331a.signalEvent(Task.Event.COMPLETE);
    }
}
