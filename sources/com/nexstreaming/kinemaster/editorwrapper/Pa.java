package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Pa extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f20243a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20244b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pa(VideoEditor videoEditor, Task task) {
        this.f20244b = videoEditor;
        this.f20243a = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        if (bVar.c()) {
            this.f20243a.sendFailure(bVar);
        } else {
            this.f20243a.signalEvent(Task.Event.SUCCESS);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a() {
        C1730a c1730a;
        c1730a = this.f20244b.N;
        c1730a.a(new Oa(this), 3);
        this.f20243a.signalEvent(Task.Event.COMPLETE);
    }
}
