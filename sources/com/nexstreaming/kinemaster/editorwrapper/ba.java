package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleClipPreview.java */
/* loaded from: classes.dex */
public class Ba extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f20181c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Da f20182d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(Da da, Task task) {
        this.f20182d = da;
        this.f20181c = task;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        this.f20181c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        this.f20181c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
